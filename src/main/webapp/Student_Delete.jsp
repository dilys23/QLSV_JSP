<%@page import="Model.bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
   <form name="form1" method="post" action="C_Student?mod=4&IDSV">
	<table>
		<%
		 ArrayList<Student> studentList = (ArrayList<Student>)request.getAttribute("studentList");%>
		<tr><th>IDSV</th><th>Name</th><th>Age</th><th>University</th><th>Delete</th></tr>	
		<% 
        for(Student student : studentList){
		%>
		
			<tr>
				  <td><%= student.getId() %></td>

                <td><%= student.getName() %></td>

                <td><%= student.getAge() %></td>

                <td><%= student.getUniversity() %></td>
                <td><input type="checkbox" name="IDSV" value="<%= student.getId() %>"></td>
                

 		</tr>
		<%} %>
	</table>
	<input type="submit" value="Delete">
	
	<p><a href="./Mainpage.jsp">Back</a></p>
	</form>
</body>
</html>