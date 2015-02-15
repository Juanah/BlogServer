using System;
using System.IO;
using BlogServer.Processor;

namespace BlogServer.Service
{
	public class ClientService:IContract
	{
		private UserMessageProcessor _userMessageProcessor;

		public ClientService ()
		{
		}
		

		public ClientService (BlogServer.Processor.UserMessageProcessor _userMessageProcessor)
		{
			this._userMessageProcessor = _userMessageProcessor;
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

		#endregion
	}
}

