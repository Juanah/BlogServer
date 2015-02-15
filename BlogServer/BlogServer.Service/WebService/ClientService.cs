using System;
using System.IO;

namespace BlogServer.Service
{
	public class ClientService:IContract
	{
		public ClientService ()
		{
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

		#endregion
	}
}

