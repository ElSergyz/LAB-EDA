package labTask1;

public abstract class Piece {

    public String shape;
	
	Piece(String shape) {
		this.shape=shape;
	}

    public String getShape(){
        return shape;
    }
    
    public abstract String toString();
    public abstract int getPoints();
}
