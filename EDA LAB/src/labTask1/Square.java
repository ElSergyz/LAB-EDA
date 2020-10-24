package labTask1;

public class Square extends Piece{

    private String color;
	
	Square(String shape, String color) {
		super(shape);
		this.color=color;
	}

    public String getColor(){
        return color;
    }
}