package Zoho;

public class StudentDetails {
public int id;
private String name;
private String gender;
private String dob;
private int age;
private String mailid;
private long contactno;
private String course;
private String dept;
public StudentDetails(int id, String name, String gender, String dob, int age, String mailid, long contactno, String dept,
		String course) {
	super();
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.dob = dob;
	this.age = age;
	this.mailid = mailid;
	this.contactno = contactno;
	this.course = course;
	this.dept = dept;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getMailid() {
	return mailid;
}
public void setMailid(String mailid) {
	this.mailid = mailid;
}
public long getContactno() {
	return contactno;
}
public void setContactno(long contactno) {
	this.contactno = contactno;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
@Override
public String toString() {
	return id + "			" + name + "			" + gender + "			" +dob + "			"+age+"				" + mailid
			+ "					" + contactno + "				" + course + "			" +dept+"\n";
}


}
