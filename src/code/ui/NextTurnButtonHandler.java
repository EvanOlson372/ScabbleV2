package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		
		
		
		
		
		
		
		
	}
	

}
