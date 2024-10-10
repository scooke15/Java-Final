package category;
import java.util.ArrayList;
import java.util.List;

import tasks.Task;

public class Category {
    private String categoryName;
    private List<Task> tasks;

// constructor
    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.tasks = new ArrayList<>();
    }

// getters
    public String getCategoryName() {
        return categoryName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

// setters
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

// add task to the category
    public void addTask(Task task) {
        tasks.add(task);
    }
}
