package model;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import puzzle.model.Puzzle;
import puzzle.model.Coordinate;
import puzzle.model.Model;
import puzzle.model.Tile;

public abstract class ModelTestCase {

	protected Model model;
	
	/** 
	 * Helper test method for location a piece by a coordinate.
	 *  
	 */
	protected Optional<Tile> getPiece(Coordinate c) {
		for (Tile t : model.getPuzzle()) {
			if (t.contains(c)) {
				return Optional.of(t);
			}
		}
		
		return Optional.empty(); 
	}
	
	
	@BeforeEach 
	public void setUp() {
		model  = new Model();
		
		Puzzle puzzle = new Puzzle(4,3,1,1);
		puzzle.setTilesInPlay(9);
		puzzle.add(new Tile(1,1,3,true), 0,0);
		puzzle.add(new Tile(1,1,9,true), 0,1);
		puzzle.add(new Tile(1,1,4,true), 0,2);
		
		puzzle.add(new Tile(1,1,6,true), 1,0);
		puzzle.add(new Tile(1,1,1,true), 1,1);
		puzzle.add(new Tile(1,1,5,true), 1,2);
		
		puzzle.add(new Tile(1,1,8,true), 2,0);
		puzzle.add(new Tile(1,1,2,true), 2,1);
		puzzle.add(new Tile(1,1,7,true), 2,2);
		model.setPuzzle(puzzle);
		
	}
	


}







