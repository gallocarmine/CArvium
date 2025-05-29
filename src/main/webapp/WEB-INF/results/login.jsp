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

        <form action="${pageContext.request.contextPath}/auth/LoginServlet" method="POST">
            <a href="${pageContext.request.contextPath}/common/StartServlet">
                <img src="${pageContext.request.contextPath}/images/black-logo.png" alt="Logo" class="login-logo">
            </a>

            <h2>Login</h2>
            <input type="email" id="email" name="email" required placeholder="Email">
            <input type="password" id="password" name="pass" required placeholder="Password">
            <input type="submit" value="Login">
            <div class="divider"><span>OR</span></div>
            <a class="create" href="${pageContext.request.contextPath}/auth/SigninServlet">Create Account</a>
        </form>

        <c:if test="${not empty error}">
            <span>${error}</span>
        </c:if>
    </div>
    <div class="login-image">
        <img src="${pageContext.request.contextPath}/images/login-image.png" alt="Login Image">
    </div>
</div>
</body>
</html>
