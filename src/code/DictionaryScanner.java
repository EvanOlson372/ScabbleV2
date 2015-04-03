package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;

public class DictionaryScanner {
	
	public boolean compareWord (String word,String filep){
		ArrayList<String> dictionary  = new ArrayList<String>();
		boolean there = false;
		String wordd ="";
		String file= readMe(filep);
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
        		}
        	else{
        		 there = false;
        	}
        
        }
        
        return there;
	
	
		
}
	
	
	
	public String readMe(String filename) {
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

}
