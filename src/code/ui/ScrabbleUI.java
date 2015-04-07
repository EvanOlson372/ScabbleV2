package code.ui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.Scrabble;
import code.Player;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class ScrabbleUI implements Observable, Runnable {
	
	private code.Scrabble _dataStruct;
	private ArrayList<JButton> _boardButtons;
	private ArrayList<JButton> _rackButtons;
	
	public ScrabbleUI(){
		 _dataStruct = new Scrabble();
	//	 _dataStruct.addObserver((Observer) this);
		 _boardButtons = new ArrayList<JButton>();
		 _rackButtons = new ArrayList<JButton>();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new ScrabbleUI());
	}

	public void update(Observable o, Object arg) {
		String s = _dataStruct.toString();
		for (int i=0; i<s.length(); i++) {
			_boardButtons.get(i).setText(""+s.charAt(i));
		}
	}
	
	@Override
	public void run() {
		JFrame window = new JFrame("Scrabble");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(20,20, 1, 1));
		for (int i=0; i<400; i++) {
			JButton b = new JButton("");
			p.add(b);
			b.addActionListener(new ButtonHandler(i, _dataStruct));
			_boardButtons.add(b);
		}
		window.add(p);
		addPlayerPanel(_players.)
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		
		
		
	}

	public void addPlayerPanel(Player p, JFrame frame){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,12,1,1));
		for(int i = 0;i<12; i++){
			JButton b = new JButton("");
			panel.add(b);
			b.addActionListener(new ButtonHandler(i, _dataStruct));
			_rackButtons.add(b);
		}
		frame.add(panel);
		
	}
	
	
	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
