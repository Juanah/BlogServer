using System;
using BlogServer.Common;

namespace BlogServer.DataAccess
{
	public static class ArticleDTOConverter
	{

		public static ArticleDTO ConvertToDTO(Article article)
		{
			ArticleDTO dto = new ArticleDTO ();
			dto.Creator = UserDTOConverter.ConvertToDTO (article.Creator);
			dto.Content = article.Content;
			dto.TempId = article.Id;

			var image = ImageHelper.GetImageBytes (article.Image);
			if (image != null) {
				dto.ImageBytes = image;
			}
			return dto;
		}

	}
}

