package Schol_CLI_V1_full.school.dao;

import Schol_CLI_V1_full.school.bean.StudentInfo;

import java.util.List;

public interface StudentInfoDao  {

    Integer insert(StudentInfo bean);

    Integer delete(Integer id);

    Integer update(StudentInfo bean);

    List<StudentInfo> GRADE_LIST();

}
