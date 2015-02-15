using System;

namespace BlogServer.Common
{
	public class ArticleDTO
	{
		public UserDTO Creator{ get; set; }

		public int TempId{ get; set; }

		public string Content{ get; set; }

		public byte[] ImageBytes{ get; set; }

	}
}

