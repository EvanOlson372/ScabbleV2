package code.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;

import code.Player_030;
import code.Main_030;
import code.Tile_030;

public class RackButtonHandler_084 implements ActionListener  {
	int _r;
	int _c;
	Main_030 _dataStruct;
	JButton [][] _rackButtons;
	
	public RackButtonHandler_084(int r, int c, Main_030 dataStruct, JButton [][] rackButtons){
		_r = r;
		_c = c;
		_dataStruct = dataStruct;
		_rackButtons = rackButtons;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player_030 p = _dataStruct.getCurrentPlayer();
		if(_r == _dataStruct.getTurn() && _c < p.getRack().getSize()){
			if(_dataStruct.getSelectedTile() == null){
				_dataStruct.setSelectedTile(p.pickTile(_c%12));
				redrawRack();
			}
			
		}
		else{
		System.out.println("That's not yours");
		}
		
	}
	
	
	public void redrawRack(){
		Player_030 p = _dataStruct.getCurrentPlayer();
		
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
