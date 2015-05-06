package tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import code.TileInventory_030;
import code.Tile_030;

public class TileTest_030 {
	
	//test getChar method to return correct character of a tile
	@Test
	public void checkChar(){
		char expected = 'W';
		Tile_030 t = new Tile_030('W',5);
		char actual = t.getChar();
		assertTrue("I expected the tile's letter to be "+expected+" but instead it is"+actual, expected==actual);
	}
	
	//test getValue method to return value of a tile
	@Test
	public void checkValue(){
		int expected = 5;
		Tile_030 t = new Tile_030('W',5);
		int actual = t.getValue();
		assertTrue("I expected the tile's letter to be "+expected+" but instead it is"+actual, expected==actual);
	}

}
