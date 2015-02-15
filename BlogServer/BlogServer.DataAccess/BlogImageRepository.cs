using System;
using Core;
using log4net;
using BlogServer.Common;
using System.Collections.Generic;

namespace BlogServer.DataAccess
{
	public class BlogImageRepository
	{
		private List<BlogImage> _images;
		private Context _context;
		private ILog _log = LogManager.GetLogger(typeof(UserRepository));

		public BlogImageRepository (Context _context)
		{
			this._context = _context;
			if (_images == null) {
				RefreshData ();
			}
		}

		private void RefreshData()
		{
			var test = _context.GetTable<BlogImage>(typeof(BlogImage));

			//_user = _context.GetTable<User>(typeof(User));
			_log.Info ("Get Images from Database");
		}

		public List<BlogImage> Images{
			get{ return _images;}
		}

		public void Update(BlogImage image)
		{
			if (!_context.Update<BlogImage> (image)) {
				_log.Warn ("could not Update Image:");
			} else {
				RefreshData ();
				_log.Info ("Updated Image:");
			}
		}

		public void Add(BlogImage image)
		{
			if (!_context.Insert<BlogImage> (image)) {
				_log.Warn ("could not insert Image:");
			} else {
				RefreshData ();
				_log.Info ("Added new Image:");
			}
		}

		public void Delete(BlogImage image)
		{
			if (!_context.Delete<BlogImage> (image)) {
				_log.Warn (String.Format ("BlogImage {0} could not be deleted", image.Path));
			} else {
				RefreshData ();
				_log.Info (String.Format ("BlogImage {0} has been deleted", image.Path));
			}
		}
	}
}

