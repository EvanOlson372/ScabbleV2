package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

	public interface IServer extends Remote {
		
		public static final String SERVER_REGISTRY_KEY = "Play";

		/**
		 * Registers IClient c as an observer of changes on the server.
		 * @param c
		 * @throws RemoteException
		 */
		public void addIClient(IClient c) throws RemoteException;
		
		/**
		 * The server keeps track of votes cast.  A client can cast
		 * a vote by calling the vote() method. 
		 * @throws RemoteException
		 */
}
