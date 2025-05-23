<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Signup - Task Manager</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="authContainer">

<div class="loginContainer">
    <h2>Sign Up</h2>
    <form action="signup" method="post" class="authForm">
        <label for="username">Username:</label>
        <input type="text" name="username" required>

        <label for="password">Password:</label>
        <input type="password" name="password" required>

        <!-- Inline checkbox and label -->
        <div style="display: flex; align-items: center; margin: 10px 0;">
            <input type="checkbox" id="remember" name="remember" style="margin-right: 5px;">
            <label for="remember" style="margin: 0;">Remember Me</label>
        </div>

        <button type="submit" class="submitBtn">Signup</button>

        <% if (request.getAttribute("error") != null) { %>
            <p style="color:red;"><%= request.getAttribute("error") %></p>
        <% } %>

        <p style="text-align:center">
            <span style="color:gray">Already have an account? </span>
            <a href="login.jsp"><span style="color:#28a745">Login</span></a>
        </p>
    </form>

</div>
</body>
</html>
