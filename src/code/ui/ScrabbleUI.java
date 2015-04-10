package code.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.Scrabble;
import code.Player;
import code.TileRack;


public class ScrabbleUI implements Observer, Runnable {
	
	private static code.Scrabble _dataStruct;
	private ArrayList<JButton> _boardButtons;
	private ArrayList<JButton> _rackButtons;
	private static ArrayList<String> _players; 
	private int c = 0;
	private JFrame _window;
	
	public ScrabbleUI(){
		 _dataStruct = new Scrabble();
		 _dataStruct.addObserver((Observer) this);
		 _boardButtons = new ArrayList<JButton>();
		 _rackButtons = new ArrayList<JButton>();
		 _dataStruct.addPlayerName(_players);
	}

	public static void main(String[] args) {
		
	
//patchwork just to confirm ui is building correctly
			_players = new ArrayList<String>();
			_players.add("jeff");
			_players.add("jim");
			_players.add("bill");
			
			
		//	_dataStruct.addPlayerName(s);
		//	_dataStruct.addToNumberOfPlayers();
		SwingUtilities.invokeLater(new ScrabbleUI());
		
	}

	
	@Override
	public void run() {
		
		_dataStruct.addToNumberOfPlayers();
		_dataStruct.addToNumberOfPlayers();
		_dataStruct.addToNumberOfPlayers();
		_dataStruct.addNewPlayer(0);
		_dataStruct.addNewPlayer(1);
		_dataStruct.addNewPlayer(2);
				
		
		
		
		_window = new JFrame("Scrabble");
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		northPanel.setLayout(new GridLayout(20,20, 1, 1));
		for (int i=0; i<400; i++) {
			JButton b = new JButton("");
			b.setPreferredSize(new Dimension(30,30));
			b.setForeground(Color.red);
			b.setOpaque(true);
			northPanel.add(b);
			b.addActionListener(new BoardButtonHandler(i, _dataStruct));
			_boardButtons.add(b);
		}
		
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		
		for(int i = 0; i <_dataStruct.getNumberOfPlayer(); i++ ){
			southPanel.add(addPlayerPanel(_dataStruct.getPlayer(i),_dataStruct.getPlayerName(i)));
		}
			
		_window.add(northPanel, BorderLayout.NORTH);
		_window.add(southPanel, BorderLayout.SOUTH);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.pack();
		_window.setVisible(true);
	

		
	}

	
	public JPanel addPlayerPanel(Player p, String name){
		JPanel panel = new JPanel();
		JLabel label = new JLabel(name + ":" + Integer.toString(p.getScore()));
		panel.add(label);
		panel.setLayout(new FlowLayout());
		for(int i = 0 ;i<12; i++){
			JButton b = new JButton(Character.toString(p.getTile(i).getChar()) +":"+ Integer.toString(p.getTile(i).getValue()) );
			b.setPreferredSize(new Dimension(30,30));
			b.setOpaque(true);
			panel.add(b);
			b.addActionListener(new RackButtonHandler(c, _dataStruct));
			_rackButtons.add(b);
			c++;
		}
		return panel;
	}
	public ArrayList<JButton> getRackButtons(){
		
		return _rackButtons;
	}
	public void  setRackButton(ArrayList<JButton> b){
		_rackButtons = b;
		
	}

	@Override
	public void update(java.util.Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	

	
	
	
	
}
