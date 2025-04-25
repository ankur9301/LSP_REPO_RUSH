package org.howard.edu.lspfinal.question3;

//References:
//https://www.geeksforgeeks.org
//https://www.onlinegdb.com


public class Driver {
    public static void main(String[] args) {
        Report sales = new SalesReport();
        sales.generateReport();

        Report inventory = new InventoryReport();
        inventory.generateReport();
    }
}
