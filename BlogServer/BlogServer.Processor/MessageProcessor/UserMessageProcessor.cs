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

		#region Add
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
				_log.Warn (String.Format ("Bad JsonFormat from Message {0} " + ex, message));
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
		#endregion
		/// <summary>
		/// Accecpts the user. And stores the authentification string
		/// </summary>
		/// <returns>The user.</returns>
		/// <param name="message">Message.</param>
		public BoolResponseMessage AccecptUser(string message)
		{
			//Default message is always false
			var response = new BoolResponseMessage () {
				Success = false
			};

			UserAcceptMessage userAcceptMessage;

			try {
				userAcceptMessage = JsonConvert.DeserializeObject<UserAcceptMessage>(message);
			} catch (Exception ex) {
				_log.Warn (String.Format ("Bad JsonFormat from Message {0} " + ex, message));
				return response;
			}

			if (userAcceptMessage == null) {
				return response;
			}

			//Update UserAuthentifocation
			var searchedUser = _userRepo.User.FirstOrDefault (n => n.Username.Equals (userAcceptMessage.AcceptedUser.Username));
			if (searchedUser == null) {
				return response;
			}

			searchedUser.Authentification = userAcceptMessage.AcceptedUser.Authentification;
			_userRepo.UpdateUser (searchedUser);
			response.Success = true;
			return response;
		}

		public UserGet GetUsers(string message)
		{
			var response = new UserGet () {
				AcceptedRequest = false
			};

			UserRequestMessage userRequest;

			try {
				userRequest = JsonConvert.DeserializeObject<UserRequestMessage>(message);
			} catch (Exception ex) {
				_log.Warn (String.Format ("Bad JsonFormat from Message {0} " + ex, message));
				return response;
			}
			if (userRequest == null) {
				_log.Warn ("could not parse userRequest");
				return response;
			}

			//Check if the User is Valid
			if (!_userRepo.User.Any (na => na.Authentification.Equals (userRequest.User.Authentification) && na.Username.Equals (userRequest.User.Username))) {
				_log.Warn (String.Format ("User {0} , tried to receive Users but is Invalid", userRequest.User.Username));
				return response;
			}

			//Looks like the user is OK
			UserDTO[] dtos = new UserDTO[_userRepo.User.Count];

			for (int i = 0; i < _userRepo.User.Count; i++) {
				dtos [i] = UserDTOConverter.ConvertToDTO (_userRepo.User [i]);
			}

			response.Users = dtos;
			response.AcceptedRequest = true;
			return response;
		}

		public BoolResponseMessage DeleteUser(string message)
		{
			//Default message is always false
			var response = new BoolResponseMessage () {
				Success = false
			};

			UserDelete deleteMessage;

			try {
				deleteMessage = JsonConvert.DeserializeObject<UserDelete>(message);
			} catch (Exception ex) {
				_log.Warn (String.Format ("Bad JsonFormat from Message {0} " + ex, message));
				return response;
			}

			if (deleteMessage == null) {
				_log.Warn ("could not parse userDelete");
				return response;
			}

			//Check the User
			if (!_userRepo.User.Any (na => na.Authentification.Equals (deleteMessage.Creator.Authentification) && na.Username.Equals (deleteMessage.Creator.Username))) {
				_log.Warn (String.Format ("User {0} , tried to delete user {1} , but the user is Invalid", deleteMessage.Creator.Username,deleteMessage.ToDelete.Username));
				return response;
			}

			var searchedUser = _userRepo.User.FirstOrDefault (n => n.Username.Equals (deleteMessage.ToDelete.Username));
			if (searchedUser == null) {
				return response;
			}

			_userRepo.DeleteUser (searchedUser);
			response.Success = true;
			return response;
		}

	}
}

