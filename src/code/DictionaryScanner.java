package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;

public class DictionaryScanner {
	
	public static boolean compareWord (String word,String filep){
		ArrayList<String> dictionary  = new ArrayList<String>();
		boolean there = false;
		String wordd ="";
		String file= readMe(filep);
		System.out.println("read me creates "+ file);
        for (int i= 0; i<file.length();i++){
        	char ch = file.charAt(i);
        	if(ch >='A'&& ch<='Z'){
        		wordd = wordd+ch;
        	}
        	else if(ch == '\n'){
        		dictionary.add(word);
        	}
  
        
        	if( dictionary.contains(word)){
        		  there = true;
        		  System.out.println("true");
        		}
        	else{
        		 there = false;
        		 System.out.println("false");
        	}
        	
        	
        
        }
        
        return there;
	
	
		
}
	
	
	
	public static String readMe(String filename) {
		Scanner scan = null;
		String readfile = "";
		try {
			scan = new Scanner(new File(filename));			
			while (scan.hasNextLine()) {
				String oneLine = scan.nextLine();
				readfile = readfile+ oneLine;
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
	new code.DictionaryScanner().compareWord("", );
//DictionaryScanner.compareWord( "CAT","/Dictionary.txt");

	
}
}
