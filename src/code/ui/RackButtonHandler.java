package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import code.Player;
import code.Scrabble;

public class RackButtonHandler implements ActionListener  {
	int _c;
	Scrabble _dataStruct;
	
	public RackButtonHandler(int c, Scrabble dataStruct){
		_c = c;
		_dataStruct = dataStruct;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player p = _dataStruct.getCurrentPlayer();
		if(_c/12 == _dataStruct.getTurn() && _c%12 < p.getRack().getSize()){
			_dataStruct.setSelectedTile(p.pickTile(_c%12));
			JButton b = (JButton) e.getSource();
			b.setText("");
		}
		else{
		System.out.println("That's not yours");
		
		}
		
		}
	/** 
	 * for the whole class
	 * Driver Leonardo Evangelista
	 * Navigator Evan Olson 
	 * 
	 */

}
