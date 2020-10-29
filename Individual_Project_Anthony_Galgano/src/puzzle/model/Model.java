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

	public void setPuzzle(Puzzle p) {
		puzzle = p;
		gameOver = false;
		selectedTile = null;
	}

	public boolean tryMove(MoveType dir) {
		if (selectedTile == null) {
			return false;
		}
		Tile newTile;
		for (MoveType move : avaliableMoves()) {
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

	private void operateTile(Tile newTile, Tile moveTile) {
		puzzle.remove(moveTile);
		puzzle.replace(newTile, moveTile.col, moveTile.row);
		selectedTile.setInPlay(false);
	}

	public List<MoveType> avaliableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();
		if (selectedTile == null) {
			return moves;
		}

		return avaliableMoves(selectedTile);
	}

	public List<MoveType> avaliableMoves(Tile t) {
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

	public void resetPuzzle() {
		puzzle.reset();
		selectedTile = null;
		gameOver = false;
		possibleRemainingMoves = 0;

	}

	public boolean isWinCondition() {
		if (selectedTile == null) {
			return false;
		}
		return puzzle.isWinner();
	}

	public boolean isLoseCondition() {
		if (selectedTile == null) {
			return false;
		}

		if (calculateMovesAvaliable() == 0) {
			return true;
		}

		return false;
	}

	private int calculateMovesAvaliable() {
		possibleRemainingMoves = 0;
		for (Tile t : puzzle) {
			if (t.getInPlay()) {
				possibleRemainingMoves = possibleRemainingMoves + avaliableMoves(t).size();
			}

		}
		return possibleRemainingMoves;
	}

}
