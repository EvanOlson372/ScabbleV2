package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Scrabble;


public class ButtonHandler implements ActionListener {

	
	
	private Scrabble _dataStruct;
	private int _row;
	private int _col;

	public ButtonHandler(int i, Scrabble dataStruct) {
		_dataStruct = dataStruct;
		_row = i/3;
		_col = i%3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_dataStruct.mark(_row, _col);
	}

}
