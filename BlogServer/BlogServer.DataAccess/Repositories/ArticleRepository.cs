using System;
using Core;
using log4net;
using BlogServer.Common;
using System.Collections.Generic;

namespace BlogServer.DataAccess
{
	/// <summary>
	/// Handles the Article Entities
	/// </summary>
	public class ArticleRepository
	{
		private Context _context;
		private ILog _log = LogManager.GetLogger(typeof(ArticleRepository));
		private List<Article> _articles;

		public ArticleRepository (Core.Context _context)
		{
			this._context = _context;
			if (_articles == null) {
				GetAllArticles ();
			}
		}

		private void GetAllArticles()
		{
			_articles = _context.GetTable<Article> (typeof(Article));
			_log.Info ("Get Articles from Database");
		}

		public List<Article> Articles
		{
			get{ return _articles;}
		}

		public void AddArticle(Article article)
		{
			if (!_context.Insert<Article> (article)) {
				_log.Warn ("Could not write Article into Database");
			} else {
				GetAllArticles ();
				_log.Info ("Added Article from:" + article.Creator.Username);
			}
		}

		public void UpdateArticle(Article article)
		{
			if (!_context.Update<Article> (article)) {
				_log.Warn (String.Format ("Article from {0} could not be updated", article.Creator.Username));
			} else {
				GetAllArticles ();
				_log.Info (String.Format ("Article from {0} has been deleted", article.Creator.Username));
			}
		}

		public void DeleteArticle(Article article)
		{
			if (!_context.Delete<Article> (article)) {
				_log.Warn (String.Format ("Article from {0} could not be deleted!", article.Creator.Username));
			} else {
				GetAllArticles ();
				_log.Info (String.Format ("Article from {0} has been deleted!", article.Creator.Username));
			}
		}

	}
}

