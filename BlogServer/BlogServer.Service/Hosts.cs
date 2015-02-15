using System;
using System.ServiceModel.Web;
using log4net;

namespace BlogServer.Service
{
	public class Hosts
	{
		public ILog _log = LogManager.GetLogger (typeof(Hosts));
		public Hosts ()
		{
		}

		public void StartServices()
		{
			var clientUri = new Uri ("http://192.168.2.102:55764/WebService");
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

