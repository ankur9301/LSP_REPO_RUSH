package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class IntegerSetTest {

    @Test
    @DisplayName("Test case for add and toString")
    public void testAddAndToString() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2); // Should not add duplicate
        assertEquals("[1, 2]", set.toString());
    }

    @Test
    @DisplayName("Test case for clear and isEmpty")
    public void testClearAndIsEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(1);
        assertTrue(a.equals(b));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
        assertFalse(set.contains(1));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(3); set.add(2);
        assertEquals(3, set.largest());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(5); set.add(2); set.add(9);
        assertEquals(2, set.smallest());
    }

    @Test
    @DisplayName("Test case for largest with empty set")
    public void testLargestException() {
        IntegerSet set = new IntegerSet();
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set.largest();
        });
        assertEquals("Set is empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for smallest with empty set")
    public void testSmallestException() {
        IntegerSet set = new IntegerSet();
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set.smallest();
        });
        assertEquals("Set is empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(3);
        a.union(b);
        assertEquals("[1, 2, 3]", a.toString());
    }

    @Test
    @DisplayName("Test case for intersection")
    public void testIntersect() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(3);
        a.intersect(b);
        assertEquals("[2]", a.toString());
    }

    @Test
    @DisplayName("Test case for difference")
    public void testDiff() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(2);
        a.diff(b);
        assertEquals("[1, 3]", a.toString());
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(1); b.add(2); b.add(3); b.add(4);
        a.complement(b);
        assertEquals("[3, 4]", a.toString());
    }
}
