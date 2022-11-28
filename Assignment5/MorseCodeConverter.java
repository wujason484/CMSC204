/*
 * Class: CMSC204
 * Intsructor:Dr.Monshi
 * Description: Converts morse code into english
 * Due: 11/30/22
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jason Wu
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseCodeConverter {

	static MorseCodeTree morseCodeTree= new MorseCodeTree();
	
	public MorseCodeConverter() {
		
	}
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree
	 * @return a string with all the data in the tree in LNR order with an space in between them
	 */
	public static String printTree() {
		ArrayList<String> treeArrayList= morseCodeTree.toArrayList();
		String treeString= "";
		for (int count = 0; count<treeArrayList.size(); count++) {
			treeString+= treeArrayList.get(count)+ " ";
		}
		return treeString.trim();
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param code
	 * @return String converted from code
	 */
	public static String convertToEnglish(String code) {
		String[] letters;
		String[] words= code.split(" / ");
		String convertedStr= "";

		for (String word: words) {
			letters= word.split(" ");

			for (String eachLetter: letters)
				convertedStr+= morseCodeTree.fetch(eachLetter);

			convertedStr+= " ";
		}

		return convertedStr.trim();
	}
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param file
	 * @return String converted from code
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File file) throws FileNotFoundException {
		Scanner scanner= new Scanner(file);
		String fileCode= "";
		
		while(scanner.hasNextLine()) 
			fileCode+= scanner.nextLine()+ "\n";
		
		scanner.close();
		
		return convertToEnglish(fileCode.trim());
		}

}
