<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Controller.C_Student"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AddStudent</title>
    <link rel="stylesheet" href="/View/style.css">
    <style>
       
        h2{
            margin-left: 640px;
        }
        .addSV {
            margin-left: 600px;
            width: 300px; /* Điều chỉnh chiều rộng của container form */
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form {
            margin: 0; /* Loại bỏ margin mặc định của form */
        }

        label {
            display: block; 
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
        a {
            margin-left: 890px;
        }
    </style>
</head>
<body>
    <h2>Thêm Thông tin sinh viên</h2>
    <!-- AddStudentForm.php -->
    <div class="addSV">
    <form method="post" action="?mod=3&idsv=<%= request.getParameter("idsv") %>">
    <label for="IDSV">IDSV:</label>
    <input type="text" name="IDSV" value="${student.id}" readonly><br>

    <label for="Name">Name:</label>
    <input type="text" name="Name" value="${student.name}" required><br>

    <label for="Age">Age:</label>
    <input type="number" name="Age" value="${student.age}" required><br>

    <label for="University">University:</label>
    <input type="text" name="University" value="${student.university}" required><br>

    <input type="submit" name="submit" value="Update Student">
</form>
</div>
<p><a href="./Mainpage.jsp">Back</a></p>
</body>
</html>