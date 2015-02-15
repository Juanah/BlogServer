using System;
using BlogServer.DataAccess;
using BlogServer.Common;
using BlogServer.Service;

namespace BlogServer.Test
{
	class MainClass
	{
		static User testUser;
		static UserRepository userRepo = Init.UserRepository;
		static ArticleRepository articleRepo = Init.ArticleRepository;
		static MessageRepository messageRepo = Init.MessageRepository;
		static Hosts _hosts; 
		public static void Main (string[] args)
		{
			W ("Test Application for BlogServer 1.0");
			W ("Creating context and all nessary stuff for the Database like repos");
			W ("Create testUser");
			BlogImage image = new BlogImage () {
				Path = ""
			};
			Init.BlogImageRepository.Add (image);
			testUser = new User () {
				Image = image,
				Authentification = Guid.NewGuid().ToString(),
				RSAPublicKey = "",
				Username = "TestUser"
			};

			userRepo.AddUser (testUser);
			DisplayUser ();

			W ("Try to start Service");
			StartWebService ();

			W ("Test have been done");
			Console.ReadKey ();
		}

		static void DisplayUser()
		{
			var users = userRepo.User;

			foreach (var user in users) {
				W (String.Format ("User {0} with authentification {1}, id = {2}", user.Username, user.Authentification,user.Id));
			}
		}

		static void StartWebService()
		{
			_hosts = new Hosts (new BlogServer.Processor.UserMessageProcessor(Init.UserRepository));
			_hosts.StartServices ();
		}

		static void W(object obj)
		{
			Console.WriteLine (obj);
		}
	}
}
