<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signin.css">
</head>
<body>
<div class="login-container">

    <div class="login-image">
        <img src="${pageContext.request.contextPath}/images/register-image.png" alt="Register Image">
    </div>

    <div class="login">

        <form action="${pageContext.request.contextPath}/auth/SigninServlet" method="POST" id="signinForm">

            <a  href="${pageContext.request.contextPath}/common/StartServlet">
                <img src="${pageContext.request.contextPath}/images/black-logo.png" alt="Logo" class="login-logo">
            </a>

            <h2>Sign in</h2>
            <div class="form-grid">
                <input type="text" id="firstname" name="firstname" placeholder="First Name" maxlength="30" pattern="^(?!\s*$).+" required>
                <input type="text" id="lastname" name="lastname" placeholder="Last Name" maxlength="30" pattern ="^(?!\s*$).+" required>
                <input type="email" id="email" name="email" placeholder="Email" maxlength="50" required>
                <input type="password" id="password" name="pass" placeholder="Password" maxlength="255"
                       pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$" required>
                <select id="country" name="country" required>
                    <option value="" disabled selected>Select Country</option>
                </select>
                <input type="text" id="street" name="street" placeholder="Street" maxlength="30" pattern="^(?!\s*$).+" required>
                <input type="number" id="civic" name="civic" max="1000" placeholder="Civic" required>
                <input type="number" id="cap" name="cap" max="100000" placeholder="Zip Code" required>
            </div>

            <input type="submit" value="Sign In">
            <div class="divider"><span>OR</span></div>
            <a class="back" href="${pageContext.request.contextPath}/auth/LoginServlet">Back to Login</a>
        </form>

        <!-- error output produced by JS script validation -->
        <span class="error" id="error-js"></span>

        <!-- error output produced by Servlet validation -->
        <c:if test="${not empty error}">
            <span class="error">${error}</span>
        </c:if>
    </div>
</div>

<script src="${pageContext.request.contextPath}/script/countryFilter.js"></script>
<script src="${pageContext.request.contextPath}/script/signinValidator.js"></script>

</body>
</html>
