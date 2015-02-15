using System;
using System.Collections.Generic;
using BlogServer.Common;
using Core;
using log4net;
using System.Linq;


namespace BlogServer.DataAccess
{
	/// <summary>
	/// Handles the storage of User Entities 
	/// </summary>
	public class UserRepository
	{
		private List<User> _user;
		private Context _context;
		private ILog _log = LogManager.GetLogger(typeof(UserRepository));

		public UserRepository (Context _context)
		{
			this._context = _context;
			if (User == null) {
				GetDatabaseUser ();
			}
		}
		
		private void GetDatabaseUser()
		{

			_user = _context.GetTable<User>(typeof(User));
			_log.Info ("Get Users from Database");
		}

		public bool UserIsValid(UserDTO dto)
		{

			if(!_user.Any(na => na.Authentification.Equals(dto.Authentification)))
			{
				return false;
			}

			return true;
		}

		public List<User> User{
			get{ return _user;}
		}

		public void UpdateUser(User user)
		{
			if (!_context.Update<User> (user)) {
				_log.Warn ("could not Update User:" + user.Username);
			} else {
				GetDatabaseUser ();
				_log.Info ("Updated User:" + user.Username);
			}
		}

		public void AddUser(User user)
		{
			BlogImage emptyImage = new BlogImage () {
				Path = ""
			};

			_context.Insert<BlogImage> (emptyImage);
			user.Image = emptyImage;

			if (!_context.Insert<User> (user)) {
				_log.Warn ("could not insert User:" + user.Username);
			} else {
				GetDatabaseUser ();
				_log.Info ("Added new User:" + user.Username + " with ID:" + user.Id);
			}
		}

		public void DeleteUser(User user)
		{
			if (!_context.Delete<User> (user)) {
				_log.Warn (String.Format ("User {0} could not be deleted", user.Username));
			} else {
				GetDatabaseUser ();
				_log.Info (String.Format ("User {0} has been deleted", user.Username));
			}
		}

	}
}

