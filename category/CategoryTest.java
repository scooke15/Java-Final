package category;
import java.time.LocalDate;
import java.util.List;

import tasks.Task;
import tasks.TimedTask;

public class CategoryTest {

    public static void main(String[] args) {
        Category workCategory = new Category("Work");
        Category homeCategory = new Category("Home");

        TimedTask workTask1 = new TimedTask("Complete Report", "Finish the quarterly report", LocalDate.of(2024, 9, 30), 1, "9:00 AM", "11:00 AM", workCategory);
        TimedTask workTask2 = new TimedTask("Team Meeting", "Discuss project status", LocalDate.of(2024, 10, 1), 2, "1:00 PM", "2:00 PM", workCategory);
        TimedTask homeTask1 = new TimedTask("Clean House", "Weekend house cleaning", LocalDate.of(2024, 9, 28), 3, "10:00 AM", "12:00 PM", homeCategory);

        System.out.println("Tasks in Work Category:");
        List<Task> workTasks = workCategory.getTasks();
        for (Task task : workTasks) {
            System.out.println(task.getTitle() + " - Due: " + task.getDueDate() + " (Priority: " + task.getPriorityAsString() + ")");
        }

        System.out.println("\nTasks in Home Category:");
        List<Task> homeTasks = homeCategory.getTasks();
        for (Task task : homeTasks) {
            System.out.println(task.getTitle() + " - Due: " + task.getDueDate() + " (Priority: " + task.getPriorityAsString() + ")");
        }

        System.out.println(workTask1.displayTaskDetails());
    }
}