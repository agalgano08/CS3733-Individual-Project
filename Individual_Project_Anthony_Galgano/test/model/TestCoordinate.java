package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import puzzle.model.Coordinate;

class TestCoordinate {

	@Test
	public void testEquals() {
		Coordinate c1 = new Coordinate(1, 2);
		assertFalse(c1.equals(null));
		assertFalse(c1.equals("something"));

		Coordinate c2 = new Coordinate(1, 2);
		Coordinate c3 = new Coordinate(1, 3);
		Coordinate c4 = new Coordinate(3, 2);

		assertTrue(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertFalse(c1.equals(c4));

		assertEquals("(1,2)", c1.toString());
	}
}
