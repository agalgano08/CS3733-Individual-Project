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

	public void add(Tile t, int col, int row) {
		t.setColumn(col);
		t.setRow(row);
		tilesInPlay++;
		tiles.add(t);
		originals.add(t);
	}

	public void remove(Tile t) {
		tilesInPlay--;
		tiles.remove(t);
	}

	public void replace(Tile t, int col, int row) {
		t.setColumn(col);
		t.setRow(row);

		tiles.add(t);
	}

	public ArrayList<Tile> getTiles() {
		return tiles;
	}

	public int addTileValues(Tile t1, Tile t2) {
		return t1.getValue() + t2.getValue();
	}

	public int subTileValues(Tile t1, Tile t2) {
		return (int) t1.getValue() - t2.getValue();
	}

	public int multiplyTileValues(Tile t1, Tile t2) {
		return (int) t1.getValue() * t2.getValue();
	}

	public int divideTileValues(Tile t1, Tile t2) {
		return (int) t1.getValue() / t2.getValue();
	}

	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}

	public void reset() {
		tiles.clear();
		for (Tile t : originals) {
			t.setInPlay(true);
			tiles.add(t.copy());
		}
		tilesInPlay = tiles.size();
	}

	public boolean isWinner() {
		Coordinate winningCoordinate = new Coordinate(winningColumn, winningRow);
		if (tilesInPlay == 1 && findWinningTile().getLocation().equals(winningCoordinate)) {
			return true;
		}
		return false;
	}

	public Tile findWinningTile() {
		for (Tile t : this) {
			if (t.getInPlay()) {
				return t;
			}
		}
		return null;
	}

}
