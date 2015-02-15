using System;
using System.ServiceModel;
using System.ServiceModel.Web;
using BlogServer.Common;

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

		[OperationContract]
		[WebInvoke(Method = "GET",
		           ResponseFormat = WebMessageFormat.Json,
		           UriTemplate = "user_add/{requestobject}")]
		BoolResponseMessage UserAddCommand (string requestobject);

		[OperationContract]
		[WebInvoke(Method = "GET",
		           ResponseFormat = WebMessageFormat.Json,
		           UriTemplate = "user_accept/{requestobject}")]
		BoolResponseMessage UserAcceptCommand (string requestobject);

	}
}

