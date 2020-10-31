package labTask1;

public class Star extends Piece{
	private int points;
	
	Star(String shape){
		super(shape);
		points = 0;
	}
	
	public String toString() {
		return shape;
	}
	
	public int getPoints() {
		return points;
	}

}
