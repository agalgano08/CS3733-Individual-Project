package puzzle.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Tile> {
	public final int numRows;
	public final int numColumns;
	public final int winningRow;
	public final int winningColumn;
	int tilesInPlay = 0;

	ArrayList<Tile> tiles = new ArrayList<>();
	ArrayList<Tile> originals = new ArrayList<>();

	public Puzzle(int numColumns, int numRows, int winningColumn, int winningRow) {
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.winningRow = winningRow;
		this.winningColumn = winningColumn;
	}

	public int getTilesInPlay() {
		return tilesInPlay;
	}

	public void setTilesInPlay(int t) {
		tilesInPlay = t;
	}

	/**
	 * Adds a Tile to the puzzle and the original tile list.
	 * Takes in a tile, , column and row for the tile to be placed.
	 * @param t
	 * @param col
	 * @param row
	 */
	public void add(Tile t, int col, int row) {
		t.setColumn(col);
		t.setRow(row);
		tilesInPlay++;
		tiles.add(t);
		originals.add(t);
	}

	/**
	 * Removes a tile from the puzzle. 
	 * Takes in a Tile.
	 * @param t
	 */
	public void remove(Tile t) {
		tilesInPlay--;
		tiles.remove(t);
	}

	/**
	 * Takes in a new tile and an old tile and replaces the old tile position with the new one. 
	 * @param newTile
	 * @param oldTile
	 */
	public void replace(Tile newTile, Tile oldTile) {
		tiles.remove(oldTile);
		
		newTile.setColumn(oldTile.getColumn());
		newTile.setRow(oldTile.getRow());
		tiles.add(newTile);
	}

	/**
	 * @return Returns the list of tiles in the puzzle.
	 */
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	/**
	 * @return Returns the original list of tiles in the puzzle.
	 */
	public ArrayList<Tile> getOriginalTiles() {
		return tiles;
	}

	/**
	 * Returns the value of two tile values added together.
	 * @param t1
	 * @param t2
	 * @return
	 */
	public int addTileValues(Tile t1, Tile t2) {
		return t1.getValue() + t2.getValue();
	}

	/**
	 * Subtracts two tile values. 
	 * Tile t1 - Tile t2
	 * @param t1
	 * @param t2
	 * @return
	 */
	public int subTileValues(Tile t1, Tile t2) {
		return (int) t1.getValue() - t2.getValue();
	}

	/**
	 * Returns the product of two tile values. 
	 * @param t1
	 * @param t2
	 * @return
	 */
	public int multiplyTileValues(Tile t1, Tile t2) {
		return (int) t1.getValue() * t2.getValue();
	}

	/**
	 * Returns the quotient of dividing Tile t1 by Tile t2.
	 * @param t1
	 * @param t2
	 * @return
	 */
	public int divideTileValues(Tile t1, Tile t2) {
		return (int) t1.getValue() / t2.getValue();
	}

	/**
	 * Override the iterator.
	 */
	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}

	/**
	 * Resets the puzzle to the original state.
	 */
	public void reset() {
		tiles.clear();
		for (Tile t : originals) {
			t.setInPlay(true);
			tiles.add(t.copy());
		}
		tilesInPlay = tiles.size();
	}

	/**
	 * Determines if the Puzzle is in a winning configuration. 
	 * @return
	 */
	public boolean isWinner() {
		Coordinate winningCoordinate = new Coordinate(winningColumn, winningRow);
		if (tilesInPlay == 1 && findFirstTileInPlay().getLocation().equals(winningCoordinate)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the first tile found in play. 
	 */
	public Tile findFirstTileInPlay() {
		for (Tile t : this) {
			if (t.getInPlay()) {
				return t;
			}
		}
		return null;
	}

}
