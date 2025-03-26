package org.howard.edu.lsp.assignment5;

/**
 * The {@code Driver} class tests the functionality of the {@code IntegerSet} class.
 * It demonstrates the use of all methods defined in the {@code IntegerSet} class.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("Testing IntegerSet operations:\n");

        // Test: Create first set and add elements.
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        System.out.println("Value of Set1 is: " + set1.toString());
        System.out.println("Smallest value in Set1 is: " + set1.smallest());
        System.out.println("Largest value in Set1 is: " + set1.largest());

        // Test: Create second set and add elements.
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("\nValue of Set2 is: " + set2.toString());

        // Test: Union operation.
        System.out.println("\nUnion of Set1 and Set2:");
        System.out.println("Set1 before union: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.union(set2);
        System.out.println("Result of union: " + set1.toString());

        // Test: Intersection operation.
        // Reset set1 to [1,2,3]
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("\nIntersection of Set1 and Set2:");
        System.out.println("Set1 before intersection: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.intersect(set2);
        System.out.println("Result of intersection: " + set1.toString());

        // Test: Difference operation.
        // Reset set1 to [1,2,3,4,5]
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        System.out.println("\nDifference (Set1 - Set2):");
        System.out.println("Set1 before difference: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.diff(set2);
        System.out.println("Result of difference (Set1 - Set2): " + set1.toString());

        // Test: Complement operation.
        // Here, we treat set2 as the universal set.
        // For example, if set1 is [1,2] (result of diff) and set2 is [3,4,5],
        // then the complement (set2 - set1) should yield [3,4,5].
        System.out.println("\nComplement of Set1 relative to Set2:");
        System.out.println("Set1 before complement: " + set1.toString());
        System.out.println("Set2 (universal set): " + set2.toString());
        set1.complement(set2);
        System.out.println("Result of complement: " + set1.toString());

        // Test: equals method.
        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(4);
        set3.add(5);
        System.out.println("\nTesting equals method:");
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set3: " + set3.toString());
        System.out.println("Does Set1 equal Set3? " + set1.equals(set3));

        // Test: clear and isEmpty.
        System.out.println("\nTesting clear and isEmpty:");
        System.out.println("Set3 before clear: " + set3.toString());
        set3.clear();
        System.out.println("Set3 after clear: " + set3.toString());
        System.out.println("Is Set3 empty? " + set3.isEmpty());
    }
}
