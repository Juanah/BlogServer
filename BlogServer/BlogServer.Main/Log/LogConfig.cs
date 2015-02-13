using System;
using log4net.Repository.Hierarchy;
using log4net.Layout;
using log4net.Appender;
using log4net.Core;
using log4net;

namespace BlogServer.Main
{
	/// <summary>
	/// Log config.
	/// </summary>
	public static class LogConfig
	{
		static Level _level;
		/// <summary>
		/// Configures the log.
		/// </summary>
		internal static void ConfigureLog(Level level)
		{
			_level = level;
		}

		private static void Setup()
		{
			Hierarchy hierarchy = (Hierarchy)LogManager.GetRepository();

			PatternLayout patternLayout = new PatternLayout();
			patternLayout.ConversionPattern = "%date [%thread] %-5level %logger - %message%newline";
			patternLayout.ActivateOptions();

			RollingFileAppender roller = new RollingFileAppender();
			roller.AppendToFile = false;
			roller.File = @"logs\ServerLog.log";
			roller.Layout = patternLayout;
			roller.MaxSizeRollBackups = 5;
			roller.MaximumFileSize = "1GB";
			roller.RollingStyle = RollingFileAppender.RollingMode.Size;
			roller.StaticLogFileName = true;            
			roller.ActivateOptions();
			hierarchy.Root.AddAppender(roller);

			ConsoleAppender consoleAppender = new ConsoleAppender ();
			consoleAppender.Layout = patternLayout;
			consoleAppender.ActivateOptions ();

			MemoryAppender memory = new MemoryAppender();
			memory.ActivateOptions();
			hierarchy.Root.AddAppender(memory);

			hierarchy.Root.Level = _level;
			hierarchy.Configured = true;
		}

	}
}

