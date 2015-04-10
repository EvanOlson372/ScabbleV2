package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.DictionaryScanner;
import code.Player;
import code.Scrabble;

public class NextTurnButtonHandler implements ActionListener {

	private Scrabble _dataStruct;
	private int _row;
	private int _col;
	
	public NextTurnButtonHandler(Scrabble dataStruct){
		_dataStruct = dataStruct;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player p = _dataStruct.getCurrentPlayer();
		DictionaryScanner ds = new DictionaryScanner();
		System.out.println(p.getScore());
		if(DictionaryScanner.compareWord(_dataStruct.getWordPlayed(), "src/code/Dictionary" ) == true){
			p.addScore(p.getScore(), _dataStruct.countWordScore(_dataStruct.getWordPlayed()));
		}
		System.out.println(p.getScore());
		_dataStruct.nextTurn();
		
		
		
		
		
		
		
		
		
		
	}
	

}
