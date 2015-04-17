package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.Board;
import code.DictionaryScanner;
import code.Player;
import code.Scrabble;

public class NextTurnButtonHandler implements ActionListener {

	private Scrabble _dataStruct;
	private JButton [][] _rackButtons;
	private int _row;
	private int _col;
	private Board _b;
	
	public NextTurnButtonHandler(Scrabble dataStruct, JButton [][] rackButtons){
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
			p.printRack();
		
	}
	
	
	
	
}
