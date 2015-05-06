package tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import code.TileInventory_030;
import code.Tile_030;
import code.TileRack_030;

public class TileRackTest_030 {

	// Test maximum capacity of 12 for tile rack
	@Test
	public void capacityTest(){
		TileInventory_030 inv = new TileInventory_030();
		TileRack_030 rack = new TileRack_030(inv);
		assertTrue("The tile rack should fill to a maximum size of 12 but I got " + rack.getSize(), rack.getSize() == 12);
	}

	// Test removing tiles
	@Test
	public void removeTest(){
		TileInventory_030 inv = new TileInventory_030();
		TileRack_030 rack = new TileRack_030(inv);
		Tile_030 t = rack.removeTile(0);
		assertTrue("I removed one tile at index 0, now the rack size should be 11, but I got " + rack.getSize(), rack.getSize() == 11);
	}

	// Test adding tiles after removing tiles
	@Test
	public void addTest(){
		TileInventory_030 inv = new TileInventory_030();
		TileRack_030 rack = new TileRack_030(inv);
		rack.removeTile(0);
		rack.removeTile(1);
		rack.removeTile(2);
		rack.fillRack();
		assertTrue("I removed 3 tiles, then filled the rack, it's size should be 12, but I got " + rack.getSize(), rack.getSize() == 12);
	}



}