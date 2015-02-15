using System;
using BlogServer.Common;

namespace BlogServer.DataAccess
{
	/// <summary>
	/// Converts normal User Entities into UserDTOs
	/// </summary>
	public static class  UserDTOConverter
	{

		public static UserDTO ConvertToDTO(User user)
		{
			return new UserDTO () { TempID = user.Id, Username = user.Username };
		}

	}
}

