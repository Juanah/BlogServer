using System;
using Infrastructure;
namespace BlogServer.Common
{
	public class Comment:BaseEntity
	{
		public Comment ()
		{
		}

		[ForeignKey(typeof(User))]
		public User User{ get; set; }

		public string Content{ get; set; }

		[ForeignKey(typeof(BlogImage))]
		public BlogImage Image{ get; set; }
	}
}

