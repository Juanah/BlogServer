using System;
using Infrastructure.Core;
using Core;
using Infrastructure;
using System.Collections.Generic;
using BlogServer.Common;

namespace BlogServer.DataAccess
{
	public static class Init
	{
		static IDBConnectionInfo connectionInfo;
		static Context _context;

		private static UserRepository userRepo;
		private static ArticleRepository articleRepo;
		private static MessageRepository messageRepo;
		private static BlogImageRepository blogImageRepo;

		public static UserRepository UserRepository
		{
			get{ return userRepo;}
		}
		public static ArticleRepository ArticleRepository
		{
			get{ return articleRepo;}
		}
		public static MessageRepository MessageRepository
		{
			get{ return messageRepo;}
		}
		public static BlogImageRepository BlogImageRepository
		{
			get{ return blogImageRepo;}
		}

		static Init()
		{
			//TODO muss sich ändern sobald es auf den VServer kommt!
			connectionInfo = new ConnectionInfo () {
				Databasename = "blog_server",
				User = "appserver",
				Password = "Xlov76&4",
				Servername = "localhost"
			};

			EntityInitializer initializer = new EntityInitializer (connectionInfo);

			//Entities
			List<IEntity> entities = new List<IEntity> ();
			entities.Add (new User ());
			entities.Add (new Article ());
			entities.Add (new Message ());
			entities.Add (new Comment ());
			entities.Add (new BlogImage ());
			_context = initializer.GetContext (entities);

			_context.CreateDatabase ();
			_context.Parse ();
			_context.Create ();

			userRepo = new UserRepository (_context);
			articleRepo = new ArticleRepository (_context);
			messageRepo = new MessageRepository (_context);
			blogImageRepo = new BlogImageRepository (_context);
		}

	}
}

