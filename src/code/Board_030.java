package code;

public class Board_030 {

	//notes were added and edited by team 084, however no other methods or variables from team 030 were changed
	
	/**
	 * 2-D array of tiles to store tiles.
	 */
	private Tile_030[][] Grid;

	/**
	 * Class constructor.
	 */
	public Board_030(){
		Grid = new Tile_030[20][20];
	}

	/**
	 * Adds a tile to a position on the board.
	 * 
	 * @param t	the tile to be added
	 * @param x	the x-coordinate of the placement location
	 * @param y the y-coordinate of the placement location
	 */
	public void placeTile(Tile_030 q, int x, int y){
		Grid[x][y] = q;
	}

	/**
	 * Removes a tile from a position on the board.
	 * 
	 * @param x the x-coordinate of the tile to be removed
	 * @param y the y-coordinate of the tile to be removed
	 * @return
	 */
	public Tile_030 removeTilefromBoard(int row, int col){
		Tile_030 t = Grid[row][col];
		Grid[row][col] = null;
		return t;
	}

	/**
	 * Returns the tile at a position.
	 * 
	 * @param x the x-coordinate of the position
	 * @param y the y-coordinate of the position
	 * @return
	 */
	public Tile_030 getTile(int x, int y){
			return Grid[x][y];
	}
	
}
