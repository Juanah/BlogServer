using System;
using BlogServer.Common;

namespace BlogServer.DataAccess
{
	public static class CommentDTOConverter
	{
		public static CommentDTO ConvertToDTO(Comment comment)
		{
			CommentDTO dto = new CommentDTO ();
			dto.ArticleTempId = comment.Article.Id;
			dto.Content = comment.Content;
			dto.Creator = UserDTOConverter.ConvertToDTO (comment.User);

			var image = ImageHelper.GetImageBytes (comment.Image);
			if (image != null) {
				dto.ImageBytes = image;
			}
			return dto;
		}


	}
}

