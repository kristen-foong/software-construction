package ca.ubc.cpsc210.alarm.test;

import ca.ubc.cpsc210.alarm.model.Alarm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the Alarm class
 */
public class AlarmTest {
	private Alarm a;
	
	@BeforeEach
	public void runBefore() {
		a = new Alarm();
	}
	
	@Test
	public void testAlarm() {
		assertFalse(a.isSounding());
	}

	@Test
	public void testSound() {
		assertFalse(a.isSounding());
		a.sound();
		assertTrue(a.isSounding());
	}

	@Test
	public void testSilence() {
		a.sound();
		assertTrue(a.isSounding());
		a.silence();
		assertFalse(a.isSounding());
	}

	@Test
	public void testIsSounding() {
		assertFalse(a.isSounding());
		a.sound();
		assertTrue(a.isSounding());
		a.silence();
		assertFalse(a.isSounding());
	}
}
