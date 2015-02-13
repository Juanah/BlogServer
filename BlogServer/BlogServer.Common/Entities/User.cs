using System;
using Infrastructure;
namespace BlogServer.Common
{
	public class User:BaseEntity
	{
		public User ()
		{
		}

		/// <summary>
		/// Gets or sets the username.
		/// </summary>
		/// <value>The username.</value>
		public string Username{ get; set; }

		/// <summary>
		/// Gets or sets the authentification.
		/// </summary>
		/// <value>The authentification.</value>
		public string Authentification{ get; set; }

		/// <summary>
		/// Gets or sets the RSA public key.
		/// </summary>
		/// <value>The RSA public key.</value>
		public string RSAPublicKey{ get; set; }

		[ForeignKey(typeof(BlogImage))]
		public BlogImage Image{ get; set; }

	}
}

