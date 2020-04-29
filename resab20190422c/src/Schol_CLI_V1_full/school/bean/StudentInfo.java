package Schol_CLI_V1_full.school.bean;

import java.io.Serializable;

public class StudentInfo implements Serializable {


    private static final long serialVersionUID = -5167173440572091306L;
    private Integer StudentId;
    private Integer GradeId;
    private String StudentNo;
    private String LoginPwd;
    private String StudentName;
    private String Sex;

    StudentInfo() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStudentId() {
        return StudentId;
    }

    public void setStudentId(Integer studentId) {
        StudentId = studentId;
    }

    public Integer getGradeId() {
        return GradeId;
    }

    public void setGradeId(Integer gradeId) {
        GradeId = gradeId;
    }

    public String getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(String studentNo) {
        StudentNo = studentNo;
    }

    public String getLoginPwd() {
        return LoginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        LoginPwd = loginPwd;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddresss() {
        return Addresss;
    }

    public void setAddresss(String addresss) {
        Addresss = addresss;
    }

    public String getBornDate() {
        return BornDate;
    }

    public void setBornDate(String bornDate) {
        BornDate = bornDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Phone;
    private String Addresss;
    private String BornDate;
    private String Email;


}
