package code;

import java.awt.Color;

public class Player {

	/**
	 * Records the score.
	 */
	private int _score;
	private Color _color;
	
	/**
	 * Allows the Player to access the Tiles on its own TileRack.
	 */
	private TileRack _rack;
	private Inventory _inv;
	
	/**
	 * Class constructor.
	 * 
	 * @param inv can draw Tiles from the Inventory
	 */
	public Player(Inventory inv, Color col){
		_score = 0;
		_inv = inv;
		_rack = new TileRack(inv);
		_color = col;
	}
	
	/**
	 * Gets the int value of the Player's score.
	 * 
	 * @return Player's score.
	 */
	public int getScore(){
		return _score;
	}
<<<<<<< HEAD
	

	public Tile pickTile(int i){
		return _rack.removeTile(i);
	}


	public Tile getTile(int i){
	return _rack.get(i);	
	}
	

	
	public Tile playTile(){
		return _rack.removeTile(_rack.getSize()-1);
	}
	
=======
	/**
	 *
	 * @return Players Color
	 */
	public Color getColor(){
		return _color;
	}
	/**
	 * sets players color
	 * @param color
	 */
	public void setColor(Color color){
		_color = color;
	}
	
	public Tile playTile(){
		return _rack.removeTile(_rack.getSize()-1);
	}
	
>>>>>>> parent of 22b416f... Holy Fuck Tons OF SHIT!!
	public TileRack getRack(){
		return _rack;
	}

<<<<<<< HEAD

=======
>>>>>>> parent of 22b416f... Holy Fuck Tons OF SHIT!!
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
}