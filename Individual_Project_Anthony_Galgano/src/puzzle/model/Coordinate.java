package puzzle.model;
/**
 * 
 * @author Professor George Heineman 
 * Class used from the SlidingPuzzleApplication example.
 * 
 * @author Anthony Galgano
 * Comments written by student Anthony Galgano
 *
 */


public class Coordinate {
	public final int col;
	public final int row;
	
	public Coordinate(int col, int row) {
		this.col = col;
		this.row = row;
		
	}
	
	/**
	 * Converts Coordinate to type String.
	 */
	public String toString() {
		return "(" + col + "," + row+ ")";
	}
	
	/**
	 * Overrides equal method. 
	 * Determines if two coordinates are equal.
	 */
	@Override public boolean equals(Object o) {
		if( o == null) {return false; }
		if (o instanceof Coordinate) {
			Coordinate other = (Coordinate) o;
			return col == other.col && row == other.row;
		}
		return false;
	}

}
