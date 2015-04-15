package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import code.Player;
import code.Scrabble;

public class RackButtonHandler implements ActionListener  {
	int _c;
	Scrabble _dataStruct;
	ArrayList<JButton> _rackButtons;
	
	public RackButtonHandler(int c, Scrabble dataStruct, ArrayList<JButton> rackButtons){
		_c = c;
		_dataStruct = dataStruct;
		_rackButtons = rackButtons;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player p = _dataStruct.getCurrentPlayer();
		if(_c/12 == _dataStruct.getTurn() && _c%12 < p.getRack().getSize()){
			_dataStruct.setSelectedTile(p.pickTile(_c%12));
			redrawRack();
			
		}
		else{
		System.out.println("That's not yours");
		
		}
		
		}
	
	public void redrawRack(){
		Player p = _dataStruct.getCurrentPlayer();
		for(int i = 0; i<(_c%12); i++){
			System.out.print(i);
			_rackButtons.get(i*_dataStruct.getTurn()).setText(Character.toString(p.getRack().get(i).getChar())+":"+ Integer.toString(p.getTile(i).getValue()));
			
		}
	}
	
	
	
	/** 
	 * for the whole class
	 * Driver Leonardo Evangelista
	 * Navigator Evan Olson 
	 * 
	 */

}
