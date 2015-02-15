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
			UserDTO dto = new UserDTO ();

			dto.Authentification = user.Authentification;
			dto.Username = user.Username;
			if (user.Image.Path != "") {
				var image = ImageHelper.GetImageBytes (user.Image);
				if (image != null) {
					dto.ImageBytes = image;
				}
			}
			return dto;
		}

	}
}

