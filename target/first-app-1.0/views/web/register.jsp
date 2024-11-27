<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/admin/assets/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/admin/assets/css/style1.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>
  <div class="alert-list"></div>

  <main class="main">
    
    <h1>Register</h1>

    <form id="form-register" class="form">
      <div class="form__group">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" required>
      </div>

      <div class="form__group">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required>
      </div>

      <button class="form__button">Register</button>
    </form>

  </main>

  <script type="module" src="${pageContext.request.contextPath}/template/admin/assets/js/script.js"></script>
  <script type="module" src="${pageContext.request.contextPath}/template/admin/assets/js/script1.js"></script>

</body>
</html>
