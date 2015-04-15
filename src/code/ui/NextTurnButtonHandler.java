package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Board;
import code.DictionaryScanner;
import code.Player;
import code.Scrabble;

public class NextTurnButtonHandler implements ActionListener {

	private Scrabble _dataStruct;
	private int _row;
	private int _col;
	private Board _b;
	
	public NextTurnButtonHandler(Scrabble dataStruct){
		_dataStruct = dataStruct;
		_b = _dataStruct.getBoard();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Player p = _dataStruct.getCurrentPlayer();
		DictionaryScanner ds = new DictionaryScanner();
		System.out.println(p.getScore());
		
		
		if(DictionaryScanner.compareWord(_dataStruct.getWordPlayed(), "src/code/Dictionary" ) == true)
		{
			
			p.addScore(p.getScore(), _dataStruct.countWordScore(_dataStruct.getWordPlayed()));
			
				for (int i= 0;i<20;i++){
					for (int j=0;j<20;i++){
					_b.getTile(i, j).setBool(true);
					}
				}
					
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
			/**
			 * Driver Leonardo Evangelista
			 * Navigator Evan Olson
			 */
			}
		System.out.println(p.getScore());
		_dataStruct.nextTurn();
		}
	}
}
