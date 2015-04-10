package code.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
	private static ArrayList<String> _players;
>>>>>>> parent of 061482a... Still Working on stuff
=======
>>>>>>> parent of 22b416f... Holy Fuck Tons OF SHIT!!
	
	public ScrabbleUI(){
		 _dataStruct = new Scrabble();
		 _dataStruct.addObserver((Observer) this);
		 _boardButtons = new ArrayList<JButton>();
		 _rackButtons = new ArrayList<JButton>();
	}

	public static void main(String[] args) {
<<<<<<< HEAD
<<<<<<< HEAD
		SwingUtilities.invokeLater(new ScrabbleUI());
	
=======
		
	
//patchwork just to confirm ui is building correctly
			_players = new ArrayList<String>();
			_players.add("jeff");
			_players.add("jim");
			_players.add("bill");
			
			
		//	_dataStruct.addPlayerName(s);
		//	_dataStruct.addToNumberOfPlayers();
		
		
		SwingUtilities.invokeLater(new ScrabbleUI());
>>>>>>> parent of 061482a... Still Working on stuff
=======
		SwingUtilities.invokeLater(new ScrabbleUI());
	
>>>>>>> parent of 22b416f... Holy Fuck Tons OF SHIT!!
	}

	
	@Override
	public void run() {
<<<<<<< HEAD
<<<<<<< HEAD
		JFrame window = new JFrame("Scrabble");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(20,20, 1, 1));
=======
		
		_dataStruct.addToNumberOfPlayers();
		_dataStruct.addToNumberOfPlayers();
		_dataStruct.addToNumberOfPlayers();
		_dataStruct.addNewPlayer();
		_dataStruct.addNewPlayer();
		_dataStruct.addNewPlayer();
				
		JFrame window = new JFrame("Scrabble");
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		northPanel.setLayout(new GridLayout(20,20, 1, 1));
>>>>>>> parent of 061482a... Still Working on stuff
=======
		JFrame window = new JFrame("Scrabble");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(20,20, 1, 1));
>>>>>>> parent of 22b416f... Holy Fuck Tons OF SHIT!!
		for (int i=0; i<400; i++) {
			JButton b = new JButton("");
			b.setPreferredSize(new Dimension(30,30));
			b.setForeground(Color.red);
			b.setOpaque(true);
			p.add(b);
<<<<<<< HEAD
			b.addActionListener(new BoardButtonHandler(i, _dataStruct));
			_boardButtons.add(b);
		}
<<<<<<< HEAD
=======
			b.addActionListener(new ButtonHandler(i, _dataStruct));
			_boardButtons.add(b);
		}
>>>>>>> parent of 22b416f... Holy Fuck Tons OF SHIT!!
		window.add(p);
		JPanel playerPane = new JPanel();
		playerPane.setLayout(new BoxLayout(playerPane, BoxLayout.Y_AXIS));
		playerPane.add(addPlayerPanel(_dataStruct.getPlayer(0), Color.RED, "bill"));
		playerPane.add(addPlayerPanel(_dataStruct.getPlayer(1), Color.RED,  "jim"));
		playerPane.add(addPlayerPanel(_dataStruct.getPlayer(1), Color.RED,  "jeff"));

		window.add(playerPane, BorderLayout.SOUTH);
<<<<<<< HEAD
=======
		
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		
		for(int i = 0; i <_dataStruct.getNumberOfPlayer(); i++ ){
			southPanel.add(addPlayerPanel(_dataStruct.getPlayer(i),_dataStruct.getPlayerName(i)));
		}
			
		window.add(northPanel, BorderLayout.NORTH);
		window.add(southPanel, BorderLayout.SOUTH);
>>>>>>> parent of 061482a... Still Working on stuff
=======
>>>>>>> parent of 22b416f... Holy Fuck Tons OF SHIT!!
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);

		
	}

	
	public JPanel addPlayerPanel(Player p, Color c, String name){
		JPanel panel = new JPanel();
		JLabel label = new JLabel(name);
		panel.add(label);
		panel.setLayout(new FlowLayout());
<<<<<<< HEAD
<<<<<<< HEAD
		TileRack tr = p.getRack();
		
		for(int i = 0;i<12; i++){
			JButton b = new JButton(Character.toString(p.getTile(i).getChar()));
=======
		for(int i = 0;i<12; i++){
			JButton b = new JButton(Character.toString(p.getTile(i).getChar()) +":"+ Integer.toString(p.getTile(i).getValue()) );
>>>>>>> parent of 061482a... Still Working on stuff
=======
		TileRack tr = p.getRack();
		
		for(int i = 0;i<12; i++){
			JButton b = new JButton(Character.toString(tr.getTile(i).getChar()));
>>>>>>> parent of 22b416f... Holy Fuck Tons OF SHIT!!
			b.setPreferredSize(new Dimension(30,30));
			b.setForeground(c);;
			b.setOpaque(true);
			panel.add(b);
<<<<<<< HEAD
<<<<<<< HEAD
			b.addActionListener(new BoardButtonHandler(i, _dataStruct));
=======
			b.addActionListener(new RackButtonHandler(i, _dataStruct));
>>>>>>> parent of 061482a... Still Working on stuff
=======
			b.addActionListener(new ButtonHandler(i, _dataStruct));
>>>>>>> parent of 22b416f... Holy Fuck Tons OF SHIT!!
			_rackButtons.add(b);
		}
		return panel;
	}

	@Override
	public void update(java.util.Observable o, Object arg) {
	/*
		String s = _dataStruct.toString();
		System.out.print(s);
		for (int i=0; i<s.length(); i++) {
		_boardButtons.get(i).setText(""+s.charAt(i));
		
		}
	*/	
	}

	

	
	
	
	
}
