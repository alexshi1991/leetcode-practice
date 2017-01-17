/*
 * Problem:  https://leetcode.com/problems/peeking-iterator/
 *
 * Idea:     use a local copy of the iterator to get ahead one step and save the next() value
 *
 */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> itr;
    private Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr = iterator;
	    if (itr.hasNext()) {
	        next = itr.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int retVal = next;
	    if (itr.hasNext()) {
	        next = itr.next();
	    } else {
	        next = null;
	    }
	    return retVal;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}
