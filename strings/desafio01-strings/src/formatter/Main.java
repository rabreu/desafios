package formatter;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String unFormatedtext = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n"
				+ "\n"
				+ "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";

		Formatter format = new Formatter(unFormatedtext, 40);

		String formatedText = format.lineLimit();
		System.out.println("================================================");
		System.out.println(formatedText);
		System.out.println("================================================");
		writeToFile(formatedText, "output_parte1.txt");
		System.out.println("\n");

		formatedText = format.lineLimitBlock();
		System.out.println("================================================");
		System.out.println(formatedText);
		System.out.println("================================================");
		writeToFile(formatedText, "output_parte2.txt");
		System.out.println("\n");
	}

	public static void writeToFile(String text, String filename) {
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
