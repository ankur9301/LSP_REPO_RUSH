package org.howard.edu.lspfinal.question2;

// References:
//   • https://www.geeksforgeeks.org
//   • https://www.onlinegdb.com

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Manages a collection of uniquely named Tasks.
 * Supports adding, retrieving, updating status, and grouped printing.
 */
public class TaskManager {
    // preserves insertion order for predictable printing
    private final Map<String, Task> tasks = new LinkedHashMap<>();

    /**
     * Adds a new task.
     *
     * @param name     unique task name
     * @param priority lower number = higher priority
     * @param status   "TODO", "IN_PROGRESS", or "DONE"
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status)
            throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException(
                "Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     *
     * @param name the task name
     * @return the Task
     * @throws TaskNotFoundException if no such task exists
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task t = tasks.get(name);
        if (t == null) {
            throw new TaskNotFoundException(
                "Task '" + name + "' not found.");
        }
        return t;
    }

    /**
     * Updates the status of an existing task.
     *
     * @param name      the task name
     * @param newStatus "TODO", "IN_PROGRESS", or "DONE"
     * @throws TaskNotFoundException if no such task exists
     */
    public void updateStatus(String name, String newStatus)
            throws TaskNotFoundException {
        Task t = getTaskByName(name);
        t.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped by status in the order:
     * TODO, IN_PROGRESS, DONE.
     * Each task is indented by two spaces.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        String[] statuses = { "TODO", "IN_PROGRESS", "DONE" };
        for (String status : statuses) {
            System.out.println(status + ":");
            for (Task t : tasks.values()) {
                if (t.getStatus().equals(status)) {
                    System.out.println("  " + t);
                }
            }
        }
    }
}

