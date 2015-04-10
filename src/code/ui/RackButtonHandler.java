package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
		JButton b = (JButton) e.getSource();
	
		if(_i/12 == _dataStruct.getTurn() && _i < p.getRackSize()){			
			_dataStruct.setSelectedTile(p.pickTile(_i));
			ArrayList<JButton> a = new ArrayList<JButton>(); 
			
			while (p.pickTile(_i)!=null && _i<=((_dataStruct.getTurn()+1)*12)-1){
				if (_i+1==((_dataStruct.getTurn()+1)*12)-1){
					
				}
				else {
					a.get(_i).equals(a.get(_i+1));
					_i++;
				}
				
			}
			a.get(_i-1).setText("");
	
		}
		else
		System.out.println("Fuck Off");
		
	}

}
