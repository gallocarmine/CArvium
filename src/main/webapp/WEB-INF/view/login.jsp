<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div class="login-container">
    <div class="login">

        <form action="${pageContext.request.contextPath}/auth/LoginServlet" method="POST" id="loginForm">

            <a href="${pageContext.request.contextPath}/common/StartServlet">
                <img src="${pageContext.request.contextPath}/images/black-logo.png" alt="Logo" class="login-logo">
            </a>

            <h2>Login</h2>
            <input type="email" id="email" name="email" placeholder="Email" maxlength="50" required>
            <input type="password" id="password" name="pass" placeholder="Password" maxlength="255"
                   pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$" required>
            <input type="submit" value="Login">
            <div class="divider"><span>OR</span></div>
            <a class="create" href="${pageContext.request.contextPath}/auth/SigninServlet">Create Account</a>
        </form>

        <!-- error output produced by JS script validation -->
        <span class="error" id="error-js"></span>

        <!-- error output produced by Servlet validation -->
        <c:if test="${not empty error}">
            <span class="error">${error}</span>
        </c:if>
    </div>

    <div class="login-image">
        <img src="${pageContext.request.contextPath}/images/login-image.png" alt="Login Image">
    </div>
</div>

<script src="${pageContext.request.contextPath}/script/loginValidator.js"></script>

</body>
</html>
