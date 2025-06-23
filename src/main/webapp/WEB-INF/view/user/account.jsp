<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Account</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/user/UpdateUserServlet" method="POST" id="updateForm">

        <h2>My Account</h2>
        <input type="text" id="firstname" name="firstname" value="${user.nome}" maxlength="30" pattern="^(?!\s*$).+" required readonly>
        <input type="text" id="lastname" name="lastname" value="${user.cognome}" maxlength="30" pattern ="^(?!\s*$).+" required readonly>
        <input type="email" id="email" name="email" value="${user.email}" maxlength="50" required readonly>
        <input type="password" id="newPass" name="newPass" placeholder="Change password" maxlength="255"
               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$" required readonly>
        <input type="password" id="confirmPass" name="confirmPass" placeholder="Confirm password" maxlength="255"
               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$" required readonly>
        <select id="country" name="country" required disabled>
            <option value="${user.nazione}">${user.nazione}</option>
        </select>
        <input type="text" id="street" name="street" value="${user.via}" maxlength="30" pattern="^(?!\s*$).+" required readonly>
        <input type="number" id="civic" name="civic" value="${user.civico}" max="1000" placeholder="Civic" required readonly>
        <input type="number" id="cap" name="cap" value="${user.CAP}" max="100000" placeholder="Zip Code" required readonly>

        <input type="submit" value="Save">
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



