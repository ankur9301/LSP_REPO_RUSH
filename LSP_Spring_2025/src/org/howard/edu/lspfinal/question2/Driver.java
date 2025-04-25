package org.howard.edu.lspfinal.question2;

// References:
//   • https://www.geeksforgeeks.org
//   • https://www.onlinegdb.com

/**
 * Driver class for testing the TaskManager system.
 * Produces the sample output shown in the problem description.
 */
public class Driver {
    /**
     * Entry point: demonstrates add, lookup, update, and grouped printing.
     *
     * @param args command‐line arguments (unused)
     */
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        try {
            manager.addTask("Fix Bug #204", 1, "TODO");
            manager.addTask("Write Docs",   3, "TODO");
            manager.addTask("Setup CI/CD",  2, "IN_PROGRESS");

            // Duplicate task
            manager.addTask("Fix Bug #204", 4, "DONE");
        } catch (DuplicateTaskException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Task t = manager.getTaskByName("Write Docs");
            System.out.println("Retrieved: " + t);
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            manager.updateStatus("Write Docs",      "DONE");
            manager.updateStatus("Nonexistent Task","IN_PROGRESS");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Print all tasks grouped by status
        manager.printTasksGroupedByStatus();
    }
}

