<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Task Manager</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="authContainer">
<div class="loginContainer" >
    <h2>Welcome back</h2>
    <form action="login" method="post" class="authForm">
        <label for="username">Username:</label>
        <input type="text" name="username" required>

        <label for="password">Password:</label>
        <input type="password" name="password" required>
        <a href="#"><span style="color:gray">Forgot Password?</span></a>
        <br>
        <br>

        <button type="submit" class="submitBtn" >Login</button>
        <% if (request.getAttribute("error") != null) { %>
                <p style="color:red;"><%= request.getAttribute("error") %></p>
            <% } %>
            <p style="text-align:center"><span style="color:gray">Don't have an account? </span><a href="signup.jsp"><span style="color:#28a745">Sign up</span></a></p>
    </form>

</div>
</body>
</html>
