<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/template/web/assets/css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
  <link href="${pageContext.request.contextPath}/template/admin/assets/images/logo.svg" rel="icon" type="image/x-icon">

  <style>
    .img-container {
      text-align: center;
      display: block;
      height: 200px;
    }
    body{
      background-image: url('${pageContext.request.contextPath}/template/web/assets/images/background_real.svg');
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: 100% 100%;
    }
  </style>
</head>
<body>
	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    

    <dec:body/>
    
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->


	
</body>
</html>
