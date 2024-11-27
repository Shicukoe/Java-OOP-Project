<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<body>
  <div class="alert-list"></div>

<span class="img-container">
  <a href="<c:url value='/trang-chu' />"><img src = "${pageContext.request.contextPath}/template/web/assets/images/logo.svg" width="200" height="300"></a>
</span>


<span class="img-container">
  <main class="main">
    <h1>Login</h1>
</span>
<div align = "center">
  <form action = "${pageContext.request.contextPath}/dang-nhap" method="post" id="form-login" class="form">
      <div class="form__group">
        <label for="name">Username</label>
        <input type="text" name="username" id="name" required>
      </div>
      <div class="form__group">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required>
      </div>
      <button class="form__button">Login</button>
  </form>
</div>

<!-- <script type="module" src="${pageContext.request.contextPath}/template/web/assets/js/script.js"></script> -->
</body>
</html>
