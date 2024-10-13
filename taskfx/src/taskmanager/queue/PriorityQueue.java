package taskmanager.queue;
import java.util.*;
import taskmanager.tasks.*;


public class PriorityQueue {
    private List<TimedTask> taskQueue;

// constructor
    public PriorityQueue() {
        taskQueue = new ArrayList<>();
    }

// getters
    public List<TimedTask> getTaskQueue() {
        return taskQueue;
    }

// setters
    public void setTaskQueue(List<TimedTask> taskQueue) {
        this.taskQueue = taskQueue;
    }

// add task to the queue and sort by priority
    public void addTaskToQueue(TimedTask task) {
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
