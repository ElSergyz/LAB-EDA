package labTask1;

public class Square extends Piece{

    private String color;
    private int points = 0;
	
	Square(String shape, String color) {
		super(shape);
		this.color=color;
		if (color.equalsIgnoreCase("red"))
			points = 1;
		if (color.equalsIgnoreCase("blue"))
			points = 2;
		if (color.equalsIgnoreCase("green"))
			points = 3;
		if (color.equalsIgnoreCase("yellow"))
			points = 4;
		if (color.equalsIgnoreCase("pink"))
			points = 5;
	}

    public String getColor(){
        return color;
    }
    
    public int getPoints() {
    	return points;
    }
    
    public String toString() {
    	return color + " " + shape;
    }
}