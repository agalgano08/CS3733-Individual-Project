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
		Tile t = new Tile (1,1,5,true);
		t.setRow(2);
		t.setColumn(2);
		
		assertTrue(t.contains(new Coordinate(2,2)));
		
		assertFalse(t.contains(new Coordinate(3,3)));
		

	}

}
