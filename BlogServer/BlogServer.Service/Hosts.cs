using System;
using System.ServiceModel.Web;
using log4net;
using BlogServer.Processor;

namespace BlogServer.Service
{
	public class Hosts
	{
		public ILog _log = LogManager.GetLogger (typeof(Hosts));
		private static UserMessageProcessor _userProcessor;

		public Hosts (UserMessageProcessor userProcessor)
		{
			_userProcessor = userProcessor;
		}
		

		public void StartServices()
		{
			RepoHelper.UserProcessor = _userProcessor;

			var clientUri = new Uri ("http://192.168.0.101:55764/WebService");
			var clientService = new WebServiceHost (typeof(ClientService), clientUri);

			clientService.Opened += delegate(object sender, EventArgs e) {
				_log.Info("Webservice is opened on address" + clientUri);
			};

			clientService.Faulted += delegate(object sender, EventArgs e) {
				_log.Info("Webservice faulted" + e);
			};

			clientService.Open ();
		}

	}
}

