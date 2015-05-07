package code.ui;

	import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

	import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

	import common.IClient;
import common.IServer;

	public class ClientUI implements Runnable, IClient{

		private JTextField _tf;
		private JFrame _window;
		private IServer _server;

		public ClientUI(IServer s, String hostName, int portNumber) {
			_server = s;
			IClient me = null;
			try {
				boolean retry = false;
				do {
					try {
						me = (IClient) UnicastRemoteObject.exportObject(this,portNumber);
						retry = false;
					}
					catch (ExportException e) {
						if (hostName.equals("localhost")) {
							System.out.print("Port "+portNumber+" is unavailable, trying ");
							portNumber++;
							System.out.println(portNumber);
							retry = true;
						}
						else {
							System.out.print("Port "+portNumber+" is unavailable.");
							e.printStackTrace();
							System.exit(1);
						}
					}
				} while (retry);

			} catch (RemoteException e) {
				System.err.println("[CLIENT] Could not export self.");
				e.printStackTrace();
				System.exit(1);
			}
			try {
				_server.addIClient(me);
			} catch (RemoteException e) {
				System.err.println("[CLIENT] Could not register with remote server.");
				e.printStackTrace();
				System.exit(1);
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
}
