package taskmanager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import taskmanager.category.*;
import taskmanager.queue.*;
import taskmanager.tasks.*;

import java.time.LocalDate;
import java.util.List;

public class TaskManagerApp extends Application {

    private PriorityQueue taskQueue = new PriorityQueue();  

    @Override
    public void start(Stage primaryStage) {
        // categories
        Category schoolCategory = new Category("School");
        Category workCategory = new Category("Work");
        Category homeCategory = new Category("Home");

        ComboBox<Category> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll(schoolCategory, workCategory, homeCategory);

        ComboBox<String> priorityComboBox = new ComboBox<>();
        priorityComboBox.getItems().addAll("High", "Medium", "Low");

        TextField titleField = new TextField();
        titleField.setPromptText("Enter task title");
        TextArea descriptionArea = new TextArea();
        descriptionArea.setPromptText("Enter task description");

        DatePicker dueDatePicker = new DatePicker();

        TextField startTimeField = new TextField();
        startTimeField.setPromptText("Start Time (e.g. 10:00 AM)");
        TextField endTimeField = new TextField();
        endTimeField.setPromptText("End Time (e.g. 12:00 PM)");

        Button addButton = new Button("Add Task");

        TextArea taskDisplayArea = new TextArea();
        taskDisplayArea.setEditable(false);

        // Handle the Add Task button
        addButton.setOnAction(event -> {
            // Get the input values from the form
            String title = titleField.getText();
            String description = descriptionArea.getText();
            LocalDate dueDate = dueDatePicker.getValue();
            String startTime = startTimeField.getText();
            String endTime = endTimeField.getText();
            String priorityString = priorityComboBox.getValue();
            Category selectedCategory = categoryComboBox.getValue();

            // Convert priority to integer (1 = High, 2 = Medium, 3 = Low)
            int priority = convertPriority(priorityString);

            if (title != null && description != null && dueDate != null && startTime != null && endTime != null && selectedCategory != null) {
                TimedTask task = new TimedTask(title, description, dueDate, priority, startTime, endTime, selectedCategory);
                taskQueue.addTaskToQueue(task);

                // Display all tasks in the PriorityQueue
                displayTasks(taskDisplayArea); // BROKEN
            }
        });

        VBox layout = new VBox(10, new Label("Category:"), categoryComboBox,
                new Label("Priority:"), priorityComboBox, new Label("Title:"), titleField,
                new Label("Description:"), descriptionArea, new Label("Due Date:"), dueDatePicker,
                new Label("Start Time:"), startTimeField, new Label("End Time:"), endTimeField,
                addButton, new Label("Tasks:"), taskDisplayArea);
        Scene scene = new Scene(layout, 400, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Task Manager");
        primaryStage.show();
    }

    // Convert priority from string to integer
    private int convertPriority(String priorityString) {
        switch (priorityString) {
            case "High":
                return 1;
            case "Medium":
                return 2;
            case "Low":
                return 3;
            default:
                return 3;  // Default to low
        }
    }

    // Display tasks in the PriorityQueue
    private void displayTasks(TextArea taskDisplayArea) {
        List<TimedTask> tasks = taskQueue.getTaskQueue();
        StringBuilder taskList = new StringBuilder();
        for (TimedTask task : tasks) {
            taskList.append(task.displayTaskDetails()).append("\n\n");
        }
        taskDisplayArea.setText(taskList.toString());
    }

    public static void main(String[] args) {
        launch(args); 
    }
}
