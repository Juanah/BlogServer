using System;

namespace BlogServer.Common
{
	public class UserAcceptMessage
	{
		public UserDTO Creator{get;set;}
		public UserDTO AcceptedUser{get;set;}
	}
}

