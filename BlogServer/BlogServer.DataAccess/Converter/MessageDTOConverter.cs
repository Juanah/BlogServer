using System;
using BlogServer.Common;


namespace BlogServer.DataAccess
{
	public static class MessageDTOConverter
	{

		public static MessageDTO ConvertToDTO(Message message)
		{
			MessageDTO dto = new MessageDTO ();
			dto.Content = message.Content;
			dto.Creator = UserDTOConverter.ConvertToDTO (message.Creator);
			dto.Receiver = UserDTOConverter.ConvertToDTO (message.Receiver);

			var image = ImageHelper.GetImageBytes (message.Image);

			if (image != null) {
				dto.ImageBytes = image;
			}
			return dto;
		}

	}
}

