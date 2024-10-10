package queue;
import java.util.*;

import tasks.Task;

public class PriorityQueue {
    private List<Task> taskQueue;

// constructor
    public PriorityQueue() {
        taskQueue = new ArrayList<>();
    }

// getters
    public List<Task> getTaskQueue() {
        return taskQueue;
    }

// setters
    public void setTaskQueue(List<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

// add task to the queue and sort by priority
    public void addTaskToQueue(Task task) {
        taskQueue.add(task);
        sortTasksByPriority();
    }

// sort tasks by priority
    public void sortTasksByPriority() {
        taskQueue.sort(Comparator.comparingInt(Task::getPriority));
    }

// get the highest-priority task
    public Task getNextTask() {
        if (!taskQueue.isEmpty()) {
            return taskQueue.get(0); // returns the highest-priority task
        }
        return null;
    }
}
