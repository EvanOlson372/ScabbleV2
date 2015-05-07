package code;

import java.util.Random;

public class Board {

	/**
	 * 2-D array of tiles to store tiles.
	 */
	private Tile[][] _board;

	/**
	 * Class constructor.
	 */
	public Board(){
		_board = new Tile[20][20];
	}

	/**
	 * Adds a tile to a position on the board.
	 * 
	 * @param t	the tile to be added
	 * @param x	the x-coordinate of the placement location
	 * @param y the y-coordinate of the placement location
	 */
	public void addTile(Tile t, int x, int y){
		_board[x][y] = t;
	}

	/**
	 * Removes a tile from a position on the board.
	 * 
	 * @param x the x-coordinate of the tile to be removed
	 * @param y the y-coordinate of the tile to be removed
	 * @return
	 */
	public Tile removeTile(int x, int y){
		Tile temp = _board[x][y];
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
	public Tile getTile(int x, int y){
			return _board[x][y];
	}
	
	public void multboard(){
		Random randGen = new Random();
		
		for(int i = 0; i < 60; i++){
			int r = randGen.nextInt(20);
			int c = randGen.nextInt(20);
	
			if(_board[r][c] == null)
				_board[r][c] = new Tile('*',1,1,2);
			else
				i--;
			System.out.println(i);

		}

		for(int i = 0; i < 40; i++){
			int r = randGen.nextInt(20);
			int c = randGen.nextInt(20);
	
			if(_board[r][c] == null)
				_board[r][c] = new Tile('*',1,1,3);
			else
				i--;
			System.out.println(i);

		}

		
	}
	
	public void printBoard(){
		
		for( int r = 0; r<=19; r++){
			System.out.print("[ ");
			for(int c = 0; c<=19; c++){	
				if(_board[r][c] != null)
				System.out.print(_board[r][c].getChar()+" ,");	
				else
				System.out.print(" ,");
			}
			System.out.println("]");
			
		}
	}
	
}
