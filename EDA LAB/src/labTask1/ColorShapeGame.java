package labTask1;

import java.util.StringTokenizer;
import java.util.Stack;
import java.util.Scanner;
import java.io.*;

public class ColorShapeGame {
	public static Scanner input = new Scanner (System.in);
	
	public static void main (String args[]) {
		Piece pieces [] = new Piece [22];
		boolean exit = false;
		do {
			try {
				String file = filePath();
				input.close();
				pieces = createArray(file);
				playGame(pieces);
				exit = true;
			}catch (IOException e) {
				System.out.println(e.getMessage());
				System.out.println("Introduce again the route: ");
			}
		} while (!exit);
		
	}

	//In this method we start playing the game
	private static void playGame(Piece[] pieces) {
		Stack<Piece> s = new Stack<Piece>();
	}

	//In this method we are reading the file and creating the array of pieces
	private static Piece [] createArray(String st) throws IOException {
		File f = new File (st);
		Scanner file = new Scanner(f);
		int index = 0;
		String string = "";
		StringTokenizer tokens;
		Piece pieces[] = new Piece [22];
		
		while (file.hasNext()) {
			//we read the next line of the file
			//and tokenize the read line individually
			string = string + file.nextLine();
			tokens = new StringTokenizer(string,";");
			
			//the first token is always the shape of the piece
			String shape = tokens.nextToken();
			
			//if the shape is a square, we create a square, being the color the next found token
			if (shape.equalsIgnoreCase("square")) {	
				String color = tokens.nextToken();
				pieces [index] = new Square(shape, color);
			}
			//if it is not a square, we create a star
			else {
				pieces [index] = new Star(shape);
			}
			
			//and we increase the index for the array and reset the string in order to
			//read the next line of the file
			index++;
			string = "";
		}
		file.close();
		return pieces;
	}

	private static String filePath() {
		System.out.println("Where is the file placed?: ");
		String file = input.nextLine();
		return file;
	}
	
}