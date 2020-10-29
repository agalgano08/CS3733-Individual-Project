package puzzle.boundary;

import java.util.List;

import puzzle.model.MoveType;


public class UpdateButtons {

	
	public static void enableButtons(PuzzleApp app, List<MoveType> moves) {
		app.getUpButton().setEnabled(false);
		app.getDownButton().setEnabled(false);
		app.getLeftButton().setEnabled(false);
		app.getRightButton().setEnabled(false);
		
		for (MoveType mt : moves) {
			if(mt == MoveType.Left) {
				app.getLeftButton().setEnabled(true);
			}
			if(mt == MoveType.Right) {
				app.getRightButton().setEnabled(true);
			}
			if(mt == MoveType.Up) {
				app.getUpButton().setEnabled(true);
			}
			if(mt == MoveType.Down) {
				app.getDownButton().setEnabled(true);
			}
		}
		
	}
}
