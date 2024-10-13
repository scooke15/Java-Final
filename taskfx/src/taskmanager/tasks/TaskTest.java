package taskmanager.tasks;
import java.time.LocalDate;
import taskmanager.category.Category;

public class TaskTest {

    public static void main(String[] args) {
        Category workCategory = new Category("Work");

        TimedTask task = new TimedTask("Finish Assignment", "Complete project", LocalDate.of(2024, 9, 30), 1, "10:00 AM", "1:30 PM", workCategory);

        System.out.println("Task Details:");
        System.out.println(task.displayTaskDetails());

        System.out.println("\nTask Duration: " + task.calculateDuration());

        task.setTitle("Updated Assignment Title");
        task.setDueDate(LocalDate.of(2024, 10, 1));
        task.setStartTime("9:00 AM");
        task.setEndTime("12:00 PM");

        System.out.println("\nUpdated Task Details:");
        System.out.println(task.displayTaskDetails());
        System.out.println("Updated Task Duration: " + task.calculateDuration());
    }
}