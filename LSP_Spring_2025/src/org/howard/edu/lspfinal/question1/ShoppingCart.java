package org.howard.edu.lspfinal.question1;

// References:
//   • https://www.geeksforgeeks.org
//   • https://www.onlinegdb.com

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding items,
 * removing items, applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private final Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     *
     * @param itemName the name of the item (must be non-empty)
     * @param price    the price of the item (must be > 0)
     * @throws IllegalArgumentException if name is empty or price is non-positive
     */
    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        items.put(itemName, price);
    }

    /**
     * Removes an item from the shopping cart.
     *
     * @param itemName the name of the item to remove
     * @throws IllegalArgumentException if the item is not in the cart
     */
    public void removeItem(String itemName) {
        if (!items.containsKey(itemName)) {
            throw new IllegalArgumentException("Item not found in cart.");
        }
        items.remove(itemName);
    }

    /** @return the number of items currently in the cart */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Calculates and returns the total cost of the cart,
     * applying any discounts currently in effect.
     *
     * @return total cost after applying discount
     */
    public double getTotalCost() {
        double total = items.values().stream().mapToDouble(Double::doubleValue).sum();
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies a valid discount code to the shopping cart.
     * Supported codes:
     * - "SAVE10": 10% discount
     * - "SAVE20": 20% discount
     *
     * @param code the discount code
     * @throws IllegalArgumentException if the code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /** @return the current discount percentage applied to the cart */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
}

