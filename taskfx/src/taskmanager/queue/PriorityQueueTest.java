package taskmanager.queue;
import java.time.LocalDate;
import taskmanager.category.Category;
import taskmanager.tasks.Task;
import taskmanager.tasks.TimedTask;

public class PriorityQueueTest {

    public static void main(String[] args) {
        // create a PriorityQueue
        PriorityQueue priorityQueue = new PriorityQueue();

        // create some tasks with different priorities
        TimedTask highPriorityTask = new TimedTask("High Priority Task", "Complete ASAP", LocalDate.of(2024, 9, 29), 1, "10:00 AM", "11:00 AM", new Category("Work"));
        TimedTask mediumPriorityTask = new TimedTask("Medium Priority Task", "Complete soon", LocalDate.of(2024, 10, 1), 2, "12:00 PM", "1:00 PM", new Category("Work"));
        TimedTask lowPriorityTask = new TimedTask("Low Priority Task", "Complete later", LocalDate.of(2024, 10, 5), 3, "2:00 PM", "4:00 PM", new Category("Home"));
        TimedTask highPriorityTask2 = new TimedTask("High Priority Task 2", "Complete ASAP", LocalDate.of(2024, 9, 29), 1, "10:00 AM", "11:00 AM", new Category("Work"));
        TimedTask mediumPriorityTask2 = new TimedTask("Medium Priority Task 2", "Complete soon", LocalDate.of(2024, 10, 1), 2, "12:00 PM", "1:00 PM", new Category("Work"));
        TimedTask highPriorityTask3 = new TimedTask("High Priority Task 3", "Complete later", LocalDate.of(2024, 10, 5), 1, "2:00 PM", "4:00 PM", new Category("Home"));


        // add tasks to the queue
        priorityQueue.addTaskToQueue(highPriorityTask);
        priorityQueue.addTaskToQueue(mediumPriorityTask);
        priorityQueue.addTaskToQueue(lowPriorityTask);
        priorityQueue.addTaskToQueue(highPriorityTask2);
        priorityQueue.addTaskToQueue(mediumPriorityTask2);
        priorityQueue.addTaskToQueue(highPriorityTask3);

        // print tasks in the queue, sorted by priority
        System.out.println("Tasks in PriorityQueue (sorted by priority):");
        for (Task task : priorityQueue.getTaskQueue()) {
            System.out.println(task.getTitle() + " (Priority: " + task.getPriorityAsString() + ")");
        }

        // test retrieving the highest-priority task
        Task nextTask = priorityQueue.getNextTask();
        System.out.println("\nNext Task (Highest Priority): " + nextTask.getTitle() + " (Priority: " + nextTask.getPriorityAsString() + ")");
    }
}