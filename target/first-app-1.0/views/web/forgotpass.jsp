<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Password Recovery</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/admin/assets/css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>
  <div class="alert-list"></div>

  <!-- <header class="header">
    <div class="header__logo">
        <a href="index.html"><img src="${pageContext.request.contextPath}/template/web/assets/images/logo.svg" alt="Monito"></a>
    </div>
    <div class="header__menu">
      <ul>
        <li>
          <a href="${pageContext.request.contextPath}/views/web/login.jsp" button-login>Login</a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/views/web/register.jsp" button-register>Register</a>
        </li>
        <li>
          <button button-logout>Logout</button>
        </li>
      </ul>
    </div>
  </header> -->

  <main class="main">
    
    <h1>Password Recovery</h1>

    <form id="form-forgot-password" class="form">
      <div class="form__group">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" required>
      </div>

      <button class="form__button">Receive verification email</button>
    </form>

  </main>

  <script type="module" src="${pageContext.request.contextPath}/template/admin/assets/js/script.js"></script>
</body>
</html>