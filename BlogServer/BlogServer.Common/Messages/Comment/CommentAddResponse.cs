using System;

namespace BlogServer.Common
{
	public class CommentAddResponse
	{
		/// <summary>
		/// Gets or sets a value indicating whether this instance is added.
		/// </summary>
		/// <value><c>true</c> if this instance is added; otherwise, <c>false</c>.</value>
		public bool IsAdded{get;set;}

		public int TempId{ get; set;}
	}
}

