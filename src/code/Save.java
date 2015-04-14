package code;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Save {
	
	/**
	 * This takes the data from the game and writes it to a file which can later be retrieved
	 * with the Load class, it allows the player to save game progress and name a file
	 * 
	 * @@Kelly Plevniak
	 */
	private static code.Scrabble _dataStruct;
	private static code.Player _player;
	
	public void gameFileWrite(String filename){
		PrintWriter writer = null;
		int i=0;
	    try{
		writer = new PrintWriter(filename, "UTF-8");
		writer.println("20 20");
		writer.println("src/code/Dictionary");
		writer.println("["+_dataStruct.getPlayerName(i) + _dataStruct.getColor() + _player.getScore() + _player.getRack()+"]");
		writer.println(_dataStruct.getInventory());
		writer.println(_dataStruct.getBoard());
		
		} catch (FileNotFoundException e) {
			System.err.println("File not found and cannot be created: "+filename);
			
		} catch (UnsupportedEncodingException e) {
			System.err.println("File cannot be created: "+filename);
		}
		finally{
		 writer.close();
		}
		
	}

}
