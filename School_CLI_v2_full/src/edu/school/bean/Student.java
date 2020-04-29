package edu.school.bean;

public class Student implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4952550116821473517L;

	public Student() {

	}

	private Integer studentId;
	private String studentNo;
	private String loginPwd;
	private String studentName;
	private String sex;
	private Integer GradeId;
	private String phone;
	private String address;
	private String bronDate;
	private String email;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getGradeId() {
		return GradeId;
	}

	public void setGradeId(Integer gradeId) {
		GradeId = gradeId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBronDate() {
		return bronDate;
	}

	public void setBronDate(String bronDate) {
		this.bronDate = bronDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
