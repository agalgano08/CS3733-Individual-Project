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
	
	@Test
	void testInPlay(){
		Tile tile = new Tile(1,1,5,true);
		assertTrue(tile.getInPlay());
		tile.setInPlay(false);
		assertFalse(tile.getInPlay());
	}
	
	@Test
	void copyPiece() {
		Tile t = new Tile(1,1,5,true);
		Tile t2 = t.copy();
		
		assertEquals(t, t2);
		assertEquals(t.height, t2.height);
		assertEquals(t.width, t2.width);
		assertEquals(t.getValue(), t2.getValue());
		assertEquals(t.getInPlay(), t2.getInPlay());
		assertEquals(t.getRow(), t2.getRow());
		assertEquals(t.getColumn(), t2.getColumn());
		
		t2.setValue(10);
		assertNotEquals(t, t2);
		
		t2.setValue(5);
		t2.setInPlay(false);
		assertNotEquals(t, t2);
	}
	
	@Test
	void testPlacement() {
		Tile t = new Tile(1,1,5,true);
		t.setColumn(2);
		assertEquals (2, t.getColumn());
		t.setRow(0);
		assertEquals (0, t.getRow());
	}

}
