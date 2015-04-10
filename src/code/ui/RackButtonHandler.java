package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		if(_i/12 == _dataStruct.getTurn() && _i < p.getRack().getSize() ){
			System.out.println("test");
			_dataStruct.setSelectedTile(p.pickTile(_i));
		}
		else
		System.out.println("Fuck Off");
		
	}

}
