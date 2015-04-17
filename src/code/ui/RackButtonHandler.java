package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;

import code.Player;
import code.Scrabble;
import code.Tile;

public class RackButtonHandler implements ActionListener  {
	int _r;
	int _c;
	Scrabble _dataStruct;
	JButton [][] _rackButtons;
	
	public RackButtonHandler(int r, int c, Scrabble dataStruct, JButton [][] rackButtons){
		_r = r;
		_c = c;
		_dataStruct = dataStruct;
		_rackButtons = rackButtons;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player p = _dataStruct.getCurrentPlayer();
		if(_r == _dataStruct.getTurn() && _c < p.getRack().getSize()){
			_dataStruct.setSelectedTile(p.pickTile(_c%12));
			redrawRack();
			
		}
		else{
		System.out.println("That's not yours");
		}
		
	}
	
	
	public void redrawRack(){
		Player p = _dataStruct.getCurrentPlayer();
		
			for(int c = 0; c<12; c++){
				if(c<p.getRack().getSize())
				{
					JButton b = _rackButtons[_dataStruct.getTurn()][c];
					b.setText(Character.toString(_dataStruct.getCurrentPlayer().getRack().get(c).getChar()) + ":" + Integer.toString(p.getTile(c).getValue()));
				}
				else{
					JButton b = _rackButtons[_dataStruct.getTurn()][c];
					b.setText(" ");
					
				}
					
			
			}
		
	}
	
	
	
	/** 
	 * for the whole class
	 * Driver Leonardo Evangelista
	 * Navigator Evan Olson 
	 * 
	 */

}
