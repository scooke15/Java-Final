package taskmanager.tasks;
import java.time.*;
import java.time.format.*;
import taskmanager.category.*;

public class TimedTask extends Task {
    private String startTime;
    private String endTime;

    public TimedTask(String title, String description, LocalDate dueDate, int priority, String startTime, String endTime, Category category) {
        super(title, description, dueDate, priority, category);
        this.startTime = startTime;
        this.endTime = endTime;
    }

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

    
    // i had some trouble with this function so some of it is written by chatgpt because i couldnt figure out formatting
    public String calculateDuration() {
        if (startTime == null || startTime.trim().isEmpty() || endTime == null || endTime.trim().isEmpty()) {
            return "Time not specified";  // Return message if times are not provided
        }
        // Define the time format to handle both "10:00 AM" and "10:00PM" formats with or without space
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");  // Accepts "1:00 PM"

        // Parse startTime and endTime into LocalTime objects
        LocalTime start = LocalTime.parse(startTime.trim().toUpperCase(), timeFormatter);  // Ensure proper formatting
        LocalTime end = LocalTime.parse(endTime.trim().toUpperCase(), timeFormatter);

        // Calculate the duration between the two times
        Duration duration = Duration.between(start, end);

        // Get the hours and minutes from the duration
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60; // Remainder to get minutes

        return hours + " hours and " + minutes + " minutes";
    }


    @Override
    public String displayTaskDetails() {
        return "================================" + "\n" +
               "Task: " + getTitle() + "\n" +
               "Description: " + getDescription() + "\n" +
               "Due Date: " + getDueDate() + "\n" +
               "Priority: " + getPriorityAsString() + "\n" +
               "Start Time: " + (startTime != null && !startTime.trim().isEmpty() ? startTime : "Not specified") + "\n" +
               "End Time: " + (endTime != null && !endTime.trim().isEmpty() ? endTime : "Not specified") + "\n" +
               "Duration: " + calculateDuration();
    }
}
