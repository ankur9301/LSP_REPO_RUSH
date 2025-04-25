package org.howard.edu.lspfinal.question2;

// References:
//   • https://www.geeksforgeeks.org
//   • https://www.onlinegdb.com

/**
 * Represents a Task with a unique name, priority, and status.
 */
public class Task {
    private final String name;
    private final int priority;
    private String status;

    /**
     * Constructs a Task with the given name, priority, and status.
     *
     * @param name     the unique name of the task
     * @param priority the priority (lower number = higher priority)
     * @param status   the initial status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /** @return the name of this task */
    public String getName() {
        return name;
    }

    /** @return the priority of this task */
    public int getPriority() {
        return priority;
    }

    /** @return the current status of this task */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of this task.
     *
     * @param status the new status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{name='" + name +
               "', priority=" + priority +
               ", status='" + status + "'}";
    }
}

