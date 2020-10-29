package puzzle.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Puzzle puzzle;
	boolean gameOver;
	Tile selectedTile;
	Tile upTile;
	Tile downTile;
	Tile leftTile;
	Tile rightTile;
	int possibleRemainingMoves = 0;

	public Model() {

	}

	public Puzzle getPuzzle() {
		return puzzle;
	}

	public void setSelectedTile(Tile t) {
		selectedTile = t;
	}

	public void clearSelectedTile() {
		selectedTile = null;
	}

	public Tile getSelectedTile() {
		return selectedTile;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean flag) {
		gameOver = flag;
	}

	public int getPossibleRemainingMoves() {
		return possibleRemainingMoves;
	}

	public void setPossibleRemainingMoves(int m) {
		possibleRemainingMoves = m;
	}

	/**
	 * Creates a puzzle.
	 * @param p
	 */
	public void setPuzzle(Puzzle p) {
		puzzle = p;
		gameOver = false;
		selectedTile = null;
	}

	/**
	 * Determines whether the move direction is valid or not.
	 * @param dir
	 * @return Returns true if the move is possible, false otherwise.
	 */
	public boolean tryMove(MoveType dir) {
		if (selectedTile == null) {
			return false;
		}
		Tile newTile;
		for (MoveType move : availableMoves()) {
			if (dir == move) {
				if (dir == MoveType.Up) {
					newTile = new Tile(1, 1, puzzle.multiplyTileValues(upTile, selectedTile), true);
					operateTile(newTile, upTile);
				}

				else if (dir == MoveType.Left) {
					newTile = new Tile(1, 1, puzzle.subTileValues(leftTile, selectedTile), true);
					operateTile(newTile, leftTile);
				}

				else if (dir == MoveType.Right) {
					newTile = new Tile(rightTile.height, rightTile.width, puzzle.addTileValues(rightTile, selectedTile),
							true);
					operateTile(newTile, rightTile);
				}

				else if (dir == MoveType.Down) {
					newTile = new Tile(1, 1, puzzle.divideTileValues(downTile, selectedTile), true);
					operateTile(newTile, downTile);
				}
				return true;
			}
		}
		return true;
	}

	/**
	 * Replaces an old tile with a new tile, and sets old tile to false. 
	 * @param newTile
	 * @param oldTile
	 */
	private void operateTile(Tile newTile, Tile oldTile) {
		puzzle.remove(oldTile);
		puzzle.replace(newTile, oldTile.col, oldTile.row);
		selectedTile.setInPlay(false);
	}

	/**
	 * Determines the available moves for the selectedTile. 
	 * @return Returns a list of the available move directions. 
	 */
	public List<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();
		if (selectedTile == null) {
			return moves;
		}

		return availableMoves(selectedTile);
	}

	/**
	 * Determines the available moves for a Tile.
	 * @param t
	 * @return Returns a list of the available move directions.
	 */
	public List<MoveType> availableMoves(Tile t) {
		ArrayList<MoveType> moves = new ArrayList<>();
		if (selectedTile == null) {
			return moves;
		}

		findSurroundTiles(t);
		Coordinate tileCoord = t.getLocation();

		boolean available = true;

		// Up
		if (tileCoord.row > 0) {
			if (upTile == null) {
				available = false;
			}
			if (available) {
				moves.add(MoveType.Up);
			}
		}

		// Left
		available = true;
		if (tileCoord.col > 0) {
			if (leftTile == null || (leftTile.getValue() - t.getValue()) <= 0) {
				available = false;
			}
			if (available) {
				moves.add(MoveType.Left);
			}
		}

		// Right
		available = true;
		if (tileCoord.col + t.width < puzzle.numColumns) {

			if (rightTile == null || (t.getValue() + rightTile.getValue()) <= 0) {
				available = false;
			}
			if (available) {
				moves.add(MoveType.Right);
			}
		}
		// Down
		available = true;
		if (tileCoord.row + t.height < puzzle.numColumns) {
			if (downTile == null || (downTile.getValue() / t.getValue()) <= 0
					|| (downTile.getValue() % t.getValue()) != 0) {
				available = false;
			}
			if (available) {
				moves.add(MoveType.Down);
			}
		}

		return moves;
	}

	/**
	 * Finds the surrounding Tiles, (Up, Down, Left Right) Tiles 
	 * for a Tile.
	 * @param t
	 */
	public void findSurroundTiles(Tile t) {
		upTile = null;
		downTile = null;
		leftTile = null;
		rightTile = null;

		if (!t.getInPlay()) {
			return;
		}

		for (Tile tile : puzzle) {
			// Up
			if (t.getRow() - 1 >= 0 && tile.getRow() == t.getRow() - 1 && tile.getColumn() == t.getColumn()
					&& tile.getInPlay()) {
				upTile = tile;
			}

			// Down
			if (t.getRow() + 1 < puzzle.numRows && tile.getRow() == t.getRow() + 1 && tile.getColumn() == t.getColumn()
					&& tile.getInPlay()) {
				downTile = tile;
			}

			// Left
			if (t.getColumn() - 1 >= 0 && tile.getRow() == t.getRow() && tile.getColumn() == t.getColumn() - 1
					&& tile.getInPlay()) {
				leftTile = tile;
			}

			// Right
			if (t.getColumn() + 1 < puzzle.numColumns && tile.getRow() == t.getRow()
					&& tile.getColumn() == t.getColumn() + 1 && tile.getInPlay()) {
				rightTile = tile;
			}

		}

	}

	/**
	 * Resets the puzzle to the original state.
	 */
	public void resetPuzzle() {
		puzzle.reset();
		selectedTile = null;
		gameOver = false;
		possibleRemainingMoves = 0;

	}

	/**
	 * Determines if the model is in a winning condition.
	 * @return Returns true if the model is in a winning condition, false otherwise.
	 */
	public boolean isWinCondition() {
		if (selectedTile == null) {
			return false;
		}
		return puzzle.isWinner();
	}

	/**
	 * Determines if the model is in a losing condition.
	 * @return Returns true if the model is in a losing condition, false otherwise.
	 */
	public boolean isLoseCondition() {
		if (selectedTile == null) {
			return false;
		}

		if (calculateMovesAvailable() == 0) {
			return true;
		}

		return false;
	}

	/**
	 * Calculates the total moves available for all the pieces.
	 * @return Returns an integer of available moves.
	 */
	private int calculateMovesAvailable() {
		possibleRemainingMoves = 0;
		for (Tile t : puzzle) {
			if (t.getInPlay()) {
				possibleRemainingMoves = possibleRemainingMoves + availableMoves(t).size();
			}

		}
		return possibleRemainingMoves;
	}

}
