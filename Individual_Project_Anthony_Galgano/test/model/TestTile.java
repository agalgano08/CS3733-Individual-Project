package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

}
