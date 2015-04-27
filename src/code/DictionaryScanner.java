package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryScanner {
	/** The DictionaryScanner is implemented after each turn is completed
	* and validates the word played. The compareWord method takes in the word
	* played as well as the filepath to our Dictionary Document. It scans the file
	* and adds to to an array list which is used for comparison.
	* 
	* Kelly Plevniak 
	* 
	*/
	public static boolean compareWord (String word,String filep){
		
		//array list where the words in the file will be added
		
		ArrayList<String> dictionary  = new ArrayList<String>(); 
		boolean there = false;
		String dWord ="";
		
		//static method which returns a string from a scanned file
		String file= readMe(filep); 
		//System.out.println("read me creates: "+ '\n'+ file);
		
		// iterates through the file and adds words to the array list
		for (int i= 0; i<file.length();i++){ 
			char ch = file.charAt(i);
			ch = Character.toUpperCase(ch);
        	if(ch >='A'&& ch<='Z'){
        		dWord= dWord+ch;
        	}
        	else if(ch == '\n'){
        		dictionary.add(dWord);
        		dWord = "";
        	}
		}
        	
          	if( dictionary.contains(word)){
        		  there = true;
        		
        		}
        	else{
        		 there = false;
        	
        	}
        	
        

		
        //returns a boolean value, and prints for testing purposes
        System.out.println(there);
        return there;
	
	
		
}
	
	/** Private static method which scans the input filepath
	 * and returns a string which can be added to the Array list above.
	*/
	
	private static String readMe(String filename) {
		Scanner scan = null;
		String readfile = "";
		try {
			scan = new Scanner(new File(filename));			
			while (scan.hasNextLine()) {
				String oneLine = scan.nextLine();
				readfile = readfile+ oneLine + '\n';
			}
 		} catch (FileNotFoundException e) {
			System.err.println("File not found: "+filename);
		}
		finally {
			scan.close();
		}
		return readfile;
	}


public static void main (String []args){
DictionaryScanner.compareWord( "MARKET","src/code/Dictionary");

	
}
}