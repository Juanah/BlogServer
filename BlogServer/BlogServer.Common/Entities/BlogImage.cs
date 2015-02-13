using System;
namespace BlogServer.Common
{
	public class BlogImage: BaseEntity
	{
		public BlogImage ()
		{
		}
		/// <summary>
		/// The path to the Image on serverSide
		/// </summary>
		/// <value>The path.</value>
		public string Path{ get; set; }

	}
}

