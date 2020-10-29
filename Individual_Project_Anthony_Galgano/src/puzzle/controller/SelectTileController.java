package puzzle.controller;

import java.awt.Point;
import java.util.List;

import puzzle.boundary.UpdateButtons;
import puzzle.model.MoveType;
import puzzle.boundary.PuzzleApp;
import puzzle.model.Coordinate;
import puzzle.model.Model;
import puzzle.model.Puzzle;
import puzzle.model.Tile;


public class SelectTileController {

	Model model;
	PuzzleApp app;
	
	
	public SelectTileController (Model model, PuzzleApp app) {
		this.model = model;
		this.app = app;
	}


	/**
	 * Used to select a tile.
	 * If the tile contains the point, the buttons will be updated 
	 * with the corresponding available moves and the application refreshed. 
	 * 
	 * Takes in a point.
	 * @param point
	 */
	public void process(Point point) {
		Coordinate c = app.getPuzzlePanel().pointsToCoordinate(point);
		Puzzle puzzle = model.getPuzzle();
		
		for (Tile t : puzzle) {
			if(t.contains(c)) {
				model.clearSelectedTile();
				model.setSelectedTile(t);
				List<MoveType> moves = model.availableMoves(t);
				UpdateButtons.enableButtons(app, moves);
				app.repaint();
			}
		}
	}
}
