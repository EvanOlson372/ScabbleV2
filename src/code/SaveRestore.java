package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class SaveRestore {
	
	public void gameFileWrite(String filename, String toOutput) {
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
	
	
	
	
	
	
	
	public static String gameFileRead(String filename) {
	
	Scanner scan = null;
	String gamefile = "";
	try {
		scan = new Scanner(new File(filename));
		while (scan.hasNextLine()) {
			String oneLineFromFile = scan.nextLine();
			gamefile = gamefile + oneLineFromFile;
		}
	} catch (FileNotFoundException e) {
		System.err.println("File not found: "+filename);
	}
	finally {
		scan.close();
	}
	return gamefile;
}



}


