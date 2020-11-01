package labTask1;

import java.util.*;
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
		int nPieces = countPieces(directory);
		Piece pieces[] = new Piece [nPieces];
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
	
	//This method is to count the number of pieces that are located in the file.
	public static int countPieces(String directory) throws FileNotFoundException{
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
			int counter = 0, totalPoints = 0;
			Stack<Piece> s = new Stack<Piece>();
			
			for(int i=0; i <pieces.length;i++) {
				int points = 0; //we are counting the points individually in each iteration
				if (s.empty() && pieces[i].getShape().equalsIgnoreCase("square")) {
					s.push(pieces[i]);
				}
				
				else if (pieces[i].getShape().equalsIgnoreCase("star")) {
					reverseStack(s);
					points = pieces[i].getPoints();
					counter++; //increase number of moves
				}
				else if (pieces[i].getShape().equalsIgnoreCase("square")){
					/* We create two auxiliary square objects in order to see if
					 * they have the same color
					 */
					Square var1 = (Square) pieces[i];
					Square var2 = (Square) s.peek();
					
					if(var1.getColor().equalsIgnoreCase(var2.getColor())) {
						s.pop();
						points = pieces[i].getPoints() * 2; //double points because they have the same color
						counter++; //increase number of moves
					} else {
						s.push(pieces[i]);
				
					}
				}
				totalPoints += points;
			}
			printStack(s);
			System.out.println();
			System.out.println("Points: " + totalPoints);
			System.out.println("Movements: " + counter);
	}
	
	private static void printStack(Stack<Piece> s) {
		if(s.empty())
			return;
		System.out.println("The final status of the stack is (bottom -> top): \n");
		for (int i=0; i<s.size() ; i++) {
			Piece piece;
			piece = s.get(i);
			System.out.print(piece.toString() + " | ");
		}
		
	}


	public static void reverseStack (Stack<Piece> p){
	    Piece e;
	    if (!p.empty()) {
	      e=p.pop();
	      reverseStack(p);
	      pushBottom (p,e);
	    }
	  }
	
	public static void pushBottom (Stack<Piece> p, Piece e){
	    Piece a;
	    if (!p.empty()){
	      a=p.pop();
	      pushBottom(p,e);
	      p.push(a);
	    }
	    else {
	      p.push(e);
	  }
	}
}