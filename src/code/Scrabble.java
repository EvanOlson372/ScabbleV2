package code;




import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.ArrayList;
import java.util.Random;

public class Scrabble extends Observable {


	
	/**
	 * stores current selected tile
	 */
	private Tile _tileHolder;
	
	/**
	 * Stores tiles.
	 */
	private Inventory _inv;
	
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
	String _wordBeingPlayed;
	/**
	 * Class constructor
	 */
	public Scrabble(){
		_inv = new Inventory();
		_board = new Board();
		_players = new ArrayList<Player>();
		_numberOfPlayers = 0;
		_turn = 1;

	}
	/**
	 * Adds a new player to the game.
	 */
	public void addNewPlayer(){
		_players.add(new Player(_inv));
	}
	
	/**
	 * gets currently selected tile
	 */
	public Tile getSelectedTile(){
		return _tileHolder;
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
	 * sets number of players
	 */
	public void addToNumberOfPlayers(){
		_numberOfPlayers++;
	}
	/**
	 * gets number of players
	 */
	public int getNumberOfPlayer(){
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
	 * adds letter to word being played
	 */
	public void addToWordBeingPlayed(char c){
		_wordBeingPlayed = _wordBeingPlayed + c;
	}
	/**
	 * Gets word that was played
	 */
	public String getWordPlayed(){
		return _wordBeingPlayed;
	}
	/**
	 * counts up word score
	 */
	public int countWordScore(String s){
		int score = 0;
		
		for (int i = 'A'; i <= 'Z'; i = i + 1){
			// Create 29 of each vowel with point value 1
			if ((i == 'A')||(i == 'E')||(i == 'I')||(i == 'O')||(i =='U')){
				for (int j = 0; j < 29; j++){
					_tileBag.add(new Tile((char)i,1));
				}
			}
			// Create 15 y's with point value 2
			else if (i == 'Y'){
				for (int j = 0; j < 15; j++){
					_tileBag.add(new Tile((char)i,2));
				}
			}
			// Create 12 of every other letter with point value 5
			else{
				for (int j = 0; j < 12; j++){
					_tileBag.add(new Tile((char)i,5));
				}
			}
		}
	
		return 0;
	}
	/**
	 * gets the current tile bag
	 */
	public Inventory getInventory(){
		return _inv;
	}
	
	
}
