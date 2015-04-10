package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.Board;
import code.Scrabble;
import code.Tile;


public class BoardButtonHandler implements ActionListener {

	
	
	private Scrabble _dataStruct;
	private int _row;
	private int _col;

	public BoardButtonHandler(int i, Scrabble dataStruct) {
		_dataStruct = dataStruct;
		_row = i/20;
		_col = i%20;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(_dataStruct.getSelectedTile() != null){
		Board b = _dataStruct.getBoard();
		b.addTile(_dataStruct.getSelectedTile(), _row, _col);
		JButton temp = (JButton) e.getSource();
		temp.setText(Character.toString(_dataStruct.getSelectedTile().getChar())+ ":"+ Integer.toString(_dataStruct.getSelectedTile().getValue()));
		_dataStruct.setSelectedTile(null);
		}
	}
	
}
