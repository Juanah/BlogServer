using System;
using BlogServer.Common;
using System.IO;
using log4net;

namespace BlogServer.DataAccess
{
	/// <summary>
	/// Is reponsible for all Image Operations
	/// </summary>
	public static class ImageHelper
	{
		private static readonly string BasePath = Environment.CurrentDirectory + "/Images/";
		private static ILog _log = LogManager.GetLogger (typeof(ImageHelper));


		static ImageHelper()
		{
			var dirInfo = new DirectoryInfo (BasePath);
			if (!dirInfo.Exists) {
				try {
					dirInfo.Create();
				} catch (Exception ex) {
					_log.Error (ex);
					throw new DirectoryNotFoundException ("could not write Image directory");
				}
			}
		}

		/// <summary>
		/// Gets the image bytes.
		/// </summary>
		/// <returns>The image bytes. or null when missing</returns>
		/// <param name="image">Image.</param>
		public static byte[] GetImageBytes(BlogImage image)
		{
			if (File.Exists(image.Path)) {
				_log.Warn ("File not found");
				return null;
			}

			return File.ReadAllBytes (image.Path);
		}

		public static string SaveImage(byte[] imageBytes)
		{
			if (imageBytes == null) {
				_log.Warn ("cannot write image, byte array is null");
				return null;
			}
			string path = PathBuilder ();
			try {
				File.WriteAllBytes(path,imageBytes);
				return path;
			} catch (Exception ex) {
				_log.Error (ex);
				return null;
			}
		}


		private static string PathBuilder()
		{
			var path = BasePath + Guid.NewGuid ().ToString ().Replace ("-", "_") + ".jpg";

			return path;
		}

	}
}

