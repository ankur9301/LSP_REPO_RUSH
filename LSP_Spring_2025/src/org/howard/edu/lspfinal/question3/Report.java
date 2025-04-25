package org.howard.edu.lspfinal.question3;


//References:
//https://www.geeksforgeeks.org
//https://www.onlinegdb.com


public abstract class Report {
    // Template method—defines the skeleton of the algorithm
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
        System.out.println(); // blank line between reports
    }

    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}
