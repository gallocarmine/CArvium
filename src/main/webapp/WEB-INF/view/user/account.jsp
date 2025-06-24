<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
</head>
<body>
    <h2>My Account</h2>


    <form action="${pageContext.request.contextPath}/user/UpdateUserServlet" method="POST" id="updateForm">
        <input type="text" id="firstname" name="firstname" value="${userInfo.nome}" maxlength="30" pattern="^(?!\s*$).+" required readonly>
        <input type="text" id="lastname" name="lastname" value="${userInfo.cognome}" maxlength="30" pattern ="^(?!\s*$).+" required readonly>
        <input type="email" id="email" name="email" value="${userInfo.email}" maxlength="50" required readonly>
        <input type="password" id="newPass" name="newPass" placeholder="Change password" maxlength="255"
               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$" readonly>
        <input type="password" id="confirmPass" name="confirmPass" placeholder="Confirm password" maxlength="255"
               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$" readonly>
        <select id="country" name="country" required disabled>
            <option value="${userInfo.nazione}">${userInfo.nazione}</option>
        </select>
        <input type="text" id="street" name="street" value="${userInfo.via}" maxlength="30" pattern="^(?!\s*$).+" required readonly>
        <input type="number" id="civic" name="civic" value="${userInfo.civico}" max="1000" placeholder="Civic" required readonly>
        <input type="number" id="cap" name="cap" value="${userInfo.CAP}" max="100000" placeholder="Zip Code" required readonly>
    </form>

    <button onclick=editFields()>Edit</button>

    <!-- errors output produced by JS script validation -->
    <span class="error" id="error-js"></span>
    <span class="error" id="errorPass-js"></span>

    <!-- error output produced by Servlet validation -->
    <c:if test="${not empty error}">
        <span class="error">${error}</span>
    </c:if>

</body>
</html>


<script src="${pageContext.request.contextPath}/script/editUpdateForm.js"></script>
<script src="${pageContext.request.contextPath}/script/countryFilter.js"></script>
<script src="${pageContext.request.contextPath}/script/updateFormValidator.js"></script>



