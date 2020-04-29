package edu.school.bean;

public class Result implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3680352769443007479L;

	public Result() {

	}

	private Integer Id;
	private String StudentNo;
	private Integer SubjectId;
	private String ExamDate;
	private Integer StudentResult;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getStudentNo() {
		return StudentNo;
	}

	public void setStudentNo(String studentNo) {
		StudentNo = studentNo;
	}

	public Integer getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(Integer subjectId) {
		SubjectId = subjectId;
	}

	public String getExamDate() {
		return ExamDate;
	}

	public void setExamDate(String examDate) {
		ExamDate = examDate;
	}

	public Integer getStudentResult() {
		return StudentResult;
	}

	public void setStudentResult(Integer studentResult) {
		StudentResult = studentResult;
	}

}
