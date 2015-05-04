package code;

public class Tile_030 {

	/**
	 * Stores the character of the tile.
	 */
	private char _letter;
	/**
	 * Stores the point value of the tile.
	 */
	private int _pointValue;
	private boolean _bool;
	
	/**
	 * Class constructor.
	 * 
	 * @param c character of the tile
	 * @param i point value of the tile
	 */
	public Tile_030(char c, int i){
		_letter = c;
		_pointValue = i;
	}
	
	/**
	 * Gets the character value of the tile.
	 * 
	 * @return character value of the tile.
	 */
	public char getChar(){
		return _letter;
	}
	
	/**
	 * Gets the point value of the tile.
	 * 
	 * @return the point value of the tile.
	 */
	public int getValue(){
		return _pointValue;
	}
	public boolean getBool(){
		return _bool;
		/**
		 * Driver Leonardo Evangelista
		 * Navigator Evan Olson
		 * 
		 */
	}
	public void setBool(boolean b){
		_bool = b;
		/**
		 * Driver Leonardo Evangelista
		 * Navigator Evan Olson
		 */
	}
}
