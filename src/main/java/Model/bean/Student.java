package Model.bean;

public class Student {
private String IDSV;
private String Name;
private int Age;
private String University;

public Student(String IDSV ,String Name,int Age,String University) {
	this.IDSV = IDSV;
	this.Name = Name;
	this.Age = Age;
	this.University = University;
}
public String getId() {
	return IDSV;
}
public void setId(String IDSV) {
	this.IDSV = IDSV;
}

public String getName() {
	return Name;
}
public void setName(String Name) {
	this.Name = Name;
}
public int getAge() {
	return Age;
}
public void setAge(int Age) {
	this.Age = Age;
}
public String getUniversity() {
	return University;
}
public void setUniversity(String University) {
	this.University = University;
}




}
