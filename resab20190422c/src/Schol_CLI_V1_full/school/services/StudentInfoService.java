package Schol_CLI_V1_full.school.services;

import Schol_CLI_V1_full.school.bean.StudentInfo;

import java.util.List;

public interface StudentInfoService {
    Integer insert(StudentInfo bean);

    Integer delete(Integer id);

    Integer update(StudentInfo bean);

    List<StudentInfo> GRADE_LIST();
}
