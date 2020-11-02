package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import puzzle.controller.SelectTileController;
import puzzle.model.Coordinate;
import puzzle.model.Tile;

class TestSelectTileController extends AppTestCase {

	@Test
	public void testSelect() {
		SelectTileController stc = new SelectTileController(model, app);
		Point pt = coordinateToPoint(new Coordinate(1, 1));
		assertEquals(new Coordinate(1, 1), app.getPuzzlePanel().pointsToCoordinate(pt));

		stc.process(pt);

		Tile t = getTile(new Coordinate(1, 1)).get();
		assertEquals(t, model.getSelectedTile());

		// this piece can only move all directions
		assertTrue(app.getLeftButton().isEnabled());
		assertTrue(app.getRightButton().isEnabled());
		assertTrue(app.getUpButton().isEnabled());
		assertTrue(app.getDownButton().isEnabled());
	}

}
