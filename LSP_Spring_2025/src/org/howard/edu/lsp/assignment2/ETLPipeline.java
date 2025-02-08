package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * We will read product data from a CSV file (Extract), process/transform the
 * data,
 * and then write the transformed data back out to another CSV file (Load).
 */

public class ETLPipeline {

    public static void main(String[] args) {

        // The input file will be in the 'data' folder. and output file will get stored
        // in data folder as well.
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";

        // We'll store all our products in this list once we read them in.
        ArrayList<Product> products = new ArrayList<>();

        // will read the input CSV file line by line.
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isHeader = true; // This flag will helps us skip the header row

            // we will Read each line from the file
            while ((line = br.readLine()) != null) {
                // If this is the header line, skip it.
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split the CSV line by commas.
                // (Assuming a simple CSV format with no commas within fields)
                String[] parts = line.split(",");

                // if the line doesn't have all 4 expected parts, we will ignore it.
                if (parts.length < 4) {
                    System.err.println("Warning: Skipping invalid line: " + line);
                    continue;
                }

                // Parse the parts of the line into our product fields.
                int productId = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                String category = parts[3].trim();

                // Create a new product object with the data and add it to our list.
                Product product = new Product(productId, name, price, category);
                products.add(product);
            }
        } catch (IOException e) {
            System.err.println("Error: Could not read the input file. " + e.getMessage());
            return; // Exit the program if we run into an issue reading the file.
        }

        // Now we will process each product in our list.
        for (Product product : products) {
            // Step 1: Converting the product name to uppercase.
            product.setName(product.getName().toUpperCase());

            // Step 2: Applying a 10% discount for electronics.
            if (product.getCategory().equalsIgnoreCase("Electronics")) {
                // Calculating the new price after discount.
                double discountedPrice = round(product.getPrice() * 0.9, 2);
                product.setPrice(discountedPrice);

                // If the discounted price is greater than $500, we will update the category.
                if (discountedPrice > 500) {
                    product.setCategory("Premium Electronics");
                }
            }

            // Step 3: we then will determine the price range based on the final price.
            double price = product.getPrice();
            if (price >= 0 && price <= 10) {
                product.setPriceRange("Low");
            } else if (price > 10 && price <= 100) {
                product.setPriceRange("Medium");
            } else if (price > 100 && price <= 500) {
                product.setPriceRange("High");
            } else if (price > 500) {
                product.setPriceRange("Premium");
            }
        }

        // Finally, we will write the transformed data to a new CSV file.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            // First, write the CSV header line.
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            // Now, write each product's data to the file.
            for (Product product : products) {
                bw.write(product.toString());
                bw.newLine();
            }

            System.out.println("Success: Data transformation complete. Output is in " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error: Unable to write to the output file. " + e.getMessage());
        }
    }

    /**
     * A helper method that rounds a double value to a specified number of decimal
     * places. This is useful for making sure prices are displayed properly.
     *
     * @param value  The original double value.
     * @param places The number of decimal places to round to.
     * @return The rounded value.
     */
    private static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException("Number of decimal places must be non-negative.");
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}