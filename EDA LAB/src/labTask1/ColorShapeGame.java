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

	private static void playGame(Piece[] pieces) {
		Stack<Piece> s = new Stack<Piece>();
	}

	private static Piece [] createArray(String st) throws IOException {
		File f = new File (st);
		Scanner file = new Scanner(f);
		int index = 0;
		String string = "";
		StringTokenizer tokens;
		Piece pieces[] = new Piece [22];
		
		while (file.hasNext()) {
			string = string + file.nextLine();
			tokens = new StringTokenizer(string,";");
			String shape = tokens.nextToken();
			if (shape.equalsIgnoreCase("square")) {
				String color = tokens.nextToken();
				pieces [index] = new Square(shape, color);
			}
			else {
				pieces [index] = new Star(shape);
			}
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

