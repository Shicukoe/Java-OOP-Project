<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/template/admin/assets/images/logo.svg" rel="icon" type="image/x-icon">



	<title><dec:title default="Trang chủ quản lí" /></title>
	

    <!-- Custom styles for this template-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/admin/assets/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/admin/assets/css/style1.css">
    <style>
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
    <%@ include file="/common/admin/header.jsp" %>
    <!-- header -->

    <dec:body/>

	<!-- footer -->
	<%@ include file="/common/admin/footer.jsp" %>
	<!-- footer -->
    <!-- <script type="module" src="${pageContext.request.contextPath}/template/admin/assets/js/script.js"></script> -->
    <!-- <script type="module" src="${pageContext.request.contextPath}/template/admin/assets/js/script1.js"></script> -->
    <!-- <script src="https://unpkg.com/axios/dist/axios.min.js"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


	
</body>
</html>