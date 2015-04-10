



package code;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/** This class writes a new file with the references to what
 * we want to save in the game as well as reads a file and returns
 * a string
*/


public class SaveRestore {
	
	public String Array2String( ArrayList<Object> input){
		String output = input.toString();
		return output;
	}
  
	
	private String _boardsize;
	private String _dictionaryLoc;
	private String _players;
	private String _inventory;
	private String _board;
	
	public void gameFileWrite(String filename, String boardsize,String dictionaryLoc, String players, String inventory, String board){
		PrintWriter writer = null;
		_boardsize = boardsize;
		_dictionaryLoc = dictionaryLoc;
		_players = players;
		_inventory = inventory;
	     _board = board;
		
		try{
		writer = new PrintWriter(filename, "UTF-8");
		writer.println(_boardsize);
		writer.println(_dictionaryLoc);
		writer.println(_players);
		writer.println(_inventory);
		writer.println(_board);
		
		} catch (FileNotFoundException e) {
			System.err.println("File not found and cannot be created: "+filename);
			
		} catch (UnsupportedEncodingException e) {
			System.err.println("File cannot be created: "+filename);
		}
		finally{
		 writer.close();
		}
		
	}
	
	/*public void gameFileWrite(String filename, String toOutput) {
		PrintStream stream = null;
		try {
			stream = new PrintStream(filename);
			stream.format("The file to be saved is" + filename,toOutput);
		} catch (FileNotFoundException e) {
			System.err.println("File not found and cannot be created: "+filename);
		}
		finally {
			stream.close();
		
		}
		}
	*/
	
	
	
	
	
	
	public static String gameFileRead(String filename) {
	
	Scanner scan = null;
	String gamefile = "";
	try {
		scan = new Scanner(new File(filename));
		while (scan.hasNextLine()) {
			String oneLineFromFile = scan.nextLine();
			gamefile = gamefile + oneLineFromFile + '\n';
		}
	} catch (FileNotFoundException e) {
		System.err.println("File not found: "+filename);
	}
	finally {
		scan.close();
	}
	System.out.println(gamefile);
	return gamefile;
	
}



}



