package gui;

import java.util.ArrayList;
import java.util.Observable;

public class IDEASfromTICTACTOE extends Observable{
	private Player[][] _board;
	private ArrayList<Player> _players;

	public IDEASfromTICTACTOE() {
		_board = new Player[3][3];
		_players = new ArrayList<Player>();
		_players.add(new Player('X'));
		_players.add(new Player('O'));
		}
		
	private void switchPlayers() {
		_players.add(_players.remove(0));
	}

	public void mark(int row, int col) {
		_board[row][col] = _players.get(0);
//		System.out.println("\""+toString()+"\"");
		switchPlayers();
		setChanged();      // defined in superclass
		notifyObservers(); // defined in superclass
	}

	@Override public String toString(){ 
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<_board.length; i++) {
			for (int j=0; j<_board[i].length; j++) {
				Player who = _board[i][j];
				if (who == null) {
					sb.append(' ');
				}
				else {
					sb.append(who.getMark());
				}
			}
		}
		return sb.toString();
	}
	
}
