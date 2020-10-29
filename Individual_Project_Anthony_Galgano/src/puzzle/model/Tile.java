package puzzle.model;


public class Tile {
	public final int height;
	public final int width;
	private int value;
	int row;
	int col;
	private boolean getInPlay;
	
	public Tile(int width, int height, int value, boolean inPlay) {
		this.width = width;
		this.height = height;
		this.value = value;
		this.getInPlay = inPlay;
	}
	
	public void setRow(int r) {this.row = r;}
	public void setColumn(int c) {this.col = c;}
	public void setValue(int value ){this.value = value;}
	public void setInPlay(boolean flag ){this.getInPlay = flag;}
	
	public int getColumn() { return col; }
	public int getRow() { return row; }
	public int getValue() { return value; }
	public boolean getInPlay(){return getInPlay;}
	public Coordinate getLocation() {return new Coordinate(col,row);}
	
	
	public boolean contains(Coordinate c) {
		if(c.col >= col && c.col < col+width && c.row>=row && c.row < row+height) {
			return true;
		}
		return false;
	}
	
	@Override 
	public boolean equals(Object o) {
		if( o == null) {return false; }
		if (o instanceof Tile) {
			Tile other = (Tile) o;
			return col == other.col && row == other.row && value == other.value && height == other.height && width == other.width;
		}
		return false;
	}
	
	
	public Tile copy() {
		Tile t = new Tile(width, height, value, getInPlay);
		t.setRow(row);
		t.setColumn(col);
		return t;
	}


}
