package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import puzzle.controller.MoveTileController;
import puzzle.controller.SelectTileController;
import puzzle.model.Coordinate;
import puzzle.model.MoveType;



public class TestMoveTileController extends AppTestCase{

	@Test
	public void testMove() {
		SelectTileController stc = new SelectTileController (model, app);
		Point pt = coordinateToPoint(new Coordinate(1,1));
		assertEquals (new Coordinate(1,1), app.getPuzzlePanel().pointsToCoordinate(pt));
		
		stc.process(pt);
		
		MoveTileController mtc = new MoveTileController(model, app);
		int expectedValue = this.getTile(new Coordinate(1,0)).get().getValue()*model.getSelectedTile().getValue();
		assertTrue (mtc.merge(MoveType.Up));

		assertEquals (expectedValue , this.getTile(new Coordinate(1,0)).get().getValue());
		assertTrue (this.getTile(new Coordinate(1,0)).get().getInPlay());
		assertFalse(model.getSelectedTile().getInPlay());
	}

}
