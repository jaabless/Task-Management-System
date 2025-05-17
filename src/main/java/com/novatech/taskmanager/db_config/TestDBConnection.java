package com.novatech.taskmanager.db_config;

import com.novatech.taskmanager.dao.TaskDAO;
import com.novatech.taskmanager.model.Task;

import java.util.List;

public class TestDBConnection {
    public static void main(String[] args) {
        TaskDAO dao = new TaskDAO();

        try {
            List<Task> tasks = dao.getAllTasks();

            if (tasks.isEmpty()) {
                System.out.println("✅ Connection successful, but no tasks found.");
            } else {
                System.out.println("✅ Connection successful. Tasks found:");
                for (Task task : tasks) {
                    System.out.println("- " + task.getTitle() + " [" + task.getStatus() + "]");
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Failed to connect or retrieve tasks: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
