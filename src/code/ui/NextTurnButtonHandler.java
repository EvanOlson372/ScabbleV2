package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.Board_030;
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
	private Board_030 _b;
	
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
		_dataStruct.createWordPlayed();
		
		System.out.println(_dataStruct.getFirstWordPlayed());
		System.out.println(_dataStruct.getSecondWordPlayed());
		
		if(_dataStruct.getSecondWordPlayed() == "" || _dataStruct.getSecondWordPlayed().length() == 1){
			if(DictionaryScanner.compareWord(_dataStruct.getFirstWordPlayed(), "src/code/Dictionary" ) == true)
			{
				_dataStruct.setLegitimateWord();
				p.addScore(p.getScore(), _dataStruct.countWordScore(_dataStruct.getFirstWordPlayed()));
				
					for (int i= 0;i<20;i++){
						for (int j=0;j<20;j++){
							if(_b.Tile_From_Board(i, j) != null){
								_b.Tile_From_Board(i, j).setBool(true);
							}
						}
					}
					p.getRack().fillRack();
						
				/**
				 * Driver Evan Olson
				 * Navigator Leonardo Evangelista
				 */
			}
		}
		if(_dataStruct.getFirstWordPlayed() == "" || _dataStruct.getFirstWordPlayed().length() == 1){
			
			if(DictionaryScanner.compareWord(_dataStruct.getSecondWordPlayed(), "src/code/Dictionary" ) == true)
			{
				_dataStruct.setLegitimateWord();
					p.addScore(p.getScore(), _dataStruct.countWordScore(_dataStruct.getSecondWordPlayed()));
	
				
					for (int i= 0;i<20;i++){
						for (int j=0;j<20;j++){
							if(_b.Tile_From_Board(i, j) != null){
								_b.Tile_From_Board(i, j).setBool(true);
							}
						}
					}
					p.getRack().fillRack();
			}		
				/**
				 * Driver Evan Olson
				 * Navigator Leonardo Evangelista
				 */
		}
		if(_dataStruct.getFirstWordPlayed().length() > 1 && _dataStruct.getSecondWordPlayed().length() > 1){
			if(DictionaryScanner.compareWord(_dataStruct.getFirstWordPlayed(), "src/code/Dictionary") == true
					&& DictionaryScanner.compareWord(_dataStruct.getFirstWordPlayed(), "src/code/Dictionary") == true){
				
				
				_dataStruct.setLegitimateWord();
				p.addScore(p.getScore(), _dataStruct.countWordScore(_dataStruct.getFirstWordPlayed()));
				p.addScore(p.getScore(), _dataStruct.countWordScore(_dataStruct.getSecondWordPlayed()));

			
				for (int i= 0;i<20;i++){
					for (int j=0;j<20;j++){
						if(_b.Tile_From_Board(i, j) != null){
							_b.Tile_From_Board(i, j).setBool(true);
						}
					}
				}
				p.getRack().fillRack();
			}
		}
		else  {
			for (int i= 0;i<20;i++){
				for (int j = 0;j<20;j++){
					if(_b.Tile_From_Board(i, j) != null){
						if (_b.Tile_From_Board(i, j).getBool()== false){
						p.getRack().addTile(_b.removeTilefromBoard(i, j));	
						}	
					}
				}			
			}
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
				if(_b.Tile_From_Board(c/20, c%20) != null)
					b.setText(Character.toString(_b.Tile_From_Board(c/20, c%20).getChar())+":"+Integer.toString(_b.Tile_From_Board(c/20, c%20).getValue()));
				else
					b.setText("");
			}
		}
	public void showScore(){
		JLabel jl =(JLabel) _playerPanels.get(_dataStruct.getTurn()).getComponent(0);
		jl.setText(_dataStruct.getPlayerName(_dataStruct.getTurn())+ ":" +Integer.toString(_dataStruct.getCurrentPlayer().getScore()));
	}
		
		
		
}
	
	
	

