package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ModelTestCase;
import puzzle.boundary.PuzzleApp;
import puzzle.boundary.PuzzlePanel;
import puzzle.model.Coordinate;


public abstract class AppTestCase extends ModelTestCase{

	protected PuzzleApp app;
	
	@BeforeEach 
	public void createApp() {
		app = new PuzzleApp(model);
		app.setVisible(true);
	}
	
	@After
	public void tearDown() throws Exception {
		app.setVisible(false);
	}
	
	/** 
	 * Map a Coordinate in puzzle to mouse point at center of square.
	 * 
	 * @param  c       Desired Coordinate.
	 * @return Point   Associated with the center of a square with given coordinate. 
	 */
	public static Point coordinateToPoint(Coordinate c) {
		return new Point(c.col * PuzzlePanel.tileSize + PuzzlePanel.tileSize/2, c.row * PuzzlePanel.tileSize + PuzzlePanel.tileSize/2);
	}
}
