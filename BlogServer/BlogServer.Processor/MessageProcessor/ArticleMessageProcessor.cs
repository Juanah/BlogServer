using System;
using BlogServer.DataAccess;
using log4net;
using BlogServer.Common;
using Newtonsoft.Json;
using System.Linq;

namespace BlogServer.Processor
{
	public class ArticleMessageProcessor
	{
		private ArticleRepository _repository;
		private UserRepository _userRepo;
		private ILog _log = LogManager.GetLogger(typeof(ArticleMessageProcessor));


		public ArticleMessageProcessor (BlogServer.DataAccess.ArticleRepository _repository, BlogServer.DataAccess.UserRepository _userRepo)
		{
			this._repository = _repository;
			this._userRepo = _userRepo;
		}

		public ArticleAddResponse Add(string message)
		{
			var response = new ArticleAddResponse () {
				IsAdded = false
			};
			ArticleAdd addMessage;
			try {
				addMessage = JsonConvert.DeserializeObject<ArticleAdd>(message);
			} catch (Exception ex) {
				_log.Warn (String.Format ("Parsing {0} fired Exception:",message) + ex);
				return response;
			}
			if (addMessage == null) {
				_log.Warn ("could not parse addMessage");
				return response;
			}
			if (!_userRepo.UserIsValid (addMessage.Article.Creator)) {
				return response;
			}
			BlogImage image = new BlogImage ();
			if (addMessage.Article.ImageBytes != null) {
				image.Path = ImageHelper.SaveImage (addMessage.Article.ImageBytes);
			} else {
				image.Path = "";
			}
			Article parsedArticle = new Article () {
				Content = addMessage.Article.Content,
				Creator = _userRepo.User.FirstOrDefault(na => na.Authentification.Equals(addMessage.Article.Creator.Authentification)),
				Image = image
			};
			_repository.AddArticle (parsedArticle);
			response.IsAdded = true;
			response.TempId = parsedArticle.GetId ();
			return response;
		}


	}
}

