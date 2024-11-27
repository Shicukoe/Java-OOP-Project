<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/template/web/assets/css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
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
  <div class="alert-list"></div>



  <main class="main" style = "padding-top: 20px;">
    <div class="todo-app" style="display: none;">
      <h1 class="todo-app__title">TO-DO TASKS</h1>

      <form id="todo-app-create" class="todo-app__create">
        <input type="text" name="content" placeholder="Enter a task...">
        <button type="submit">
          <i class="fa-solid fa-plus"></i>
        </button>
      </form>
    
      <div id="todo-app-list" class="todo-app__list"></div>
    </div>
  </main>

  <script type="module" src="${pageContext.request.contextPath}/template/web/assets/js/script.js"></script>
</body>
</html>
