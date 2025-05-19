<%@ page import="java.util.List" %>
<%@ page import="com.novatech.taskmanager.model.Task" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task List</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="container center">
    <button onclick="window.location.href='task?action=home'" class="add-task-button">
      Home
    </button>

    <h1>Task List</h1>

    <div class="task-header">
      <button onclick="window.location.href='task?action=new'">
        Add New Task
      </button>

      <form method="get" action="task">
        <label for="status">Filter:</label>
        <select name="status" id="status" onchange="this.form.submit()">
          <option value="All" <%= "All".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>All</option>
          <option value="Pending" <%= "Pending".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>Pending</option>
          <option value="In Progress" <%= "In Progress".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>In Progress</option>
          <option value="Completed" <%= "Completed".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>Completed</option>
        </select>
      </form>
    </div>


    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>
                     Due Date
                     <form method="get" action="task" style="display:inline;">
                         <input type="hidden" name="status" value="<%= request.getAttribute("selectedStatus") %>"/>
                         <input type="hidden" name="sort" value="<%= "asc".equals(request.getAttribute("currentSort")) ? "desc" : "asc" %>"/>
                         <button type="submit" style="border:none; background:none; cursor:pointer;" title="Toggle Sort">
                             <%= "asc".equals(request.getAttribute("currentSort")) ? "⬆️" : "⬇️" %>
                         </button>
                     </form>
                 </th>

                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Task> taskList = (List<Task>) request.getAttribute("taskList");
            for (Task task : taskList) {
        %>
            <tr>
                <td><%= task.getTitle() %></td>
                <td><%= task.getDescription() %></td>
                <td><%= task.getDueDate() %></td>
                <td><%= task.getStatus() %></td>
                <td>
                    <button onclick="window.location.href='task?action=edit&id=<%= task.getId() %>'"
                            style="background-color: #007bff; color: white; padding: 6px 12px; border: none; border-radius: 4px; cursor: pointer;">
                      Edit
                    </button>

                    <button onclick="confirmDelete('<%= task.getId() %>')"
                            style="background-color: #dc3545; color: white; padding: 6px 12px; border: none; border-radius: 4px; cursor: pointer;">
                      Delete
                    </button>

                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <div id="confirmDialog" style="display:none; position:fixed; top:30%; left:50%; transform:translate(-50%, -50%); background:#fff; padding:20px; border:1px solid #ccc; box-shadow:0 0 10px rgba(0,0,0,0.2); z-index:1000;">
      <p>Are you sure you want to delete this task?</p>
      <button onclick="proceedDelete()">Yes</button>
      <button onclick="closeDialog()">Cancel</button>
    </div>


    <script src="js/scripts.js"></script>
</body>
</html>
