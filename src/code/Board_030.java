package code;

public class Board_030 {

	/**
	 * 2-D array of tiles to store tiles.
	 */
	private Tile_030[][] _board;

	/**
	 * Class constructor.
	 */
	public Board_030(){
		_board = new Tile_030[20][20];
	}

	/**
	 * Adds a tile to a position on the board.
	 * 
	 * @param t	the tile to be added
	 * @param x	the x-coordinate of the placement location
	 * @param y the y-coordinate of the placement location
	 */
	public void addTile(Tile_030 t, int x, int y){
		_board[x][y] = t;
	}

	/**
	 * Removes a tile from a position on the board.
	 * 
	 * @param x the x-coordinate of the tile to be removed
	 * @param y the y-coordinate of the tile to be removed
	 * @return
	 */
	public Tile_030 removeTile(int x, int y){
		Tile_030 temp = _board[x][y];
		_board[x][y] = null;
		return temp;
	}

	/**
	 * Returns the tile at a position.
	 * 
	 * @param x the x-coordinate of the position
	 * @param y the y-coordinate of the position
	 * @return
	 */
	public Tile_030 getTile(int x, int y){
			return _board[x][y];
	}
	
}
