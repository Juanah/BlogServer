using System;

namespace BlogServer.Common
{
	public class MessageDTO
	{
		public UserDTO Creator{ get; set; }
		public UserDTO Receiver{ get; set; }

		public string Content{ get; set; }

		public byte[] ImageBytes{ get; set; }

	}
}

