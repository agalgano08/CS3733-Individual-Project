package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import puzzle.controller.ResetController;
import puzzle.model.Coordinate;
import puzzle.model.MoveType;
import puzzle.model.Tile;



class TestResetController extends AppTestCase{

	@Test
	public void testReset() {
		Tile t = this.getTile(new Coordinate(1,1)).get(); 
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Left)); 	// Move middle tile left
		assertTrue (getTile(new Coordinate(0,1)).get().getInPlay());
		assertFalse (t.getInPlay());
		ResetController rtc = new ResetController(model, app);
		rtc.reset();
		
		assertTrue(getTile(new Coordinate(1,1)).get().getInPlay());
	}

}
