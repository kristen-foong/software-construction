package ca.ubc.cpsc210.alarm.test;

import ca.ubc.cpsc210.alarm.model.AlarmCode;
import ca.ubc.cpsc210.alarm.model.AlarmController;
import ca.ubc.cpsc210.alarm.model.Sensor;
import ca.ubc.cpsc210.alarm.model.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the AlarmSystem class
 */
public class AlarmSystemTest {
	private AlarmController ac;
	private AlarmCode dc;
	private AlarmCode c;
	private AlarmCode nvc;
	private Sensor s1;
	private Sensor s2;
	
	@BeforeEach
	public void runBeforeAllTests() {
		ac = new AlarmController();
		dc = new AlarmCode("1111");
		c = new AlarmCode("1234");
		nvc = new AlarmCode("twelve");
		try {
			s1 = new Sensor("front door", ac);
			s2 = new Sensor("patio door", ac);
		} catch (DuplicateSensorException e) {
		    e.printStackTrace();
			fail("DuplicateSensorException should not have been thrown");
		}
	}
	
	@Test
	public void testAlarmController() {
		assertFalse(ac.isArmed());
	}

	@Test
	public void testAddCode() {
		try {
			// add default code into system again to make sure
			// there are no problems with multiple additions
			ac.addCode(dc);
			ac.arm(dc);
			assertTrue(ac.isArmed());
			ac.disarm(dc);
			assertFalse(ac.isArmed());
			
			// add new code into system
			ac.addCode(c);
			ac.arm(c);
			assertTrue(ac.isArmed());
			ac.disarm(c);
			assertFalse(ac.isArmed());
		} catch (NotValidCodeException | SystemNotReadyException | CodeException e) {
		    e.printStackTrace();
			fail("Exception should not have been thrown");
		}
	}

	@Test
	public void testAddCodeNVCException() {
        try {
            ac.addCode(nvc);
            fail("NotValidCodeException should have been thrown");
        } catch (NotValidCodeException e) {
            // expected
        }
    }
	
	@Test
	public void testRemoveCode()  {
		try {
			ac.addCode(c);
			ac.arm(c);
			assertTrue(ac.isArmed());
			ac.removeCode(c);
			ac.disarm(c);
			fail("CodeException should have been thrown");
		} catch (NotValidCodeException | SystemNotReadyException | LastCodeException e) {
		    e.printStackTrace();
			fail("Wrong type of exception thrown");
		} catch (CodeException e) {
		    // expected
        }
	}
	
	@Test
	public void testRemoveLastCode() {
		try {
			ac.addCode(c);
			ac.removeCode(dc);
			ac.removeCode(c);
			fail("LastCodeException should have been thrown");
		} catch (NotValidCodeException | CodeException e) {
		    e.printStackTrace();
			fail("Wrong type of exception thrown");
		} catch (LastCodeException e) {
		    // expected
        }
	}

	@Test
	public void testAddSensor() {
		try {
			Sensor s = new Sensor("window", ac);
			s.open();
			assertFalse(ac.isReady());
			assertFalse(ac.isArmed());
		} catch (DuplicateSensorException e) {
		    e.printStackTrace();
			fail("DuplicateSensorException should not have been thrown");
		}
	}
	
	@Test
	public void testAddDuplicateSensor() {
        try {
            new Sensor("window", ac);
        } catch (DuplicateSensorException e) {
            e.printStackTrace();
            fail("DuplicateSensorException should not have been thrown");
        }

        try {
            new Sensor("window", ac);
            fail("DuplicateSensorException should have been thrown");
        } catch (DuplicateSensorException e) {
            // expected
        }
    }

	@Test
	public void testIsReady() {
		s1.open();
		s2.open();
		assertFalse(ac.isReady());
		s1.close();
		assertFalse(ac.isReady());
		s2.close();
		assertTrue(ac.isReady());
	}
	
	@Test
	public void testArm() {
		try {
			ac.arm(dc);
			assertTrue(ac.isArmed());
		} catch (SystemNotReadyException | CodeException e) {
		    e.printStackTrace();
			fail("Exception should not have been thrown");
		}
	}
	
	@Test
	public void testArmCNRException() {
		try {
			ac.arm(c);
			fail("CodeException should have been thrown");
		} catch (SystemNotReadyException e) {
		    e.printStackTrace();
			fail("SystemNotReadException should not have been thrown");
		} catch (CodeException e) {
		    // expected
        }
	}
	
	@Test
	public void testArmSNRException() {
		try {
			s1.open();
			ac.arm(dc);
			fail("SystemNotReadyException should have been thrown");
		} catch (CodeException e) {
		    e.printStackTrace();
			fail("Wrong type of exception thrown");
		} catch (SystemNotReadyException e) {
		    // expected
        }
	}

	@Test
	public void testDisarm() {
		try {
			assertFalse(ac.isArmed());
			ac.arm(dc);
			assertTrue(ac.isArmed());
			ac.disarm(dc);
			assertFalse(ac.isArmed());
		} catch (SystemNotReadyException | CodeException e) {
		    e.printStackTrace();
			fail("Exception should not have been thrown");
		}
	}
}
