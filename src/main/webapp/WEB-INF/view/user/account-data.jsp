<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account - Data</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account/account-data.css">
</head>
<body>

<div class="data-container">

    <h2>My Account</h2>

    <form action="${pageContext.request.contextPath}/user/UpdateUserServlet" method="POST" id="updateForm">
        <input type="text" id="firstname" name="firstname" maxlength="30" pattern="^(?!\s*$).+" required readonly>
        <input type="text" id="lastname" name="lastname" maxlength="30" pattern="^(?!\s*$).+" required readonly>
        <input type="email" id="email" name="email" maxlength="50" required readonly>
        <input type="password" id="newPass" name="newPass" placeholder="Change password" maxlength="255"
               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$" readonly>
        <input type="password" id="confirmPass" name="confirmPass" placeholder="Confirm password" maxlength="255"
               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$" readonly>
        <select id="country" name="country" required disabled>
        </select>
        <input type="text" id="street" name="street" maxlength="30" pattern="^(?!\s*$).+" required readonly>
        <input type="number" id="civic" name="civic" max="1000" placeholder="Civic" required readonly>
        <input type="number" id="cap" name="cap" max="100000" placeholder="Zip Code" required readonly>
    </form>

    <button id="editFields" onclick=editFields()>Edit</button>

</div>

<!-- errors output produced by JS script validation -->
<span class="error" id="error-js"></span>
<span class="error" id="errorPass-js"></span>

<!-- error output produced by Servlet validation -->
<c:if test="${not empty error}">
    <span class="error">${error}</span>
</c:if>

</body>
</html>


<script src="${pageContext.request.contextPath}/script/switchAccountView.js"></script>
<script src="${pageContext.request.contextPath}/script/countryFilter.js"></script>
<script src="${pageContext.request.contextPath}/script/updateValidator.js"></script>