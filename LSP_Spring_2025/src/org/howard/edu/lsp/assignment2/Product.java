package org.howard.edu.lsp.assignment2;

/**
 * The Product class represents a product in our dataset.
 * Each product has a unique ID, name, price, category, and price range.
 * The price range is calculated later during the ETL process.
 */

public class Product {
    private int productId;
    private String name;
    private double price;
    private String category;
    private String priceRange; // New field for the price range

    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getter methods
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getPriceRange() {
        return priceRange;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * Return a CSV-formatted string of the product.
     */
    @Override
    public String toString() {
        // Ensure price prints with two decimal places.
        return productId + "," + name + "," + String.format("%.2f", price) + "," + category + "," + priceRange;
    }
}
