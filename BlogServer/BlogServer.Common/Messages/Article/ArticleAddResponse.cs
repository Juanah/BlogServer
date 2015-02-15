using System;

namespace BlogServer.Common
{
	public class ArticleAddResponse
	{
		/// <summary>
		/// Gets or sets a value indicating whether this instance is added.
		/// </summary>
		/// <value><c>true</c> if this instance is added; otherwise, <c>false</c>.</value>
		public bool IsAdded{get;set;}

		/// <summary>
		/// Returns the Id of the added Article
		/// </summary>
		/// <value>The temp identifier.</value>
		public int TempId{ get; set;}

	}
}

