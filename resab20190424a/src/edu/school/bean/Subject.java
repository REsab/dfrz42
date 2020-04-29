package edu.school.bean;

public class Subject implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2810688379368936488L;

	public Subject() {

	}

	private String subjectName;
	private Integer subjectId;
	private Integer classHour;
	private Integer GradeId;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getClassHour() {
		return classHour;
	}

	public void setClassHour(Integer classHour) {
		this.classHour = classHour;
	}

	public Integer getGradeId() {
		return GradeId;
	}

	public void setGradeId(Integer gradeId) {
		GradeId = gradeId;
	}
}
