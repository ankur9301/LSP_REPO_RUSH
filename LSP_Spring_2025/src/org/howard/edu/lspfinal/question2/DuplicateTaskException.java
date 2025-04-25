package org.howard.edu.lspfinal.question2;

// References:
//   • https://www.geeksforgeeks.org
//   • https://www.onlinegdb.com

/**
 * Thrown when attempting to add a task whose name already exists.
 */
public class DuplicateTaskException extends Exception {
    /**
     * Constructs the exception with a detail message.
     *
     * @param message detail message explaining the duplicate
     */
    public DuplicateTaskException(String message) {
        super(message);
    }
}

