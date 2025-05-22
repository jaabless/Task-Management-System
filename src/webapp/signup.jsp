<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Sign Up</title></head>
<body>
<h2>Sign Up</h2>
<form action="signup " method="post">
    <input name="username" placeholder="Username" required><br>
    <input name="password" type="password" placeholder="Password" required><br>
    <button type="submit">Sign Up</button>
</form>
<% if (request.getAttribute("error") != null) { %>
    <p style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>
</body>
</html>
