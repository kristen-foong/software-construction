package ca.ubc.cpsc210.spaceinvaders.test;

import ca.ubc.cpsc210.spaceinvaders.model.Missile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Missile class.
 */
public class TestMissile {
	private static final int XLOC = 50;
	private static final int YLOC = 100;
	private Missile m;

	@BeforeEach
	public void runBefore() {
		m = new Missile(XLOC, YLOC);
	}
	
	@Test
	public void testGetX() {
		assertEquals(XLOC, m.getX());
	}
	
	@Test
	public void testGetY() {
		assertEquals(YLOC, m.getY());
	}
	
	@Test
	public void testUpdate() {
		final int NUM_UPDATES = 8;
		
		m.move();
		assertEquals(XLOC, m.getX());
		assertEquals(YLOC + Missile.DY, m.getY());
		
		for(int count = 1; count < NUM_UPDATES; count++) {
			m.move();
		}
		
		assertEquals(XLOC, m.getX());
		assertEquals(YLOC + NUM_UPDATES * Missile.DY, m.getY());
	}
}
