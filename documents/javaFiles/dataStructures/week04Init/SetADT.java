package lib;

import java.util.*;

public interface SetADT<T> {
	// Adds one element to this set, ignoring duplicates
	public void add(T element);

	// Adds all elements in the parameter to this set, 
	// ignoring duplicates
	public void addAll(SetADT<T> set);

	// Removes and returns a random element from this set
	public T removeRandom();

	// Removes and returns the specified element from this set
	public T remove(T element);

	// Returns the union of this set and the parameter
	public SetADT<T> union(SetADT<T> set);

	// Returns true if this set contains the parameter
	public boolean contains(T target);

	// Returns true if this set and the parameter 
	// contain exactly same elements
	public boolean equals(SetADT<T> set);

	// Returns true if this set contains no elements
	public boolean isEmpty();

	// Returns the number of elements in this set
	public int size();

	// Returns an iterator for the elements in this set
	public Iterator<T> iterator();

	// Returns a string representation of this set
	public String toString();
}
