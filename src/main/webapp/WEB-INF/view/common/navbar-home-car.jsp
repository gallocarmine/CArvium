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
            <p>Brand <i class="bi bi-chevron-right"></i></p>
            <p>Models <i class="bi bi-chevron-right"></i></p>
            <a href="${pageContext.request.contextPath}/common/ShopServlet">
                Shop <i class="bi bi-cart3"></i>
            </a>
        </div>
    </div>

  <a href="${pageContext.request.contextPath}/common/StartServlet" class="logo">
    <img src="${pageContext.request.contextPath}/images/white-logo.png" alt="Logo">
  </a>

  <div class="login-icon">
      <c:if test = "${empty user}">
          <a href="${pageContext.request.contextPath}/auth/LoginServlet">
          <i class="bi bi-person-fill"></i>
          </a>
      </c:if>

      <c:if test = "${not empty user}">
            <a href="${pageContext.request.contextPath}/user/AccountServlet">
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

<script src="${pageContext.request.contextPath}/script/menuView.js"></script>

</body>
</html>
