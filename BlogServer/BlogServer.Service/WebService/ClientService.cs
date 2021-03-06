using System;
using System.IO;
using BlogServer.Processor;

namespace BlogServer.Service
{
	public class ClientService:IContract
	{
		private UserMessageProcessor _userMessageProcessor;
		private ArticleMessageProcessor _articleMessageProcessor;
		public ClientService ()
		{
			_userMessageProcessor = RepoHelper.UserProcessor;
			_articleMessageProcessor = RepoHelper.ArticleProcessor;
			if (_userMessageProcessor == null) {
				throw new ArgumentNullException ("_userMessageProcessor");
			}
		}
		
		#region IContract implementation

		public string TestRequest (string requestobject)
		{
			Console.WriteLine (requestobject);
			return "Hallo :)";
		}

		public byte[] TestByteRequest (string requestobject)
		{
			return File.ReadAllBytes ("/media/jonas/Data/image-001.jpeg");
		}

		/// <summary>
		/// Adds a new User, keep in mind no User is Useable if the user got no real Authentification string
		/// </summary>
		/// <returns>The add command.</returns>
		/// <param name="requestobject">Requestobject.</param>
		public BlogServer.Common.BoolResponseMessage UserAddCommand (string requestobject)
		{
			return _userMessageProcessor.AddUser (requestobject);
		}

		public BlogServer.Common.BoolResponseMessage UserAcceptCommand (string requestobject)
		{
			return _userMessageProcessor.AccecptUser (requestobject);
		}

		#endregion
	}
}

