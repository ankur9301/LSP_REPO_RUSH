package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code IntegerSet} class represents a set of integers with standard set operations.
 * It uses an {@code ArrayList} to store the elements and ensures that duplicates are not added.
 */
public class IntegerSet {

    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor.
     */
    public IntegerSet() {
    }

    /**
     * Constructor that initializes the set using the given ArrayList.
     * Any duplicate elements in the given list will be ignored.
     *
     * @param set the {@code ArrayList} of integers to initialize the set with
     */
    public IntegerSet(ArrayList<Integer> set) {
        for (Integer item : set) {
            if (!this.set.contains(item)) {
                this.set.add(item);
            }
        }
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the length of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Determines if two {@code IntegerSet} objects are equal.
     * Two sets are equal if they contain exactly the same integers (order does not matter).
     *
     * @param o the object to compare with this set
     * @return {@code true} if the sets are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet other = (IntegerSet) o;
        if (this.length() != other.length()) return false;
        for (Integer item : this.set) {
            if (!other.contains(item)) return false;
        }
        return true;
    }

    /**
     * Checks whether the set contains a specific value.
     *
     * @param value the integer to check
     * @return {@code true} if the set contains the value, {@code false} otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     *
     * @return the largest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty.");
        }
        int max = set.get(0);
        for (int num : set) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int smallest() throws IntegerSetException {
        if (isEmpty()) {
            throw new IntegerSetException("Set is empty.");
        }
        int min = set.get(0);
        for (int num : set) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }


    /**
     * Adds an integer to the set. If the integer already exists in the set,
     * the method does nothing.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an integer from the set. If the integer is not in the set,
     * the method does nothing.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        // Use Integer.valueOf to ensure the object is removed (not an index).
        set.remove(Integer.valueOf(item));
    }

    /**
     * Updates the current set to be the union of itself and another set.
     * The union contains all items that are in either set.
     *
     * @param intSetb the other {@code IntegerSet} to union with
     */
    public void union(IntegerSet intSetb) {
        for (Integer item : intSetb.set) {
            if (!this.contains(item)) {
                this.add(item);
            }
        }
    }

    /**
     * Updates the current set to be the intersection of itself and another set.
     * After this operation, the set contains only the elements that are present in both sets.
     *
     * @param intSetb the other {@code IntegerSet} to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (Integer item : this.set) {
            if (intSetb.contains(item)) {
                intersection.add(item);
            }
        }
        this.set = intersection;
    }

    /**
     * Updates the current set to be the difference between itself and another set.
     * The resulting set contains only the elements that are in this set but not in {@code intSetb}.
     *
     * @param intSetb the other {@code IntegerSet} for the difference operation
     */
    public void diff(IntegerSet intSetb) {
        ArrayList<Integer> difference = new ArrayList<>();
        for (Integer item : this.set) {
            if (!intSetb.contains(item)) {
                difference.add(item);
            }
        }
        this.set = difference;
    }

    /**
     * Updates the current set to be the complement of itself relative to the given set.
     * That is, it becomes the set of all elements that are in {@code intSetb} but not in this set.
     *
     * @param intSetb the universal set used to compute the complement
     */
    public void complement(IntegerSet intSetb) {
        ArrayList<Integer> comp = new ArrayList<>();
        for (Integer item : intSetb.set) {
            if (!this.contains(item)) {
                comp.add(item);
            }
        }
        this.set = comp;
    }

    /**
     * Checks if the set is empty.
     *
     * @return {@code true} if the set has no elements, {@code false} otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     *
     * @return a string listing the elements in the set
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
