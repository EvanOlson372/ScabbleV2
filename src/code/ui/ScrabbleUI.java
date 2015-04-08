package code.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.Scrabble;
import code.Player;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class ScrabbleUI implements Observable, Runnable {
	
	private static code.Scrabble _dataStruct;
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
		_dataStruct.addNewPlayer();
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
			JButton b = new JButton("open");
			b.setPreferredSize(new Dimension(30,30));
			b.setForeground(Color.red);
			b.setBackground(Color.BLACK);
			b.setOpaque(true);
			p.add(b);
			b.addActionListener(new ButtonHandler(i, _dataStruct));
			_boardButtons.add(b);
		}

		_dataStruct.addNewPlayer();
		window.add(p,BorderLayout.NORTH);
		window.add(addPlayerPanel(_dataStruct.getPlayer(0), Color.BLUE),-1);
		window.add(addPlayerPanel(_dataStruct.getPlayer(0), Color.RED),-1);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		
		
		
	}

	
	public JPanel addPlayerPanel(Player p, Color c){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,12,1,1));
		for(int i = 0;i<12; i++){
			JButton b = new JButton("");
			b.setPreferredSize(new Dimension(30,30));
			b.setForeground(c);;
			b.setOpaque(true);
			panel.add(b);
			b.addActionListener(new ButtonHandler(i, _dataStruct));
			_rackButtons.add(b);
		}
		return panel;
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
