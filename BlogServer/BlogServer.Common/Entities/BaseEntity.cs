using System;
using Infrastructure;

namespace BlogServer.Common
{
	public class BaseEntity: IEntity
	{
		public BaseEntity ()
		{
		}

		[IDKey(true)]
		public int Id{ get; set; }

		#region IEntity implementation
		public object DeepCopy ()
		{
			return this.MemberwiseClone ();
		}
		public int GetId ()
		{
			return Id;
		}
		public void SetID (int id)
		{
			Id = id;
		}
		#endregion
	}
}

