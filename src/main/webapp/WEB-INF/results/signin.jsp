<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>singin</title>
</head>
<body>

<div>
    <form action = "SigninServlet" method = "POST">
        <label for = "firstname">First Name</label>
        <input type = "text" id = "firstname" name = "firstname" required>
        <label for = "lastname">Last Name</label>
        <input type = "text" id = "lastname" name = "lastname" required><br><br>
        <label for = "email">Email</label>
        <input type = "email" id = "email" name = "email" required>
        <label for = "password">Password</label>
        <input type = "password" id = "password" name = "pass" required><br><br>
        <label for = "street">Street</label>
        <input type = "text" id = "street" name = "street">
        <label for = "civic">Civ</label>
        <input type = "number" id = "civic" name = "civic" max = "1000">
        <label for = "cap">CAP</label>
        <input type = "number" id = "cap" name = "cap" max= "100000"><br><br>
        <input type = "submit" value = "Sing In">
    </form>
</div>

    <c:if test = "${not empty error}">
        <span>${error}</span>
    </c:if>

</body>
</html>
