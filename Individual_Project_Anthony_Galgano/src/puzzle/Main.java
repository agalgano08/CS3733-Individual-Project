package puzzle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import puzzle.boundary.PuzzleApp;
import puzzle.controller.ExitController;
import puzzle.model.Model;
import puzzle.model.Puzzle;
import puzzle.model.Tile;

public class Main {

	public static void main(String[] args) {
		Model m = new Model();
		
		Puzzle puzzle = new Puzzle(4,3,1,1);
		Tile t = new Tile(1,1,5,true);
		m.setPuzzle(puzzle);
		puzzle.add(new Tile(1,1,3,true), 0,0);
		puzzle.add(new Tile(1,1,9,true), 0,1);
		puzzle.add(new Tile(1,1,4,true), 0,2);
		
		puzzle.add(new Tile(1,1,6,true), 1,0);
		puzzle.add(new Tile(1,1,1,true), 1,1);
		puzzle.add(new Tile(1,1,5,true), 1,2);
		
		puzzle.add(new Tile(1,1,8,true), 2,0);
		puzzle.add(new Tile(1,1,2,true), 2,1);
		puzzle.add(new Tile(1,1,7,true), 2,2);

		PuzzleApp app = new PuzzleApp(m);
		
		app.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
			
		});
		
		app.setVisible(true);
	}

}
