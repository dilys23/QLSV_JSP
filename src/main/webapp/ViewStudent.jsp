<%@page import="Model.bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

	<table>
		<%
		ArrayList<Student> studentList = (ArrayList<Student>) request.getAttribute("studentList");%>
		<tr><th>IDSV</th><th>Name</th><th>Age</th><th>University</th></tr>	
		<%
		for (int i = 0; i < studentList.size(); i++) {
		%>
		
		<tr>
			<td><%=studentList.get(i).getId()%></td>
			<td><%=studentList.get(i).getName()%></td>
			<td><%=studentList.get(i).getAge()%></td>
			<td><%=studentList.get(i).getUniversity()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<p><a href="./Mainpage.jsp">Back</a></p>
</body>
</html>