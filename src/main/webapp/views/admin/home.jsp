<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>PetShop Management</title>
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
  <div align = "center">
      <!-- Logout Button -->
      <div>
        <form action="<c:url value='/dang-nhap' />" method="get" style="margin: 0;">
          <button type="submit" class="logout-button" style="margin-top: 20px;">Log Out</button>
        </form>
      </div>

  <h1 class="title">PETSHOP MANAGER</h1>
  <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }
    .table-container {
        margin: 20px auto;
        padding: 15px;
        width: 80%;
        background-color: rgba(255, 255, 255, 0.9); /* White with slight transparency */
        border: 1px solid #ddd;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }
    table {
        width: 90%;
        border-collapse: collapse;
        background-color: white;
    }
    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f4f4f4;
        font-weight: bold;
    }
    tr:hover {
        background-color: #f9f9f9;
    
    }
    button {
        background-color: #007BFF;
        color: white;
        font-weight: bold;
        font-size: 16px;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    button:hover {
        background-color: #0056b3;
    }
</style>
  <a href="<c:url value='/admin-Them-thu-cung' />"  class="btn-add">Add New Pet</a>

  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Type</th>
        <th>Breed</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Description</th>
        <th>Add by</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="pet" items="${petList.listResult}">
        <tr>
            <td>${pet.id}</td>
            <td>${pet.name}</td>
            <td>${pet.price}</td>
            <td>${pet.type}</td>
            <td>${pet.breed}</td>
            <td>${pet.age}</td>
            <td>${pet.gender}</td>
            <td>${pet.description}</td>
            <td>${pet.addedBy}</td>
            <td>
                       <!-- Edit Button -->
                      <a href="<c:url value='/admin-Chinh-sua-thong-tin'>
                                  <c:param name='id' value='${pet.id}'/></c:url>">Edit</a>
                                  &nbsp;&nbsp;
                      <!--Delete Button-->
                      <a href="<c:url value='/admin-delete'>
                                  <c:param name='id' value='${pet.id}'/></c:url>"
                         onclick="return confirm('Are you sure you want to delete this pet?');">
                          Delete
                      </a>
                  </td>
              </tr>
      </c:forEach>
    </tbody>
  </table>
  </div>
  <!-- <script src="https://unpkg.com/axios/dist/axios.min.js"></script> --> 
  <!-- <script src="${pageContext.request.contextPath}/template/admin/assets/js/script1.js"></script> -->

</body>
</html>