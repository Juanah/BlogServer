using System;
using Core;
using System.Collections.Generic;
using BlogServer.Common;
using log4net;

namespace BlogServer.DataAccess
{
	public class MessageRepository
	{
		private Context _context;
		private List<Message> _messages;
		private ILog _log = LogManager.GetLogger(typeof(MessageRepository));

		public MessageRepository (Context _context)
		{
			this._context = _context;
		}

		private void RefreshData()
		{
			_messages = _context.GetTable<Message> (typeof(Message));
			_log.Info ("Refreshed Message Data");
		}

		public List<Message> Messages
		{
			get{ return _messages;}
		}

		public void Add(Message message)
		{
			if (!_context.Insert<Message> (message)) {
				_log.Warn (String.Format ("Could not add Message from {0} to {1}!", message.Creator.Username, message.Receiver.Username));
			} else {
				RefreshData ();
				_log.Info (String.Format ("Added Message from {0} to {1}!", message.Creator.Username, message.Receiver.Username));
			}
		}

		public void Update(Message message)
		{
			if (!_context.Update<Message> (message)) {
				_log.Warn (String.Format ("Could not update Message from {0} to {1}!", message.Creator.Username, message.Receiver.Username));
			} else {
				RefreshData ();
				_log.Info (String.Format ("Updated Message from {0} to {1}!", message.Creator.Username, message.Receiver.Username));
			}
		}

		public void DeleteMessage(Message message)
		{
			if (!_context.Delete<Message> (message)) {
				_log.Warn (String.Format ("Could not delete Message from {0} to {1}!", message.Creator.Username, message.Receiver.Username));
			} else {
				RefreshData ();
				_log.Info (String.Format ("Deleted Message from {0} to {1}!", message.Creator.Username, message.Receiver.Username));
			}
		}
	}
}

