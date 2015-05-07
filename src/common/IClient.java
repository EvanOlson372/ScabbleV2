package common;

import java.rmi.Remote;
import java.rmi.RemoteException;


	public interface IClient extends Remote {
		public void update(java.util.Observable o, Object _dataStruct) throws RemoteException;
	}

	
