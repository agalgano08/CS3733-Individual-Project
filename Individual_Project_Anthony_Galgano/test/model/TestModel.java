package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import puzzle.model.Coordinate;
import puzzle.model.Model;
import puzzle.model.MoveType;
import puzzle.model.Puzzle;
import puzzle.model.Tile;


class TestModel extends ModelTestCase {
	

	
	@Test
	public void testInitialState( ) {
		assertTrue(model.getPossibleRemainingMoves() == 0);
		assertFalse(model.isGameOver());
		assertTrue (model.getSelectedTile() == null); 
	}

	
	@Test
	public void testPossibleMove() {
	
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		assertEquals (1, t.width);
		assertEquals (1, t.height);
		model.setSelectedTile(t);
		
		List<MoveType> available = model.availableMoves();
		assertEquals (4, available.size());
		assertTrue (available.contains(MoveType.Left));
		assertTrue (available.contains(MoveType.Right));
		assertTrue (available.contains(MoveType.Up));
		assertTrue (available.contains(MoveType.Down));
	}
	
	
	@Test
	public void testMoveRight() {
		assertFalse (model.tryMove(MoveType.Right));  
		Tile t = this.getTile(new Coordinate(1, 2)).get(); 
		Tile t2 = this.getTile(new Coordinate(2, 2)).get();
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Right));
		assertFalse(t.getInPlay());
		assertEquals(this.getTile(new Coordinate(2, 2)).get().getValue(), t.getValue()+t2.getValue());
	}
	
	@Test
	public void testMoveDown() {
		assertFalse (model.tryMove(MoveType.Down));  
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		Tile t2 = this.getTile(new Coordinate(1, 2)).get();
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Down));
		assertFalse(t.getInPlay());
		assertEquals(this.getTile(new Coordinate(1, 2)).get().getValue(), t2.getValue()/t.getValue());
	}
	
	@Test
	public void testMoveLeft() {
		assertFalse (model.tryMove(MoveType.Left));  
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		Tile t2 = this.getTile(new Coordinate(0, 1)).get();
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Left));
		assertFalse(t.getInPlay());
		assertEquals(this.getTile(new Coordinate(0, 1)).get().getValue(), t2.getValue()-t.getValue());
	}
	
	@Test
	public void testMoveUp() {
		assertFalse (model.tryMove(MoveType.Up));  
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		Tile t2 = this.getTile(new Coordinate(1, 0)).get();
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Up));
		assertFalse(t.getInPlay());
		assertEquals(this.getTile(new Coordinate(1, 0)).get().getValue(), t2.getValue()*t.getValue());
	}
	
	@Test
	public void testBadMoves() {
		
		Tile t = this.getTile(new Coordinate(2,0)).get(); 
		model.setSelectedTile(t);
		assertEquals (0, model.availableMoves().size());
		
	}
	
	
	@Test
	public void testReset() {
		assertFalse (model.tryMove(MoveType.Right));  
		Tile t = this.getTile(new Coordinate(1, 2)).get(); 
		Tile t2 = this.getTile(new Coordinate(2,2)).get();
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Right));
		assertFalse(t.getInPlay());
		assertEquals(this.getTile(new Coordinate(2, 2)).get().getValue(), t2.getValue()+t.getValue());
		assertEquals(model.getPuzzle().getTilesInPlay(), 8);
		
		model.resetPuzzle();
		assertEquals (9, model.getPuzzle().getTilesInPlay());
		t = this.getTile(new Coordinate(1, 1)).get(); 
		assertTrue(t != null);
		assertTrue(t.getInPlay());
		
	}
	
	
	@Test
	public void testWin() {
		assertFalse (model.isGameOver());
		model.setGameOver(true);
		assertTrue (model.isGameOver());
		model.setGameOver(false);
		
		assertFalse (model.isWinCondition());
		Tile t = this.getTile(new Coordinate(1, 1)).get();
		model.setSelectedTile(t);		
		assertFalse (model.isWinCondition());
		
		Model win = new Model();
		Puzzle winP = new Puzzle(3,3,1,1);
		winP.add(t, 1, 1);
		win.setPuzzle(winP);
		win.setSelectedTile(t);
	
		assertTrue (win.isWinCondition());
		
	}
	
	@Test
	public void testLose() {
		Model lose = new Model();
		Puzzle winP = new Puzzle(3,3,1,1);
		Tile t = this.getTile(new Coordinate(1, 2)).get();
		Tile t2 = this.getTile(new Coordinate(0, 1)).get();
		winP.add(t, 1, 2);
		winP.add(t2, 0, 1);
		lose.setPuzzle(winP);
		lose.setSelectedTile(t);
	
		assertTrue (lose.isLoseCondition());
	}
	
	
}
