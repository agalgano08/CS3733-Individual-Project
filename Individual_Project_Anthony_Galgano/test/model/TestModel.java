package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import puzzle.model.Model;
import puzzle.model.Puzzle;
import puzzle.model.Tile;


class TestModel extends ModelTestCase {
	

	
	@Test
	public void testInitialState( ) {
		assertTrue(model.getPossibleRemainingMoves() == 0);
		
		assertTrue (model.getSelectedTile() == null);
	}

	/*
	@Test
	public void testPossibleMove() {
		
	}
	
	
	@Test
	public void testMove() {
		
	}
	
	@Test
	public void testBadMoves() {
		
	}
	
	
	@Test
	public void testReset() {
		
	}
	
	
	@Test
	public void testWin() {
		
	}
	*/
}
