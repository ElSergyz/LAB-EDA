package labTask1;

import java.util.StringTokenizer;
import java.util.Stack;
import java.util.Scanner;
import java.io.*;

public class ColorShapeGame {
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean stop= false;
		//We decide to put the printLine here so as to not repeat this sentence over and over again.
		System.out.println("Introduce the directory of the file");
		do {
			try {
				String directory = introduceDirectory();
				Piece [] pieces = readFile(directory);
				playGame(pieces);
				stop = true;
			}catch(FileNotFoundException e) {
				System.out.println("An error has occurred: the file was not located. Introduce the directory again: ");
			}
		}while(!stop);
	}

	
	public static String introduceDirectory() {
		String result= sc.nextLine();
		return result;
	}
	
	public static Piece[] readFile(String directory) throws FileNotFoundException{
		int index = 0;
		String string = "";
		StringTokenizer tokens;
		int count = countFile(directory);
		Piece pieces[] = new Piece [count];
		Scanner in = new Scanner(new FileReader(directory));
		
		while (in.hasNext()) {
			//we read the next line of the file
			//and tokenize the each line individually
			string = string + in.nextLine();
			tokens = new StringTokenizer(string,";");
			
			//the first token is always the shape of the piece
			String shape = tokens.nextToken();
			
			//if the shape is a square, we create a square, being the color the next found token
			if (shape.equalsIgnoreCase("square")) {	
				String color = tokens.nextToken();
				pieces [index] = new Square(shape, color);
			}
			//if it is not a square, then we create a star
			else {
				pieces [index] = new Star(shape);
			}
			
			//we increase the index for the array and reset the string 
			//in order to read the next line of the file
			index++;
			string = "";
		}
		in.close(); //we close the scanner
		return pieces;
	}
	
	
	public static int countFile(String directory) throws FileNotFoundException{
		
		//This method is to count the number of pieces that are located in the file.
		int count = 0;
		Scanner in = new Scanner(new FileReader(directory));
		
		while(in.hasNext()) {
			count++;
			in.nextLine();
		}
		
		in.close();
		return count;
	}
	
	private static void playGame(Piece[] pieces) {
	//In this method we start playing the game
		Stack<Piece> s = new Stack<Piece>();
	}
}