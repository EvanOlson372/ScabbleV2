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

import code.Scrabble_030;
import code.Player_030;
import code.TileRack_030;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class ScrabbleUI_084 implements Observer, Runnable {
	
	private static code.Scrabble_030 _dataStruct;
	private ArrayList<JPanel> _playerPanels;
	private ArrayList<JButton> _boardButtons;
	private JButton [][] _rackButtons;
	private JButton _nextTurnButton;
	private static ArrayList<String> _players;
	
	public ScrabbleUI_084(){
		_dataStruct = new Scrabble_030();
		_dataStruct.addObserver(this);
		_boardButtons = new ArrayList<JButton>();
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
		
		
		SwingUtilities.invokeLater(new ScrabbleUI_084());
	}

	
	@Override
	public void run() {
		//commit
		_dataStruct.addNewPlayer();
		_dataStruct.addNewPlayer();
		_dataStruct.addNewPlayer();
		
		_rackButtons = new JButton[_dataStruct.getNumberOfPlayers()][12];
		_playerPanels = new ArrayList<JPanel>();
		
		JFrame window = new JFrame("Scrabble");
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		_nextTurnButton = new JButton("End Turn");
		_nextTurnButton.setPreferredSize(new Dimension(30, 60));
		_nextTurnButton.setOpaque(true);
		_nextTurnButton.addActionListener(new NextTurnButtonHandler_084(_dataStruct, _rackButtons, _boardButtons, _playerPanels));
		
		
		northPanel.setLayout(new GridLayout(20,20, 1, 1));
		for (int i=0; i<400; i++) {
			JButton b = new JButton("");
			b.setPreferredSize(new Dimension(30,30));
			b.setForeground(Color.red);
			b.setOpaque(true);
			northPanel.add(b);
			b.addActionListener(new BoardButtonHandler_084(i, _dataStruct));
			_boardButtons.add(b);
		}
		
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		
		for(int i = 0; i <_dataStruct.getNumberOfPlayers(); i++ ){
			addPlayerPanel(_dataStruct.getPlayer(i),_dataStruct.getPlayerName(i), i);
		}
		for(int i = 0; i <_dataStruct.getNumberOfPlayers(); i++ ){
			southPanel.add(_playerPanels.get(i));
		}
		
		
		southPanel.add(_nextTurnButton);
		window.add(northPanel, BorderLayout.NORTH);
		window.add(southPanel, BorderLayout.SOUTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);

		
	}

	
	public void addPlayerPanel(Player_030 p, String name, int r){
		JPanel panel = new JPanel();
		JLabel label = new JLabel(name + ":" + Integer.toString(p.getScore()));
		panel.add(label);
		panel.setLayout(new FlowLayout());
		
			for(int c = 0;c<12; c++){
				JButton b = new JButton(Character.toString(p.getTile(c).getChar()) +":"+ Integer.toString(p.getTile(c).getValue()) );
				b.setPreferredSize(new Dimension(60,30));
				b.setForeground(p.getColor());
				b.setOpaque(true);
				panel.add(b);
				b.addActionListener(new RackButtonHandler_084(r,c, _dataStruct, _rackButtons));
				_rackButtons[r][c] = b;
			
			}
		
		_playerPanels.add(panel);
	}
	
	public void redrawRack(){
		Player_030 p = _dataStruct.getCurrentPlayer();
		
			for(int c = 0; c<12; c++){
				if(c<p.getRack().getSize())
				{
					JButton b = _rackButtons[_dataStruct.getTurn()][c];
					b.setText(Character.toString(_dataStruct.getCurrentPlayer().getRack().get(c).getChar()) + ":" + Integer.toString(p.getTile(c).getValue()));
				}
				else{
					JButton b = _rackButtons[_dataStruct.getTurn()][c];
					b.setText(" ");
					
				}
					
			
			}
		
	}
	
	

	@Override
	public void update(java.util.Observable o, Object _dataStruct) {
		redrawRack();
		
	/*
		String s = _dataStruct.toString();
		System.out.print(s);
		for (int i=0; i<s.length(); i++) {
		_boardButtons.get(i).setText(""+s.charAt(i));
		
		}
	*/	
	}
/**
 * for whole class 
 * Driver Leonardo Evangelista
 * Navigator Evan Olson
 */
	

	
	
	
	
}
