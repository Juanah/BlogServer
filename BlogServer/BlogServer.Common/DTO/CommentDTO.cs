using System;

namespace BlogServer.Common
{
	public class CommentDTO
	{
		public UserDTO Creator{ get; set; }

		public int ArticleTempId{ get; set; }

		public string Content{ get; set; }

		public byte[] ImageBytes{ get; set; }

	}
}

