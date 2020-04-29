package Schol_CLI_V1_full.school.bean;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class Result implements Serializable {


    private static final long serialVersionUID = 1215152596597802619L;
    private Integer id;
    private Integer SubjectId;
    private Integer StudentResult;
    private String Examdate;

    public String getExamdate() {
        return Examdate;
    }

    private String StudentNo;
    public Result(){

    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(Integer subjectId) {
        SubjectId = subjectId;
    }

    public Integer getStudentResult() {
        return StudentResult;
    }

    public void setStudentResult(Integer studentResult) {
        StudentResult = studentResult;
    }



    public void setExamdate(String examdate) {
        Examdate = examdate;
    }

    public String getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(String studentNo) {
        StudentNo = studentNo;
    }
}
