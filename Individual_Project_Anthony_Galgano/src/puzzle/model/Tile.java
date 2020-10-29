package puzzle.model;


public class Tile {
	public final int height;
	public final int width;
	private int value;
	int row;
	int col;
	private boolean inPlay;
	
	public Tile(int width, int height, int value, boolean inPlay) {
		this.width = width;
		this.height = height;
		this.value = value;
		this.inPlay = inPlay;
	}
	
	public void setRow(int r) {this.row = r;}
	public void setColumn(int c) {this.col = c;}
	public void setValue(int value ){this.value = value;}
	public void setInPlay(boolean flag ){this.inPlay = flag;}
	
	public int getColumn() { return col; }
	public int getRow() { return row; }
	public int getValue() { return value; }
	public boolean getInPlay(){return inPlay;}
	public Coordinate getLocation() {return new Coordinate(col,row);}
	
	
	/**
	 * Determines if a coordinate c is inside of the tile.
	 * @param c
	 * @return Returns true if the coordinate is inside of the tile, false otherwise.
	 */
	public boolean contains(Coordinate c) {
		if(c.col >= col && c.col < col+width && c.row>=row && c.row < row+height) {
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if two tiles are equal.
	 */
	@Override 
	public boolean equals(Object o) {
		if( o == null) {return false; }
		if (o instanceof Tile) {
			Tile other = (Tile) o;
			return col == other.col && row == other.row && value == other.value 
					&& height == other.height && width == other.width && inPlay == other.inPlay;
		}
		return false;
	}
	
	/** 
	 * Creates a copy of a tile used for the reseting of a puzzle.
	 * @return A copy of the tile.
	 */
	public Tile copy() {
		Tile t = new Tile(width, height, value, inPlay);
		t.setRow(row);
		t.setColumn(col);
		return t;
	}


}
