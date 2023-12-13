package Controller;

import java.io.IOException;


import java.net.http.HttpResponse;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.bean.Student;
import Model.bo.B_Student;

@WebServlet("/C_Student")

public class C_Student extends  HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
				doPost(request, response);
				
				
	};
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String destination = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mod = request.getParameter("mod");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		B_Student checkLoginBO = new B_Student();
		ArrayList<Student> studentList = null;
		if(checkLoginBO.isValidUser(username,password) && mod==null) {
			destination = "/Mainpage.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
		else if (mod != null && mod.equals("1")) {

		    studentList = checkLoginBO.getStudentList();

		    request.setAttribute("studentList", studentList);

		    destination = "/ViewStudent.jsp"; 

		    RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);

		    rd.forward(request, response);

		}
		
		else if (mod != null && mod.equals("3")) {
		    String method = request.getMethod();
		    if ( request.getParameter("IDSV") != null) {
		        
		    	{
		    		if (method.equalsIgnoreCase("POST") )// Lấy IDSV từ request
		    		{
		    			 String idsv = request.getParameter("IDSV");
		 		        String name = request.getParameter("Name");
		 		        int age = Integer.parseInt(request.getParameter("Age"));
		 		        String university = request.getParameter("University");
		 		        Student updateStudent = new Student(idsv, name, age, university);
		 		        checkLoginBO.updateStudent(updateStudent);
		 		        // Sau khi cập nhật xong, chuyển hướng về danh sách sinh viên
		 		       response.sendRedirect(request.getContextPath()+ "/C_Student?mod=3");
		 		
		    		}
		    		else 
		    		{
		    			String idsv = request.getParameter("IDSV");
		    			  Student student = checkLoginBO.getStudentById(idsv);
		    			  request.setAttribute("student", student);
		  		        // Truyển hướng đến trang Student_Update.jsp với thông tin sinh viên cần cập nhật
		  		        RequestDispatcher rd = request.getRequestDispatcher("UpdateStudent.jsp");
		  		        rd.forward(request, response);
		    		}
		    	}
		    	
		    }  else {

		    	 studentList = checkLoginBO.getStudentList();

				    request.setAttribute("studentList", studentList);

				    destination = "/Student_Update.jsp"; 

				    RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);

				    rd.forward(request, response);
		    }
		}

		else if (mod != null && mod.equals("2")) {
				if (request.getMethod().equalsIgnoreCase("POST"))
				{
					String idsv = request.getParameter("IDSV");
					String name = request.getParameter("Name");
					int age = Integer.parseInt(request.getParameter("Age"));
					String university = request.getParameter("University");
					Student newStudent = new Student(idsv, name, age, university);
					checkLoginBO.addStudent(newStudent);	
					response.sendRedirect(request.getContextPath()+ "/C_Student?mod=1");

				}
				else
				{
					 destination = "/AddStudent.jsp";

				        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);

				        rd.forward(request, response);

				}
				
			}
		else if (mod != null && mod.equals("4"))
		{
			String[] idDelete = request.getParameterValues("IDSV");
			if (idDelete !=null && idDelete.length > 0)
			{
				
				for (String idsv : idDelete)
				{
					checkLoginBO.deleteStudent(idsv);
					
				}
				
				response.sendRedirect(request.getContextPath()+ "/C_Student?mod=4");
			}
			else
			{
				 studentList = checkLoginBO.getStudentList();

				    request.setAttribute("studentList", studentList);

				    destination = "/Student_Delete.jsp"; 

				    RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);

				    rd.forward(request, response);
				
			}
		}
		// Trong phần xử lý mod=5 của Servlet
		else if (mod != null && mod.equals("5")) {
		    if (request.getMethod().equalsIgnoreCase("POST")) {
		        String searchCriteria = request.getParameter("search_criteria");
		        String key = request.getParameter("key");
		        
		        // Thực hiện tìm kiếm sinh viên dựa trên searchCriteria và key
		        ArrayList<Student> searchResult = checkLoginBO.findStudent(searchCriteria, key);
		        
		        request.setAttribute("studentList", searchResult);
		        destination = "/Search_Result.jsp";
		        
		        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		        rd.forward(request, response);
		    } else {
		        // Hiển thị trang tìm kiếm khi method là GET
		        destination = "/FindStudent.jsp";
		        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		        rd.forward(request, response);
		    }
		}

		else {
			destination = "/login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}

	}
}
