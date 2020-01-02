package ca.ubc.cpsc210.odds;

import java.util.Iterator;

// The collection of odd integers
public class Odds implements Iterable<Long> {
    /**
     * Returns an iterator over elements of type Long.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Long> iterator() {
        return new OddsIterator();
    }
}
