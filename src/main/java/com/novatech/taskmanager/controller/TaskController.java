package com.novatech.taskmanager.controller;

import com.novatech.taskmanager.dao.TaskDAO;
import com.novatech.taskmanager.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/task")
public class TaskController extends HttpServlet {

    private TaskDAO taskDAO;

    @Override
    public void init() throws ServletException {
        taskDAO = new TaskDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteTask(request, response);
                    break;
                default:
                    listTasks(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "insert":
                    insertTask(request, response);
                    break;
                case "update":
                    updateTask(request, response);
                    break;
                default:
                    response.sendRedirect("task");
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listTasks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String statusFilter = request.getParameter("status");
        String sortOrder = request.getParameter("sort"); // "asc" or "desc"
        if (sortOrder == null) sortOrder = "asc"; // default

        List<Task> taskList;

        if (statusFilter != null && !statusFilter.equals("All")) {
            taskList = taskDAO.getTasksByStatusSorted(statusFilter, sortOrder);
            request.setAttribute("selectedStatus", statusFilter);
        } else {
            taskList = taskDAO.getAllTasksSortedByDueDate(sortOrder);
            request.setAttribute("selectedStatus", "All");
        }

        request.setAttribute("taskList", taskList);
        request.setAttribute("currentSort", sortOrder);
        request.getRequestDispatcher("/views/task-list.jsp").forward(request, response);
    }



    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("task", new Task());
        request.getRequestDispatcher("/views/task-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Task task = taskDAO.getTaskById(id);
        request.setAttribute("task", task);
        request.getRequestDispatcher("/views/task-form.jsp").forward(request, response);
    }

    private void insertTask(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));

        Task newTask = new Task(title, description, dueDate,status);
        taskDAO.addTask(newTask);
        response.sendRedirect("task");
    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));

        Task task = new Task(id, title, description, dueDate,status);
        taskDAO.updateTask(task);
        response.sendRedirect("task");
    }

    private void deleteTask(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        taskDAO.deleteTask(id);
        response.sendRedirect("task");
    }



}
