package org.howard.edu.lspfinal.question1;

// References:
//   • https://www.geeksforgeeks.org
//   • https://www.onlinegdb.com

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShoppingCart Test Suite")
class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setup() {
        cart = new ShoppingCart();
    }

    @Test @DisplayName("Test adding valid item")
    void testAddValidItem() {
        cart.addItem("Apple", 1.50);
        assertEquals(1, cart.getItemCount());
    }

    @Test @DisplayName("Test adding item with zero price (expect exception)")
    void testAddItemZeroPrice() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("Banana", 0.0)
        );
        assertEquals("Price must be positive.", ex.getMessage());
    }

    @Test @DisplayName("Test adding item with negative price (expect exception)")
    void testAddItemNegativePrice() {
        assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("Orange", -2.00)
        );
    }

    @Test @DisplayName("Test adding item with empty name (expect exception)")
    void testAddItemEmptyName() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("", 5.00)
        );
        assertEquals("Item name cannot be empty.", ex.getMessage());
    }

    @Test @DisplayName("Test removing existing item")
    void testRemoveExistingItem() {
        cart.addItem("Milk", 3.00);
        assertEquals(1, cart.getItemCount());
        cart.removeItem("Milk");
        assertEquals(0, cart.getItemCount());
    }

    @Test @DisplayName("Test removing non-existent item (expect exception)")
    void testRemoveNonExistentItem() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.removeItem("Bread")
        );
        assertEquals("Item not found in cart.", ex.getMessage());
    }

    @Test @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Item1", 10.00);
        cart.addItem("Item2", 20.00);
        assertEquals(30.00, cart.getTotalCost());
    }

    @Test @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Item1", 50.00);
        cart.addItem("Item2", 50.00);
        cart.applyDiscountCode("SAVE10");
        assertEquals(90.00, cart.getTotalCost());
    }

    @Test @DisplayName("Test total cost with empty cart")
    void testTotalCostEmptyCart() {
        assertEquals(0.00, cart.getTotalCost());
    }

    @Test @DisplayName("Test applying SAVE10")
    void testApplySAVE10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test @DisplayName("Test applying SAVE20")
    void testApplySAVE20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test @DisplayName("Test applying invalid discount code (expect exception)")
    void testApplyInvalidCode() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.applyDiscountCode("SAVE50")
        );
        assertEquals("Invalid discount code.", ex.getMessage());
    }

    @Test @DisplayName("Test cart size updates correctly after adding/removing")
    void testCartSizeUpdates() {
        assertEquals(0, cart.getItemCount());
        cart.addItem("A", 1.00);
        assertEquals(1, cart.getItemCount());
        cart.addItem("B", 2.00);
        assertEquals(2, cart.getItemCount());
        cart.removeItem("A");
        assertEquals(1, cart.getItemCount());
    }
}





