<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>An error occurred</h2>
    <p><%= exception != null ? exception.getMessage() : "Unknown error" %></p>
    <a href="task" class="btn">Go Back to Task List</a>
</div>
</body>
</html>
