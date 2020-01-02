package ca.ubc.cpsc210.odds.test;

import ca.ubc.cpsc210.odds.Odds;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestOdds {
    static final long LIMIT = 10000;
    Iterable<Long> odds;

    @BeforeEach
    public void setUp() {
        odds = new Odds();
    }

    @Test
    public void testFirstOdds() {
        Iterator<Long> it = odds.iterator();
        assertEquals(1, (long)it.next());
        assertEquals(3, (long)it.next());
        assertEquals(5, (long)it.next());
        assertEquals(7, (long)it.next());
    }

    @Test
    public void testSomeOdds() {
        long prev = -1;
        for (Long l : odds) {
            assertTrue(l % 2 == 1);
            assertEquals(prev + 2, l);
            prev = l;
            if (l >= LIMIT) break;
        }
    }
}
