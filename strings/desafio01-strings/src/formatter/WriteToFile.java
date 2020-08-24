package formatter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public WriteToFile() {
		
	}
	
	public void write(String text, String filename) {
		try {
			FileWriter file = new FileWriter(filename);
			file.write(text);
			file.close();
			System.out.println("Arquivo " + filename + " salvo.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
