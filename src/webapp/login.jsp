<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Task Manager</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="container center">
<div >
    <h2>Login</h2>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" required>

        <label for="password">Password:</label>
        <input type="password" name="password" required>

        <input type="submit" value="Login" class="add-task-button">
    </form>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <p>Dont have an account? <a href="signup.jsp">Sign up here</a></p>
</div>
</body>
</html>
