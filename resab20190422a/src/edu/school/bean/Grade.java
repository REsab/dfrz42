package edu.school.bean;

import java.io.Serializable;

public class Grade implements Serializable {


    private static final long serialVersionUID = -106817925865088875L;
    private  Integer gradeId;
    private String gradeName;

    public Grade(){

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }



    public Integer getGradeId() {
        return gradeId;
    }
}
