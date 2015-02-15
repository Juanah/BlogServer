using System;

namespace BlogServer.Common
{
	public class ArticleGet
	{
		/// <summary>
		/// Articles wich are stored in the Localdatabase ClientSide
		/// </summary>
		/// <value>The temp identifiers.</value>
		public int[] TempIds{ get; set; }

		/// <summary>
		/// for authentification purpose
		/// </summary>
		/// <value>The user.</value>
		public UserDTO User{ get; set; }
	}
}

