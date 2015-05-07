package server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import common.IClient;
import common.IServer;

public class Server implements IServer {

	private ArrayList<IClient> _observers;
	
	
	public Server() {
	
		   System.out.println("...server running...");
			_observers = new ArrayList<IClient>();
	}
	@Override
	public void addIClient(IClient c) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
