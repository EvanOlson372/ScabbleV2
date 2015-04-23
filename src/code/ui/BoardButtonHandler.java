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
		Board b = _dataStruct.getBoard();
		if(_dataStruct.getLegitamateWord() == true){
			if(b.getTile(_row+1, _col) != null || b.getTile(_row-1, _col) != null || b.getTile(_row, _col+1)!= null || b.getTile(_row, _col-1) != null){
				b.addTile(_dataStruct.getSelectedTile(), _row, _col);
				JButton temp = (JButton) e.getSource();
				temp.setText(Character.toString(_dataStruct.getSelectedTile().getChar())+ ":"+ Integer.toString(_dataStruct.getSelectedTile().getValue()));
				temp.setForeground(_dataStruct.getCurrentPlayer().getColor());
				_dataStruct.addToLocation(_row, _col);
				_dataStruct.addToWordBeingPlayed(_dataStruct.getSelectedTile().getChar());
				_dataStruct.getSelectedTile().setBool(false);
				_dataStruct.setSelectedTile(null);
				
			}
		}
		
		else{
			if(_dataStruct.getSelectedTile() != null){
				if(b.getTile(_row, _col)==null){	
					b.addTile(_dataStruct.getSelectedTile(), _row, _col);
					JButton temp = (JButton) e.getSource();
					temp.setText(Character.toString(_dataStruct.getSelectedTile().getChar())+ ":"+ Integer.toString(_dataStruct.getSelectedTile().getValue()));
					temp.setForeground(_dataStruct.getCurrentPlayer().getColor());
					_dataStruct.addToLocation(_row, _col);
					_dataStruct.addToWordBeingPlayed(_dataStruct.getSelectedTile().getChar());
					_dataStruct.getSelectedTile().setBool(false);
					_dataStruct.setSelectedTile(null);
				}
			}
		}
	/** 
	 * for the whole class 
	 * Evan Olson
	 * Leonardo Evangelista
	 */
	}
	
	
	
	
}
