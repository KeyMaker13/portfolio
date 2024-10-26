package linkedlistset;

import java.util.*;

public class LinkedListIterator<T> implements Iterator<T> {
	private SimpleNode<T> current; // the current position

	// -------------------------------------------------------------
	// Sets up this iterator using the specified items.
	// -------------------------------------------------------------
	public LinkedListIterator(SimpleNode<T> front) {
		current = front;
	}

	// -------------------------------------------------------------
	// Returns true if this iterator has at least one more element
	// to deliver in the iteration.
	// -------------------------------------------------------------
	public boolean hasNext() {
		return (current != null);
	}

	// -------------------------------------------------------------
	// Returns the next element in the iteration. If there are no
	// more elements in this iteration, a NoSuchElementException is
	// thrown.
	// -------------------------------------------------------------
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		T result = current.element;
		current = current.next;
		return result;
	}

	// -------------------------------------------------------------
	// The remove operation is not supported.
	// -------------------------------------------------------------
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
