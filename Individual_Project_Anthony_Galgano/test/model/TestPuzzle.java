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

}
