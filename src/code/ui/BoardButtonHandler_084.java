package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.Board_030;
import code.Main_030;
import code.Tile_030;


public class BoardButtonHandler_084 implements ActionListener {

	
	
	private Main_030 _dataStruct;
	private int _row;
	private int _col;

	public BoardButtonHandler_084(int i, Main_030 dataStruct) {
		_dataStruct = dataStruct;
		_row = i/20;
		_col = i%20;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print(_row+ ", "+_col);
		Board_030 b = _dataStruct.getBoard();
		
		if(_dataStruct.getSelectedTile() != null){
			if(_dataStruct.getLegitamateWord() == true){
				//error in this if()  when at index 19 for row or col needs fixed
				if(b.getTile(_row+1, _col) != null || b.getTile(_row-1, _col) != null || b.getTile(_row, _col+1)!= null || b.getTile(_row, _col-1) != null){
					b.addTile(_dataStruct.getSelectedTile(), _row, _col);
					JButton temp = (JButton) e.getSource();
					temp.setText(Character.toString(_dataStruct.getSelectedTile().getChar())+ ":"+ Integer.toString(_dataStruct.getSelectedTile().getValue()));
					temp.setForeground(_dataStruct.getCurrentPlayer().getColor());
					_dataStruct.addToLocation(_row, _col);
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
						_dataStruct.getSelectedTile().setBool(false);
						_dataStruct.setSelectedTile(null);
					}
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
