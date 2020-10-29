package puzzle.controller;

import javax.swing.JOptionPane;

import puzzle.boundary.PuzzleApp;

public class ExitController {

	PuzzleApp app;
	
	
	public ExitController (PuzzleApp app) {
		this.app = app;
	}


	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you want to exit application?");
		if (c== JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
}
