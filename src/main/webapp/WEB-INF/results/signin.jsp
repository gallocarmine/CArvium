<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>signin</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signin.css">
</head>
<body>
<div class="login-container">

    <div class="login-image">
        <img src="${pageContext.request.contextPath}/images/register-image.png" alt="Login Image">
    </div>

    <div class="login">

        <form action="SigninServlet" method="POST">

            <a href="StartServlet">
                <img src="${pageContext.request.contextPath}/images/black-logo.png" alt="Logo" class="login-logo">
            </a>

            <h2>Sign in</h2>
            <div class="form-grid">
                <input type="text" id="firstname" name="firstname" placeholder="First Name" required>
                <input type="text" id="lastname" name="lastname" placeholder="Last Name" required>
                <input type="email" id="email" name="email" placeholder="Email" required>
                <input type="password" id="password" name="pass" placeholder="Password" required>
                <input type="text" id="street" name="street" placeholder="Street" required>
                <input type="number" id="civic" name="civic" max="1000" placeholder="Civic" required>
                <input type="number" id="cap" name="cap" max="100000" placeholder="CAP" required>
            </div>
            <input type="submit" value="Sign In">
            <div class="divider"><span>OR</span></div>
            <a class="back" href="LoginServlet">Torna al login</a>
        </form>

        <c:if test="${not empty error}">
            <span>${error}</span>
        </c:if>
    </div>
</div>
</body>
</html>
