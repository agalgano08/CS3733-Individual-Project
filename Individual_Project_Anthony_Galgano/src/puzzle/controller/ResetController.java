package puzzle.controller;

import puzzle.boundary.PuzzleApp;
import puzzle.boundary.UpdateButtons;
import puzzle.model.Model;

public class ResetController {

	Model model;
	PuzzleApp app;
	
	
	public ResetController (Model model, PuzzleApp app) {
		this.model = model;
		this.app = app;
	}


	public void reset() {
		model.resetPuzzle();
		UpdateButtons.enableButtons(app, model.avaliableMoves());
		app.getWinLoseLabel().setText("");
		app.repaint();
	}
}
