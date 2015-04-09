package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.Scrabble;


public class ButtonHandler implements ActionListener {

	
	
	private Scrabble _dataStruct;
	private int _row;
	private int _col;

	public ButtonHandler(int i, Scrabble dataStruct) {
		_dataStruct = dataStruct;
		_row = i/20;
		_col = i%20;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		_dataStruct.placeTile(_row, _col);
		JButton b = (JButton) e.getSource();
		b.setText(Character.toString(_dataStruct.getCurrentTile(_row, _col).getChar()));
	}
	
	
}
