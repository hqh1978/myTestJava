package hqh.swing;

public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public Coordinate difference(Coordinate currentMousePosition) {
		int newXValue, newYValue;
		newXValue = this.x - currentMousePosition.x;
		newYValue = this.y - currentMousePosition.y;
		return new Coordinate(newXValue, newYValue);
	}

	public Coordinate add(Coordinate anotherPosition) {
		int newXValue, newYValue;
		newXValue = this.x + anotherPosition.x;
		newYValue = this.y + anotherPosition.y;
		return new Coordinate(newXValue, newYValue);
	}

	public double distance(Coordinate point) {
		 double dist;
	     dist = Math.sqrt((double) ((point.getX() - x)*(point.getX() - x) +
	                      (point.getY() - y)*(point.getY() - y)));
	     return dist;  
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	

}
