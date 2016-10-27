package com.example.lupur.tasklist.model;

/**
 * Created by lupur on 25-Oct-16.
 */

public class Task {

    private String title;
    private String description;
    private Boolean isFinished;


    public Task(String title, String description, Boolean isFinished) {
        this.title = title;
        this.description = description;
        this.isFinished = isFinished;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsFinished() { return  isFinished; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsFinished(Boolean isFinished) { this.isFinished = isFinished; }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isFinished=" + isFinished +
                '}';
    }
}
