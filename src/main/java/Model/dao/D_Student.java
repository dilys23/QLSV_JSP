package Model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.bean.Student;


public class D_Student {
	
	public boolean isExistUser(String username, String password) {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu", "root", "");
	        PreparedStatement ps = cnn.prepareStatement("select * from admin where username=? and password=?");
	        ps.setString(1, username);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next()) return true;
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	    return false; // User not found or an error occurred
	}

public ArrayList<Student> getStudentList(){
	ArrayList<Student> studentList = new ArrayList<>();
	 try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu?characterEncoding=UTF-8", "root", "");
	        PreparedStatement ps = cnn.prepareStatement("select * from sinhvien");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Student student = new Student(rs.getString("IDSV"), rs.getString("Name"), rs.getInt("Age"), rs.getString("University"));
	            studentList.add(student);
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	return studentList;

}
public void addStudent(Student student) {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu?characterEncoding=UTF-8", "root", "");
        // Kiểm tra xem mã sinh viên đã tồn tại hay chưa
        PreparedStatement checkExisting = cnn.prepareStatement("SELECT IDSV FROM sinhvien WHERE IDSV = ?");
        checkExisting.setString(1, student.getId());
        ResultSet existingResult = checkExisting.executeQuery();

        if (existingResult.next()) {
            // Nếu mã sinh viên đã tồn tại, xử lý hoặc thông báo lỗi
            System.out.println("Mã sinh viên đã tồn tại trong cơ sở dữ liệu.");
            // Hoặc throw một exception để thông báo lỗi và ngăn việc thêm sinh viên trùng mã
        } else {
            // Nếu mã sinh viên không tồn tại, thêm vào cơ sở dữ liệu
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO sinhvien (IDSV, Name, Age, University) VALUES (?, ?, ?, ?)");
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getUniversity());
            ps.executeUpdate();
            System.out.println("Thêm sinh viên thành công!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public Student getStudentById(String studentId) {
    Student student = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu?characterEncoding=UTF-8", "root", "");
             PreparedStatement ps = cnn.prepareStatement("SELECT * FROM sinhvien WHERE IDSV=?")) {

            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Tạo đối tượng Student từ dữ liệu trong ResultSet
                student = new Student(
                        rs.getString("IDSV"),
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("University")
                );
            }
        }
    } catch (Exception e) {
        // Xử lý ngoại lệ ở đây, ví dụ ghi log hoặc thông báo lỗi
        e.printStackTrace();
    }
    return student;
}

public void updateStudent(Student student)
{
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu?characterEncoding=UTF-8", "root", "");
	    PreparedStatement ps = cnn.prepareStatement("UPDATE sinhvien SET Name=?, Age=?, University=? WHERE IDSV=?");

	    ps.setString(1, student.getName());
	    ps.setInt(2, student.getAge());
	    ps.setString(3, student.getUniversity());
	    ps.setString(4, student.getId());

	    int rowsAffected = ps.executeUpdate();
	    if (rowsAffected > 0) {
	        System.out.println("Student updated successfully!");
	    } else {
	        System.out.println("No student found with the provided ID for update.");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

}
public void deleteStudent(String idsv) {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu?characterEncoding=UTF-8", "root", "");
        PreparedStatement ps = cnn.prepareStatement("DELETE FROM sinhvien WHERE IDSV=?");
        ps.setString(1, idsv);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("No student found with the provided ID for deletion.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public ArrayList<Student> findStudent(String searchCriteria, String key) {
    ArrayList<Student> studentList = new ArrayList<>();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu?characterEncoding=UTF-8", "root", "");
             PreparedStatement ps = cnn.prepareStatement("SELECT * FROM sinhvien WHERE " + searchCriteria + " LIKE ?")) {

            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                        rs.getString("IDSV"),
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("University")
                );
                studentList.add(student);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return studentList;
}


}
