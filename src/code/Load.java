package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Load {
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
