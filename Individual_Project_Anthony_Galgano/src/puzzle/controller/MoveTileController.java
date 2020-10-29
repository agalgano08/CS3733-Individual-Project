package puzzle.controller;


import java.awt.List;
import java.util.ArrayList;

import puzzle.boundary.PuzzleApp;
import puzzle.boundary.UpdateButtons;
import puzzle.model.Model;
import puzzle.model.MoveType;

public class MoveTileController {

	Model model;
	PuzzleApp app;
	
	
	public MoveTileController (Model model, PuzzleApp app) {
		this.model = model;
		this.app = app;
	}


	/**
	 * Merges two tiles based on the input direction.
	 * Checks if game is over or if puzzle is in win condition or lose condition.
	 * @param dir Direction of merge.
	 * @return Returns true if the game is not over and the move is possible. 
	 */
	public boolean merge(MoveType dir) {
		if(model.getSelectedTile() == null) {return false;}
		
		
		if(model.isGameOver()) {return false;}
		
		if(model.tryMove(dir)) {
			UpdateButtons.enableButtons(app,model.availableMoves());
			app.repaint();
		}
		
		if(model.isLoseCondition()) {
			model.setGameOver(true);
			app.getWinLoseLabel().setText("Sorry you did not complete the Puzzle :(");
			app.repaint();
		}
		
		if(model.isWinCondition()) {
			model.setGameOver(true);
			app.getWinLoseLabel().setText("Congradulations on completeting the Puzzle!");
			app.repaint();
		}


		
		
		return true;
	}

}
