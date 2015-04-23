package code;




import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;
import java.util.ArrayList;
import java.util.Random;

public class Scrabble extends Observable {

	
	
	private Player _p;
	/**
	 * stores current selected tile
	 */
	private Tile _tileHolder;
	
	/**
	 * Stores tiles.
	 */
	private Inventory _inv;
	
	/**
	 * after first turn flag
	 */
	public boolean _firstLegitimateWord;
	/**
	 * Stores color 
	 */
	public Color _color;
	/**
	 * Stores players turn
	 */
	private int _turn;
	/**
	 * Stores players.
	 */
	public ArrayList<Player> _players;
	/**
	 * tile board to be played on
	 */
	private Board _board;
	/**
	 * Number of players
	 */
	private int _numberOfPlayers;
	/**
	 * stores players names
	 */
	public ArrayList<String> _playerNames;
	/**
	 * Word holder
	 */
	public String _wordBeingPlayed;
	
	/**
	 * stores letter locations on
	 */
	public ArrayList<Integer> _row;
	public ArrayList<Integer> _col;
	
	
	/**
	 * Class constructor
	 */
	public Scrabble(){
		_inv = new Inventory();
		//_color =_p.getColor();
		_row = new ArrayList<Integer>();
		_col = new ArrayList<Integer>();
		_board = new Board();
		_players = new ArrayList<Player>();
		_firstLegitimateWord = false;
		_numberOfPlayers = 0;
		_turn = 0;
		_wordBeingPlayed = "";
	}
	
	/**
	 * sets that the first legitimate wiord has been played
	 * 
	 */
	public void setLegitimateWord(){
		_firstLegitimateWord = true;
	}
	public boolean getLegitamateWord(){
		return _firstLegitimateWord ; 
	}
	
	/**
	 * Adds a new player to the game.
	 */
	public void addNewPlayer(){
		_players.add(new Player(_inv));
		_numberOfPlayers++;
	}
	
	/**
	 * gets currently selected tile
	 */
	public Tile getSelectedTile(){
		return _tileHolder;
	}
	/**
	 * when a letter is played this stores its location in the letter location array
	 * 
	 */
	public void addToLocation(int r, int c){
		_row.add(r);
		_col.add(c);
	}
	
	/**
	 * Selects current tile
	 */
	public void setSelectedTile(Tile t){
		_tileHolder = t;
	}

	/**
	 * advances the turn
	 */
	public void nextTurn(){
		_turn++;
		if(_turn == _numberOfPlayers)
			_turn = 0;
		_wordBeingPlayed = "";
		_row.clear();
		_col.clear();
	}
	
	/**
	 * gets the current turn
	 */
	public int getTurn(){
		return _turn;
	}
	
	/**
	 * gets the current player
	 */
	public Player getCurrentPlayer(){
		return _players.get(_turn);
	}
	/**
	 * gets the board
	 */
	public Board getBoard(){
		return _board;
	}

	/**
	 * gets number of players
	 */
	public int getNumberOfPlayers(){
		return _numberOfPlayers;
		
	}
	/**
	 * adds [players names
	 * @param s
	 */
	public void addPlayerName(ArrayList players){
		_playerNames = players;
	}
	/**
	 * gets players name
	 */
	public String getPlayerName(int i){
		return _playerNames.get(i);
	}
	/**
	 * getPlayer
	 * @return 
	 */
	public Player getPlayer(int i){
		return _players.get(i);
	}

	/**
	 * Gets word that was played
	 */
	public String getWordPlayed(){
		//setChanged();      // defined in superclass
		//notifyObservers(); // defined in superclass
		return _wordBeingPlayed;
	}
	
	/**
	 * Creates word that was played
	 * 
	 * 
	 */
	public void createWordPlayed(){
		Collections.sort(_row);
		Collections.sort(_col);
		int r = 0;
		int c = 0;
		int i = 0;
		
		for(i = 0; i<_row.size(); i++){
			if(_row.get(0) == _row.get(i))
				r++;
			if(_col.get(0) == _col.get(i))
				c++;
		}
		
		if(r == _row.size()){
			i = 0;
			while(_board.getTile(_row.get(0), i) == null){
				i++;	
			}
			while(_board.getTile(_row.get(0), i) != null){
				_wordBeingPlayed = _wordBeingPlayed + _board.getTile(_row.get(0), i).getChar();
				i++;
			}
		}		
		
		if(c == _col.size()){
			i = 0;
			while(_board.getTile(i, _col.get(0)) == null){
				i++;
			}
			while(_board.getTile(i, _col.get(0)) != null){
				_wordBeingPlayed = _wordBeingPlayed + _board.getTile(i, _col.get(0)).getChar();
				i++;
			}
		}
	}
	
	
	
	/**
	 * counts up word score
	 */
	
	
	
	/**
	 * added all but two accessors and mutators 
	 * Driver Evan Olson
	 * Navigator Leonardo Evangelista
	 * @param s
	 * @return
	 */
	public int countWordScore(String s){
		  int score = 0;
		
		for(int i = 0; i < s.length(); i++ ){
			char c = s.charAt(i);
			
				// Create 29 of each vowel with point value 1
				if ((c == 'A')||(c == 'E')||(c == 'I')||(c == 'O')||(c =='U')){
					score += 1;
				}
				// Create 15 y's with point value 2
				else if (c == 'Y'){
					score += 2;
				}
				// Create 12 of every other letter with point value 5
				else{
					score += 5;
					
				}
		}
		
		
		return score;
	}
	
	
	/**
	 * gets the current tile bag
	 */
	
	public Inventory getInventory(){
		return _inv;
	}
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
	

