package tests;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.Board_030;
import code.Tile;

public class BoardTest {
	@Test
	public void initializedEmptyBoardTest(){
		//test that initialized board is empty
		Board_030 b = new Board_030();
		int nullTileCount=0;
		for (int i=0; i<20; i++){
			for (int j=0; j<20;j++){
				if(b.Tile_From_Board(i, j)==null){
					nullTileCount=nullTileCount+1;
				}
			}
		}
		assertTrue("I expected a new board to contain 400 empty spaces, but there were only "+nullTileCount,nullTileCount==400);
	}
	@Test
	public void addTest(){
		//test that we can add a tile to a spot
		Board_030 b = new Board_030();
		Tile t = new Tile('y',2);
		b.placeTile(t,2,2);
		assertTrue("I tried to add a tile to the board, but it wasn't there", t==b.Tile_From_Board(2, 2));
	}
	//test that the correct tile is removed from a spot
	@Test
	public void removeTest(){
		Board_030 b = new Board_030();
		Tile tile = new Tile('A', 1);
		b.placeTile(tile,19,2);
		Tile temp=b.removeTilefromBoard(19,2);
		assertTrue("I tried to remove tile "+tile+" from the board, but instead removed "+temp,tile.equals(temp));
	}
	//test that spot on board is empty after removing a tile
	@Test
	public void emptyAfterRemovalTest(){
		Board_030 b = new Board_030();
		boolean testNull=false;
		Tile tile = new Tile('z',5);
		b.placeTile(tile,7,7);
		b.removeTilefromBoard(7,7);
		assertTrue("After removing a tile, the board space was not empty", b.Tile_From_Board(7,7)==null);
	}

}
