using System;
using Infrastructure;
namespace BlogServer.Common
{
	public class Article:BaseEntity
	{
		public Article ()
		{
		}

		[ForeignKey(typeof(User))]
		public User Creator{ get; set; }

		public string Content{ get; set; }
	}
}

