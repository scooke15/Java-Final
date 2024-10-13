package taskmanager.tasks;
import java.time.*;
import taskmanager.category.Category;

public abstract class Task {
// private members
    private String title;
    private String description;
    private LocalDate dueDate;
    private int priority;
    private Category category;

// constructor
    public Task(String title, String description, LocalDate dueDate, int priority, Category category){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;

        category.addTask(this);
    }

// getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

// setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

//methods
    public String getPriorityAsString() {
        switch (priority) {
            case 1: return "High";
            case 2: return "Medium";
            case 3: return "Low";
            default: return "Unknown";
        }
    }
    
    public abstract String displayTaskDetails();
}