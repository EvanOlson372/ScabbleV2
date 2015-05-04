package code;

import java.util.ArrayList;

public class TileRack_030 {
	
	/**
	 * Inventory to draw tiles from
	 */
	private Inventory_030 _inv;
	
	/**
	 * Stores the tiles that can be played.
	 */
	private ArrayList<Tile_030> _rack;
	
	/**
	 * Class cosntructor.
	 * 
	 * @param inv inventory to draw tiles from
	 */
	public TileRack_030(Inventory_030 inv){
		_inv = inv;
		_rack = new ArrayList<Tile_030>();
		fillRack();
	}
	
	/**
	 * Fills tile rack to maximum capacity of 12
	 */
	public void fillRack(){
		while (_rack.size() < 12){
			_rack.add(_inv.removeRandomTile());
		}
	}
	
	/**
	 * Removes a tile from rack.
	 * 
	 * @param t tile to be removed from the rack
	 * @return tile removed from the rack
	 */
	public Tile_030 removeTile(Tile_030 t){
		Tile_030 tileToRemove = t;
		_rack.remove(t);
		return tileToRemove;
	}
	
	/**
	 * Removes a tile from an index from rack
	 * 
	 * @param i index of tile to be removed
	 * @return tile removed from the rack
	 */
	public Tile_030 removeTile(int i){
		Tile_030 tileToRemove = _rack.get(i);
		_rack.remove(i);
		return tileToRemove;
	}

	/**
	 * Gets size of the tile rack
	 * 
	 * @return size of the tile rack
	 */
	public int getSize() {
		return _rack.size();
	}
	public void addTile(Tile_030 t){
		_rack.add(t);
	}
	
	public Tile_030 get(int i) {
		return _rack.get(i);
	}
	}

	/** 
	 * for addTile and get methods 
	 * Driver Leonardo Evangelista
	 * Navigator Evan Olson
	 */


