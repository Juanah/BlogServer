using System;
using Core;
using BlogServer.Common;
using System.Collections.Generic;
using log4net;
using System.Linq;

namespace BlogServer.DataAccess
{
	/// <summary>
	/// Handels the Entity Comment
	/// </summary>
	public class CommentRepository
	{
		private Context _context;
		private List<Comment> _comments;
		private ILog _log = LogManager.GetLogger(typeof(CommentRepository));

		public CommentRepository (Context _context)
		{
			this._context = _context;
			if (_comments == null) {
				RefreshData ();
			}
		}

		private void RefreshData()
		{
			_comments = _context.GetTable<Comment> (typeof(Comment));
			_log.Info ("Get all Comments from Database");
		}

		public List<Comment> Comments
		{
			get{ return _comments;}
		}

		public void AddComment(Comment comment)
		{
			if (!_context.Insert<Comment> (comment)) {
				_log.Warn(String.Format("Could not add comment from {0}, for the Article from {1}",comment.User.Username,comment.Article.Creator.Username));
			}else{
				RefreshData ();
				_log.Info(String.Format("Added comment from {0}, for the Article from {1}",comment.User.Username,comment.Article.Creator.Username));
			}
		}

		public void UpdateComment(Comment comment)
		{
			if (!_context.Update<Comment> (comment)) {
				_log.Warn (String.Format ("Could not update comment from {0}, for the Article from {1}", comment.User.Username, comment.Article.Creator.Username));

			} else {
				RefreshData ();
				_log.Info(String.Format("Updated comment from {0}, for the Article from {1}",comment.User.Username,comment.Article.Creator.Username));
			}
		}

		public void DeleteComment(Comment comment)
		{
			if (!_context.Delete<Comment> (comment)) {
				_log.Warn (String.Format ("Could not delete comment from {0}, for the Article from {1}", comment.User.Username, comment.Article.Creator.Username));

			} else {
				RefreshData ();
				_log.Info(String.Format("Deleted comment from {0}, for the Article from {1}",comment.User.Username,comment.Article.Creator.Username));
			}
		}

		public List<Comment> GetCommentsFromArticle(Article article)
		{
			return _comments.Where (c => c.Article.Id.Equals (article.Id)).ToList (); 
		}


	}
}

