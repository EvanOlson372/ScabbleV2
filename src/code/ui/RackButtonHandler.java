package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.Player;
import code.Scrabble;

public class RackButtonHandler implements ActionListener  {
	int _i;
	Scrabble _dataStruct;
	
	public RackButtonHandler(int i, Scrabble dataStruct){
		_i = i;
		_dataStruct = dataStruct;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player p = _dataStruct.getCurrentPlayer();
		if(_i/12 == _dataStruct.getTurn()){
			_dataStruct.setSelectedTile(p.pickTile(_i%12));
			JButton b = (JButton) e.getSource();
			b.setText("");
		}
		else{
		System.out.println("Can't do that");
		
		}
		
		}
	/** 
	 * for the whole class
	 * Driver Leonardo Evangelista
	 * Navigator Evan Olson 
	 * 
	 */

}
