package code;

import java.awt.Color;

public class Player {
	
	/**
	 * Records the score.
	 */
	private int _score = 0;
	
	/**
	 * Allows the Player to access the Tiles on its own TileRack.
	 */
	private TileRack _rack;
	//private Inventory _inv;
	
	/**
	 * Class constructor.
	 * 
	 * @param inv can draw Tiles from the Inventory
	 */
	public Player(Inventory inv){
		_score = 0;
		//_inv = inv;
		_rack = new TileRack(inv);
	}
	
	/**
	 * Gets the int value of the Player's score.
	 * 
	 * @return Player's score.
	 */
	public int getScore(){
		return _score;
	}
	

	public Tile pickTile(int i){
		return _rack.removeTile(i);
	}


	public Tile getTile(int i){
	return _rack.get(i);	
	}
	

	
	public Tile playTile(){
		return _rack.removeTile(_rack.getSize()-1);
	}
	
	public TileRack getRack(){
		return _rack;
	}


	/**
	 * Adds the new points to the original score
	 * 
	 * @param score Score to be added to
	 * @param i additional points added to the score
	 * @return Player's score.
	 */
	public int addScore(int score, int i){
		_score = score;
		_score = _score + i;
		return _score;
	}
	/**
	 * get size of rack
	 */
	public int getRackSize(){
		return _rack.getSize();
	}
	
}