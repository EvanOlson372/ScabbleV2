package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.Board;
import code.DictionaryScanner;
import code.Player;
import code.Scrabble;

public class NextTurnButtonHandler implements ActionListener {

	private Scrabble _dataStruct;
	private JButton [][] _rackButtons;
	private ArrayList<JButton> _boardButtons;
	private ArrayList<JPanel> _playerPanels;
	private int _row;
	private int _col;
	private Board _b;
	
	public NextTurnButtonHandler(Scrabble dataStruct, JButton [][] rackButtons,  ArrayList<JButton> boardButtons, ArrayList<JPanel> playerPanels){
		_boardButtons = boardButtons;
		_playerPanels = playerPanels;
		_rackButtons = rackButtons;
		_dataStruct = dataStruct;
		_b = _dataStruct.getBoard();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Player p = _dataStruct.getCurrentPlayer();
		DictionaryScanner ds = new DictionaryScanner();

		
		
		if(DictionaryScanner.compareWord(_dataStruct.getWordPlayed(), "src/code/Dictionary" ) == true)
		{
			_dataStruct.setLegitimateWord();
			p.addScore(p.getScore(), _dataStruct.countWordScore(_dataStruct.getWordPlayed()));
			
				for (int i= 0;i<20;i++){
					for (int j=0;j<20;j++){
						if(_b.getTile(i, j) != null){
							_b.getTile(i, j).setBool(true);
						}
					}
				}
				p.getRack().fillRack();
					
			/**
			 * Driver Evan Olson
			 * Navigator Leonardo Evangelista
			 */
		}
		
		else  {
			
			for (int i= 0;i<20;i++){
				for (int j = 0;j<20;j++){
					if(_b.getTile(i, j) != null){
						if (_b.getTile(i, j).getBool()== false){
						p.getRack().addTile(_b.removeTile(i, j));	
						}
						
					}
					
					
				}
			
		
			
			}
		
		//_dataStruct.nextTurn();
		//p.getRack().fillRack();
		}
		
		redrawRack();
		redrawBoard();
		showScore();
		_dataStruct.nextTurn();
		
	}
	
	public void redrawRack(){
		Player p = _dataStruct.getCurrentPlayer();
		
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
	
	public void redrawBoard(){
			for(int c = 0; c<400; c++){
				JButton b = _boardButtons.get(c);
				if(_b.getTile(c/20, c%20) != null)
					b.setText(Character.toString(_b.getTile(c/20, c%20).getChar())+":"+Integer.toString(_b.getTile(c/20, c%20).getValue()));
				else
					b.setText("");
			}
		}
	public void showScore(){
		JLabel jl =(JLabel) _playerPanels.get(_dataStruct.getTurn()).getComponent(0);
		jl.setText(_dataStruct.getPlayerName(_dataStruct.getTurn())+ ":" +Integer.toString(_dataStruct.getCurrentPlayer().getScore()));
	}
		
		
		
}
	
	
	

