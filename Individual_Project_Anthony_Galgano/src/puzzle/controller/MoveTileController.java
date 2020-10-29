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


	public boolean merge(MoveType dir) {
		if(model.getSelectedTile() == null) {return false;}
		
		
		if(model.isGameOver()) {return false;}
		
		if(model.tryMove(dir)) {
			UpdateButtons.enableButtons(app,model.avaliableMoves());
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
