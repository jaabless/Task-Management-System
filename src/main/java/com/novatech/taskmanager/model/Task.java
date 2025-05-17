package com.novatech.taskmanager.model;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String status; // "Pending" or "Completed"

    public Task() {}

    public Task(int id, String title, String description, LocalDate dueDate, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task(String title, String description, LocalDate dueDate, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
