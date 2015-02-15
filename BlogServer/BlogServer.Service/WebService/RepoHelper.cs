using System;
using BlogServer.Processor;

namespace BlogServer.Service
{
	public static class RepoHelper
	{
		public static UserMessageProcessor UserProcessor{ get; set; }
		public static ArticleMessageProcessor ArticleProcessor{ get; set; }
	}
}

