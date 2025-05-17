<%@ page import="com.novatech.taskmanager.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Form</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="container center">
    <h1><%= (request.getParameter("id") == null) ? "Add New Task" : "Edit Task" %></h1>

    <%
        Task task = (Task) request.getAttribute("task");
        boolean isEdit = task != null && task.getId() != 0;
    %>

    <form action="task?action=<%= isEdit ? "update" : "insert" %>" method="post">
        <% if (isEdit) { %>
            <input type="hidden" name="id" value="<%= task.getId() %>">
        <% } %>

        <label>Title<span style="color:red">*</span></label>
        <input type="text" name="title" value="<%= task.getTitle() != null ? task.getTitle() : "" %>" required><br>

        <label>Description<span style="color:red">*</span></label>
        <textarea name="description" required><%= task.getDescription() != null ? task.getDescription() : "" %></textarea><br>

        <label>Due Date<span style="color:red">*</span></label>
        <input type="date" name="dueDate" value="<%= task.getDueDate() != null ? task.getDueDate().toString() : "" %>" required><br>

        <label>Status<span style="color:red">*</span></label>
        <select name="status" required>
            <option value="" disabled selected>Select status</option>
            <option value="Pending" <%= "Pending".equals(task.getStatus()) ? "selected" : "" %>>Pending</option>
            <option value="In Progress" <%= "In Progress".equals(task.getStatus()) ? "selected" : "" %>>In Progress</option>
            <option value="Completed" <%= "Completed".equals(task.getStatus()) ? "selected" : "" %>>Completed</option>
        </select><br>


        <button type="submit"><%= isEdit ? "Update" : "Add" %> Task</button>
    </form>
    <br>

    <a href="task">← Back to Task List</a>
</body>
</html>
