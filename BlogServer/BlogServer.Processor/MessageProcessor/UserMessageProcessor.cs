using System;
using BlogServer.DataAccess;
using BlogServer.Common;
using System.Linq;
using Newtonsoft.Json;
using log4net;
namespace BlogServer.Processor
{
	/// <summary>
	/// Handels the Incomming and outgoing UserMessages
	/// </summary>
	public class UserMessageProcessor
	{
		private UserRepository _userRepo;
		private ILog _log = LogManager.GetLogger(typeof(UserMessageProcessor));
		public UserMessageProcessor (UserRepository _userRepo)
		{
			this._userRepo = _userRepo;
		}

		/// <summary>
		/// Tries to add the User and give back the result
		/// </summary>
		/// <returns>The user.</returns>
		/// <param name="message">Message.</param>
		public BoolResponseMessage AddUser(string message)
		{
			_log.Debug (String.Format ("Got UserAddmessage: {0} ", message));

			//Default message is always false
			var response = new BoolResponseMessage () {
				Success = false
			};

			UserAdd addMessage = null; 
			try {
				 addMessage = JsonConvert.DeserializeObject<UserAdd>(message);
			} catch (Exception ex) {
				_log.Warn (String.Format ("Bad JsonFormat from Message {0} ", message));
				return response;
			}

			if (addMessage == null) {
				return response;
			}

			if (!_userRepo.User.Any (n => n.Username.Equals(""))) {
				User newUser = new User () {
					Username = addMessage.ToAdd.Username,
					Authentification = addMessage.ToAdd.Authentification,
					RSAPublicKey = ""
				};
				_userRepo.AddUser (newUser);
				_log.Info (String.Format ("Added User {0}", newUser.Username));
				response.Success = true;
				return response;
			}
			return response;
		}
	}
}

