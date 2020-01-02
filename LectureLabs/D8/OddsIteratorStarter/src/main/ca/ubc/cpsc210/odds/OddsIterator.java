package ca.ubc.cpsc210.odds;

import java.util.Iterator;

/**
 * Iterator for odd integers
 */
public class OddsIterator implements Iterator<Long> {

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Long next() {
        return 0L; // TODO: implement me!
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("The odds iterator doesn't support remove");
    }
}
