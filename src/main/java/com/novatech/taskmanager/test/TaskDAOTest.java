package com.novatech.taskmanager.test;

import com.novatech.taskmanager.dao.TaskDAO;
import com.novatech.taskmanager.model.Task;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskDAOTest {

    private static TaskDAO taskDAO;
    private static int insertedTaskId;

    @BeforeAll
    public static void setup() {
        taskDAO = new TaskDAO();
    }

    @Test
    @Order(1)
    public void testAddTask() {
        Task task = new Task("Test Task", "This is a test task", LocalDate.now().plusDays(1), "Pending");
        insertedTaskId = taskDAO.addTask(task);  // ✅ get actual inserted ID

        System.out.println("Inserted ID: " + insertedTaskId);

        Task addedTask = taskDAO.getTaskById(insertedTaskId);
        assertNotNull(addedTask);
        assertEquals("New Task", addedTask.getTitle());
    }


    @Test
    @Order(2)
    public void testGetTaskById() {
        Task task = taskDAO.getTaskById(insertedTaskId);
        System.out.println("get"+insertedTaskId);
        assertNotNull(task);
        assertEquals("Test Task", task.getTitle());
    }

    @Test
    @Order(3)
    public void testUpdateTask() {
        Task task = taskDAO.getTaskById(insertedTaskId);
        System.out.println("up"+insertedTaskId);
        task.setStatus("Completed");
        taskDAO.updateTask(task);

        Task updated = taskDAO.getTaskById(insertedTaskId);
        assertEquals("Completed", updated.getStatus());
    }

    @Test
    @Order(4)
    public void testDeleteTask() {
        taskDAO.deleteTask(insertedTaskId);
        System.out.println(insertedTaskId);
        Task deleted = taskDAO.getTaskById(insertedTaskId);
        assertNull(deleted);
    }
}
