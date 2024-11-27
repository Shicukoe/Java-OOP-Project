<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pet Manage</title>
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
  <style>
    body {
        font-family: Arial, sans-serif; /* Default font for form content */
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }
    .title {
        font-family: 'Roboto', sans-serif; /* Font for title */
        font-size: 32px;
        font-weight: bold;
        color: green;
        margin: 20px 0;
    }
    form {
        margin: 20px auto;
        width: 50%; /* Adjust the width of the form */
        background-color: #fff;
        padding: 20px;
        border: 1px solid #ddd;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }
    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
        color: #555;
    }
    input, select, textarea, button {
        width: 100%; /* Make inputs and select fields take full width */
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-family: Arial, sans-serif; /* Ensure Arial font for inputs */
        font-size: 14px;
    }
    textarea {
        resize: none; /* Prevent resizing */
        height: 100px; /* Default height */
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
  <div class="alert-list"></div>
  <div align = "center">
  <h1 class="title">Add New Pet</h1>

  <!-- Link to go back to the admin home page -->
  <a href="<c:url value='/admin-home' />" class="">Back</a>

  <!-- Form for adding a new pet -->
  <form method="post" action="${pageContext.request.contextPath}/admin-Them-thu-cung" class="form" id="form-create" >
    <!-- Input fields for pet details -->
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" value="${petAdd.name}" placeholder="Enter Pet Name" required>

    <label for="price">Price:</label>
    <input type="number" name="price" id="price" value="${petAdd.price}" placeholder="Enter Pet Price" min="0" step="0.01" required>

    <label for="type">Type:</label>
    <input type="text" name="type" id="type" value="${petAdd.type}" placeholder="Enter Pet Type (e.g., Dog, Cat)" required>

    <label for="breed">Breed:</label>
    <input type="text" name="breed" id="breed" value="${petAdd.breed}" placeholder="Enter Pet Breed" required>

    <label for="age">Age:</label>
    <input type="number" name="age" id="age" value="${petAdd.age}" placeholder="Enter Pet Age" min="0" required>

    <label for="gender">Gender:</label>
    <select name="gender" id="gender" required>
      <option value="Male" ${petAdd.gender == 'Male' ? 'selected' : ''}>Male</option>
      <option value="Female" ${petAdd.gender == 'Female' ? 'selected' : ''}>Female</option>
    </select>

    <label for="description">Description:</label>
    <textarea name="description" id="description" value="${petAdd.description}" placeholder="Enter Pet Description" rows="4" required></textarea>

    <!-- Hidden field for added_by (admin user) -->
    <label for="addedBy">Added By:</label>
    <input type="text" name="addedBy" id="addedBy" value="${petAdd.addedBy}" placeholder="Enter Admin Name" required>

    <button type="submit">Create New Pet</button>
    <!-- Submit button -->
  </form>
</div>
<!-- 
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  <script src="${pageContext.request.contextPath}/template/admin/assets/js/script1.js"></script> -->
</body>
</html>