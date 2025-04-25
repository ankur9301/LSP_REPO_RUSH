package org.howard.edu.lspfinal.question2;

// References:
//   • https://www.geeksforgeeks.org
//   • https://www.onlinegdb.com

/**
 * Thrown when a requested task cannot be found in the TaskManager.
 */
public class TaskNotFoundException extends Exception {
    /**
     * Constructs the exception with a detail message.
     *
     * @param message detail message explaining which task was missing
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
