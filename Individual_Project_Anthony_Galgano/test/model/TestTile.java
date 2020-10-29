package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import puzzle.model.Coordinate;
import puzzle.model.Tile;

class TestTile {

	
	@Test
	void testConstruction() {
		Tile tile = new Tile(1, 2, 10, true);
		assertEquals (1, tile.width);
		assertEquals (2, tile.height);
		assertEquals (10, tile.getValue());
		assertTrue(tile.getInPlay());
	}
	
	@Test
	void testContains() {
		Tile t = new Tile (1,2,5,true);
		t.setRow(0);
		t.setColumn(0);
		
		/**
		 * (0,0)
		 * (0,1)
		 */
		assertTrue(t.contains(new Coordinate(0,0)));
		assertTrue(t.contains(new Coordinate(0,1)));
		
		assertFalse(t.contains(new Coordinate(1,1)));
	}

}
