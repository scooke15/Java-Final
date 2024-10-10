package tasks;
import java.time.*;
import java.time.format.*;

import category.Category;

public class TimedTask extends Task {
    private String startTime;
    private String endTime;

// constructor
    public TimedTask(String title, String description, LocalDate dueDate, int priority, String startTime, String endTime, Category category) {
        super(title, description, dueDate, priority, category);
        this.startTime = startTime;
        this.endTime = endTime;
    }

// getters
    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

// setters
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

// I used chatgpt to help me write the logic for the following method as I wasn't sure how to implement the time formatter and calculate the time
    // Method to calculate duration between startTime and endTime
    public String calculateDuration() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime start = LocalTime.parse(startTime, timeFormatter);
        LocalTime end = LocalTime.parse(endTime, timeFormatter);
        // Calculate the duration between the two times
        Duration duration = Duration.between(start, end);

        // Get the hours and minutes from the duration
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60; // Remainder to get minutes

        return hours + " hours and " + minutes + " minutes";
    }

    @Override
//detail display formatted for console testing
    public String displayTaskDetails() {
        return "================================" + "\n" +
               "Task: " + getTitle() + "\n" +
               "Description: " + getDescription() + "\n" +
               "Due Date: " + getDueDate() + "\n" +
               "Priority: " + getPriorityAsString() + "\n" +
               "Start Time: " + startTime + "\n" +
               "End Time: " + endTime + "\n" +
               "Duration: " + calculateDuration();
    }
}
