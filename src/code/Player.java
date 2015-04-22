package code;

import java.awt.Color;
import java.util.Random;

public class Player {
	private Color _c;
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
	public Player(Inventory inv, Color c){
		_score = 0;
		//_inv = inv;
		_rack = new TileRack(inv);
		_c =c;
	}
	
	public void createColor(){
	  Random rand = new Random();
	  float r = rand.nextFloat();
	  float g = rand.nextFloat();
	  float b = rand.nextFloat();
	  
	  Color color = new Color (r,g,b);
	  _c = color;

	}
	/**
	 * Gets the int value of the Player's score.
	 * 
	 * @return Player's score.
	 */
	public int getScore(){
		return _score;
	}
	
	/**
	 * chooses a tile from the payers RACK!!
	 */
	public Tile pickTile(int i){
		return _rack.removeTile(i);
	}
	/**
	 * looks at tile without changing anything
	 */
	public Tile getTile(int i){
	return _rack.get(i);	
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
	
	
	public TileRack getRack(){
		return _rack;
		/**
		 * Driver Leonardo Evanelista
		 * Navigator Evan Olson
		 */
	}
	public void addTileToRack(Tile t){
		_rack.addTile(t);
		/**
		 * Driver Leonardo Evangelista
		 * Navigator Evan Olson
		 */
	}
	
	public void printRack(){
		for(int i = 0; i<getRack().getSize();i++)
		System.out.print(getRack().get(i).getChar());
		
		
	}
	public Color getColor(){
		return _c;
	}
	public void setColor(Color c){
		_c =c;
	}
}