<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>login</title>
</head>
<body>

    <form action = "LoginServlet" method = "POST">
        <label for = "email">Email</label>
        <input type = "email" id = "email" name = "email" required><br><br>
        <label for = "password">Password</label>
        <input type = "password" id = "password" name = "pass" required>
        <input type = "submit" value = "Login">
    </form>

    <div class="divider"><span>OR</span></div>
    <a href = "SigninServlet">Create Account</a>

    <c:if test = "${not empty error}">
        <span>${error}</span>
    </c:if>

</body>
</html>
