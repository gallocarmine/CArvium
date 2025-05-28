<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Singin</title>
</head>
<body>

<div>
    <form action = "SigninServlet" method = "POST">
        <label for = "firstname"></label>
        <input type = "text" id = "firstname" name = "firstname" placeholder = "First Name" required >
        <label for = "lastname"></label>
        <input type = "text" id = "lastname" name = "lastname" placeholder = "Last Name" required><br><br>
        <label for = "email"></label>
        <input type = "email" id = "email" name = "email" placeholder = "Email" required>
        <label for = "password"></label>
        <input type = "password" id = "password" name = "pass" placeholder = "Password" required><br><br>
        <label for = "street"></label>
        <input type = "text" id = "street" name = "street" placeholder = "Street" required>
        <label for = "civic"></label>
        <input type = "number" id = "civic" name = "civic" max = "1000" placeholder = "Civic" required>
        <label for = "cap"></label>
        <input type = "number" id = "cap" name = "cap" max= "100000" placeholder = "CAP" required><br><br>
        <input type = "submit" value = "Sing In">
    </form>
</div>

    <c:if test = "${not empty error}">
        <span>${error}</span>
    </c:if>

</body>
</html>
