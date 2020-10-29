package model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import puzzle.model.Puzzle;
import puzzle.model.Tile;



class TestPuzzle {

	@Test
	public void testConst() {
		Puzzle p = new Puzzle(3, 3, 1, 1);
		assertEquals (1, p.winningRow);
		assertEquals (1, p.winningColumn);
		assertEquals (3, p.numColumns);
		assertEquals (3, p.numRows);
	}
	
	@Test
	public void testAddReplaceRemove() {
		Puzzle p = new Puzzle(3, 3, 1, 1);
		Tile t = new Tile(1,1,5,true);
		Tile t2 = new Tile(1,1,5,true);
		p.add(t, 1, 1);
		assertEquals(p.getTilesInPlay(), 1);
		p.remove(t);
		assertEquals(p.getTilesInPlay(), 0);
		p.add(t, 1, 1);
		p.replace(t,t2);
		assertEquals(p.getTilesInPlay(), 1);
		
	}
	
	@Test 
	public void testOperations() {
		Puzzle p = new Puzzle(3, 3, 1, 1);
		Tile t = new Tile(1,1,8,true);
		Tile t2 = new Tile(1,1,2,true);
		assertEquals(p.addTileValues(t,t2), 10);
		assertEquals(p.subTileValues(t,t2), 6);
		assertEquals(p.multiplyTileValues(t,t2), 16);
		assertEquals(p.divideTileValues(t,t2), 4);
		
	}
	
	@Test 
	public void testIsWinner() {
		Puzzle p = new Puzzle(3, 3, 1, 1);
		Tile t = new Tile(1,1,8,true);
		p.add(t, 1, 1);
		assertTrue(p.isWinner());
		p.remove(t);
		
		Tile t2 = new Tile(1,1,2,true);
		p.add(t2,2, 1);
		assertFalse(p.isWinner());
	}
	
	@Test
	public void testFindFirstTileInPlay() {
		Puzzle p = new Puzzle(3, 3, 1, 1);
		Tile t = new Tile(1,1,8,true);
		p.add(t, 1, 1);
		
		Tile t1 = p.findFirstTileInPlay();
		assertEquals(t1,t);
	}
	

}













