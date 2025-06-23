<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
</head>
<body>

<div class="navbar-car">

    <div class="dropdown-menu">
        <button class="menu-button">☰</button>
        <div class="menu-content">
            <a href="#">Option 1</a>
            <a href="#">Option 2</a>
            <a href="#">Option 3</a>
        </div>
    </div>

  <a href="${pageContext.request.contextPath}/common/StartServlet" class="logo">
    <img src="${pageContext.request.contextPath}/images/black-logo.png" alt="Logo">
  </a>

  <div class="login-icon">
      <c:if test = "${empty user}">
          <a href="${pageContext.request.contextPath}/auth/LoginServlet">
          <i class="bi bi-person-fill"></i>
          </a>
      </c:if>

      <c:if test = "${not empty user}">
            <a href="${pageContext.request.contextPath}/user/LogoutServlet">
            <i class="bi bi-person-gear"></i>
            </a>
      </c:if>

      <c:if test = "${not empty user}">
            <a href="${pageContext.request.contextPath}/user/LogoutServlet">
              <i class="bi bi-box-arrow-right"></i>
            </a>
      </c:if>
  </div>
</div>

</body>
</html>
