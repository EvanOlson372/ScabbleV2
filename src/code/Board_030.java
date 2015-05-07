package code;

public class Board_030 {

	//All methods and variables are unchanged, only the notes have been edited
	/**
	 * 2-D array of tiles to store tiles.
	 */
	private Tile[][] Grid;

	/**
	 * Class constructor.
	 */
	public Board_030(){
		Grid = new Tile[20][20];
	}

	/**
	 * Adds a tile to a position on the board.
	 * 
	 * @param t	the tile to be added
	 * @param x	the x-coordinate of the placement location
	 * @param y the y-coordinate of the placement location
	 */
	public void placeTile(Tile q, int x, int y){
		Grid[x][y] = q;
	}

	/**
	 * Removes a tile from a position on the board.
	 * 
	 * @param x the x-coordinate of the tile to be removed
	 * @param y the y-coordinate of the tile to be removed
	 * @return
	 */
	public Tile removeTilefromBoard(int row, int col){
		Tile t = Grid[row][col];
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
	public Tile Tile_From_Board(int row, int col){
			return Grid[row][col];
	}
	
}
