using System;
using Infrastructure;
namespace BlogServer.Common
{
	public class Message:BaseEntity
	{
		public Message ()
		{
		}

		[ForeignKey(typeof(User))]
		public User Creator{ get; set; }

		[ForeignKey(typeof(User))]
		public User Receiver{ get; set; }

		public string Content{ get; set; }

		[ForeignKey(typeof(BlogImage))]
		public BlogImage Image{ get; set; }
	}
}

