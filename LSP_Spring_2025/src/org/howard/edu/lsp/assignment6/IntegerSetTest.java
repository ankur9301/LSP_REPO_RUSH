package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Test
    @DisplayName("Test clear and isEmpty methods")
    public void testClearAndIsEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertFalse(set.isEmpty(), "Set should not be empty after adding elements.");
        
        set.clear();
        assertTrue(set.isEmpty(), "Set should be empty after clear().");
        assertEquals("[]", set.toString(), "toString should show an empty set.");
    }
    
    @Test
    @DisplayName("Test add, toString and duplicate prevention")
    public void testAddAndToString() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);
        set.add(5); // duplicate, should be ignored.
        
        // The order is not fixed but since the implementation uses ArrayList and adds at the end,
        // we expect the set not to include duplicate values.
        String expected = "[5, 10]";
        assertEquals(expected, set.toString(), "toString should list the elements without duplicates.");
    }
    
    @Test
    @DisplayName("Test length method")
    public void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length(), "Empty set should have length 0.");
        set.add(1);
        set.add(2);
        assertEquals(2, set.length(), "Length should be 2 after adding two unique integers.");
    }
    
    @Test
    @DisplayName("Test contains method")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(42);
        assertTrue(set.contains(42), "Set should contain 42.");
        assertFalse(set.contains(100), "Set should not contain 100.");
    }
    
    @Test
    @DisplayName("Test largest and exception when set is empty")
    public void testLargest() {
        IntegerSet set = new IntegerSet();
        set.add(7);
        set.add(3);
        set.add(15);
        assertEquals(15, set.largest(), "Largest should be 15.");

        set.clear();
        // Test that largest throws an exception when empty.
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            set.largest();
        }, "largest() should throw an exception for an empty set.");
        assertEquals("Set is empty.", exception.getMessage(), "Exception message should be 'Set is empty.'");
    }
    
    @Test
    @DisplayName("Test smallest and exception when set is empty")
    public void testSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(7);
        set.add(3);
        set.add(15);
        assertEquals(3, set.smallest(), "Smallest should be 3.");

        set.clear();
        // Test that smallest throws an exception when empty.
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            set.smallest();
        }, "smallest() should throw an exception for an empty set.");
        assertEquals("Set is empty.", exception.getMessage(), "Exception message should be 'Set is empty.'");
    }
    
    @Test
    @DisplayName("Test remove method")
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.remove(2);
        assertFalse(set.contains(2), "Set should not contain 2 after removal.");
        // Removing an element not present should not change the set.
        set.remove(100);
        assertEquals(2, set.length(), "Length should remain 2 when removing non-existent element.");
    }
    
    @Test
    @DisplayName("Test union operation")
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.union(set2);
        // The order may vary but the set should contain all unique integers.
        assertTrue(set1.contains(1) && set1.contains(2) && set1.contains(3) &&
                   set1.contains(4) && set1.contains(5), "Union should contain all elements from both sets.");
        // Check the size to ensure no duplicates.
        assertEquals(5, set1.length(), "Union should have a length of 5.");
    }
    
    @Test
    @DisplayName("Test intersect operation")
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.intersect(set2);
        assertEquals("[3]", set1.toString(), "Intersection should only contain 3.");
    }
    
    @Test
    @DisplayName("Test diff operation")
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.diff(set2);
        // Expected result is set1 containing [1, 2]
        assertTrue(set1.contains(1) && set1.contains(2), "Difference should contain 1 and 2.");
        assertEquals(2, set1.length(), "Difference should reduce the size appropriately.");
    }
    
    @Test
    @DisplayName("Test complement operation")
    public void testComplement() {
        // In this test, treat set2 as the universal set.
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        set1.complement(set2);
        // The complement is set2 - set1, which should be [3, 4, 5]
        assertTrue(set1.contains(3) && set1.contains(4) && set1.contains(5), 
                   "Complement should contain elements from set2 not present in set1.");
        assertEquals(3, set1.length(), "Complement should have a length of 3.");
    }
    
    @Test
    @DisplayName("Test equals method")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        set1.add(3);
        set1.add(4);
        set1.add(5);
        
        IntegerSet set2 = new IntegerSet();
        set2.add(5);
        set2.add(4);
        set2.add(3);
        
        // Even though the order is different, the sets should be considered equal.
        assertTrue(set1.equals(set2), "Sets with the same elements should be equal.");
        
        set2.add(10);
        assertFalse(set1.equals(set2), "Sets should not be equal if one has an extra element.");
    }
}
