package Model.bo;

import java.util.ArrayList;

import Model.bean.Student;
import Model.dao.D_Student;

public class B_Student {
D_Student checkLoginDAO = new D_Student();
public boolean isValidUser(String username,String password) {
	return checkLoginDAO.isExistUser(username,password);
}

public ArrayList<Student> getStudentList(){
	return checkLoginDAO.getStudentList();
}

public void addStudent(Student student)
{
	D_Student studentDAO = new D_Student();
	studentDAO.addStudent(student);
}
public Student getStudentById(String studentId) {
    return checkLoginDAO.getStudentById(studentId);
}
public void updateStudent(Student student)
{
	D_Student studentDAO = new D_Student();
	studentDAO.updateStudent(student);
	
}
public void deleteStudent(String idsv)
{
	D_Student studentDAO = new D_Student();
	studentDAO.deleteStudent(idsv);
	
}
public ArrayList<Student> findStudent(String searchCriteria,String key)
{
	return checkLoginDAO.findStudent(searchCriteria, key);
	
}
}