package ca.ubc.cpsc210.alarm.test;

import ca.ubc.cpsc210.alarm.model.AlarmController;
import ca.ubc.cpsc210.alarm.model.Remote;
import ca.ubc.cpsc210.alarm.model.Sensor;
import ca.ubc.cpsc210.alarm.model.exception.DuplicateSensorException;
import ca.ubc.cpsc210.alarm.model.exception.SystemNotReadyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class RemoteTest {
	private Remote r;
	private AlarmController ac;
	private Sensor s;
	
	@BeforeEach
	public void runBefore() {
		ac = new AlarmController();
		r = new Remote(ac);
		try {
			s = new Sensor("Door", ac);
		} catch (DuplicateSensorException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testArm() {
		try {
			assertFalse(ac.isArmed());
			r.activate();
			assertTrue(ac.isArmed());
		} catch (SystemNotReadyException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSNRArm() {
        try {
            assertFalse(ac.isArmed());
            s.open();
            r.activate();
            assertTrue(ac.isArmed());
            fail("SystemNotReadException should have been thrown");
        } catch (SystemNotReadyException e) {
            // expected
        }
    }
}
