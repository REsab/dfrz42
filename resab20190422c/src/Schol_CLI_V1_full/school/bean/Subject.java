package Schol_CLI_V1_full.school.bean;

import java.io.Serializable;

public class Subject implements Serializable {


    private static final long serialVersionUID = 6709055327904539805L;

    private Integer SubjetId;

    private String subjectName;
    private Integer ClassHour;
    private Integer GradeId;


     public  Subject(){

    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSubjetId() {
        return SubjetId;
    }

    public void setSubjetId(Integer subjetId) {
        SubjetId = subjetId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getClassHour() {
        return ClassHour;
    }

    public void setClassHour(Integer classHour) {
        ClassHour = classHour;
    }

    public Integer getGradeId() {
        return GradeId;
    }

    public void setGradeId(Integer gradeId) {
        GradeId = gradeId;
    }
}
