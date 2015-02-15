using System;
using System.ServiceModel;
using System.ServiceModel.Web;

namespace BlogServer.Service
{
	[ServiceContract]
	public interface IContract
	{

		[OperationContract]
		[WebInvoke(Method = "GET",
		           ResponseFormat = WebMessageFormat.Json,
		           UriTemplate = "request/{requestobject}")]
		string TestRequest (string requestobject);

		[OperationContract]
		[WebInvoke(Method = "GET",
		           ResponseFormat = WebMessageFormat.Json,
		           UriTemplate = "testbytes/{requestobject}")]
		byte[] TestByteRequest (string requestobject);


	}
}

