package ca.ubc.cpsc210.paddleball.test;

import ca.ubc.cpsc210.paddleball.model.PBG;
import ca.ubc.cpsc210.paddleball.model.Paddle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Paddle class.
 */
class TestPaddle {
	private static final int XLOC = PBG.DIMENSION1 / 2;
	private Paddle p;
	
	@BeforeEach
	void runBefore() {
		p = new Paddle(XLOC);
	}
	
	@Test
	void testGetX() {
		assertEquals(XLOC, p.getCurrX());
	}
	
	@Test
	void testUpdate() {
		final int NUM_UPDATES = 8;
		
		p.move();
		assertEquals(XLOC + Paddle.DX, p.getCurrX());
		
		for(int count = 1; count < NUM_UPDATES; count++) {
			p.move();
		}
		
		assertEquals(XLOC + NUM_UPDATES * Paddle.DX, p.getCurrX());
	}
	
	@Test
	void testFlipDirection() {
		p.move();
		assertEquals(XLOC + Paddle.DX, p.getCurrX());
		p.moveLeft();
		p.move();
		assertEquals(XLOC, p.getCurrX());
		p.moveRight();
		p.move();
		assertEquals(XLOC + Paddle.DX, p.getCurrX());
	}
	
	@Test 
	void testLeftBoundary() {
		p.moveLeft();
		for(int count = 0; count < (PBG.DIMENSION1 / 2 - Paddle.DIMENSION1 / 2) / Paddle.DX + 1; count++)
			p.move();
		assertEquals(Paddle.DIMENSION1 / 2, p.getCurrX());
		p.move();
		assertEquals(Paddle.DIMENSION1 / 2, p.getCurrX());
	}
	
	@Test
	void testRightBoundary() {
		p.moveRight();
		for(int count = 0; count < (PBG.DIMENSION1 / 2 - Paddle.DIMENSION1 / 2) / Paddle.DX + 1; count++)
			p.move();
		assertEquals(PBG.DIMENSION1 - Paddle.DIMENSION1 / 2, p.getCurrX());
		p.move();
		assertEquals(PBG.DIMENSION1 - Paddle.DIMENSION1 / 2, p.getCurrX());
	}
}
