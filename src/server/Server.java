package server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;

import common.IClient;
import common.IServer;

public class Server implements IServer {

	private ArrayList<IClient> _observers;
	private JButton [][] _rackButtons;
	private static code.Scrabble _dataStruct;

	
	public Server() {
	
		   System.out.println("...server running...");
			//_votes = 0;
			_observers = new ArrayList<IClient>();
	}
	public void addIClient(IClient c) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	private void notifyObservers() {
		for (IClient c : _observers) {
			// Try to call update() on a remote client
			try {
				c.update(java.util.Observable o,_dataStruct);
			}
			// If unable, print error message and stack trace, but keep trying with other
			// clients, which are running on different hosts.
			catch (RemoteException e) {
				System.err.println("[SERVER] Unable to communicate with client.");
				e.printStackTrace();
			}
		}
	}


}
