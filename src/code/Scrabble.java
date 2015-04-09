package code;




import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.ArrayList;
import java.util.Random;

public class Scrabble {

	
	/**
	 * Stores tiles.
	 */
	private Inventory _inv;
	
	/**
	 * Stores color 
	 */
	public Color _color;
	/**
	 * Stores players turn
	 */
	private int _turn;
	/**
	 * Stores players.
	 */
	public ArrayList<Player> _players;
	/**
	 * tile board to be played on
	 */
	private Board _board;
	/**
	 * Number of players
	 */
	private int _numberOfPlayers;
	
	/**
	 * Class constructor
	 */
	public Scrabble(){
		_inv = new Inventory();
		_board = new Board();
		_players = new ArrayList<Player>();
		_numberOfPlayers = 4;
		_turn = 0;
		
		for (int i = 0; i < _numberOfPlayers; i++){
			addNewPlayer();
		
	
		}
	}
	/**
	 * Adds a new player to the game.
	 */
	public void addNewPlayer(){
		_players.add(new Player(_inv, _color));
	}
	
	public Player getPlayer(int i){
		return _players.get(i);
	}

	public void placeTile(int _row, int _col) {
		System.out.println(_board.getTile(_row, _col));
		Player p = _players.get(_turn);
		_board.addTile(p.playTile(), _row, _col); 
		System.out.println(_board.getTile(_row, _col));
		
	}
	
	public Tile getCurrentTile(int _row, int _col){
		return _board.getTile(_row, _col);
		
	}






}
