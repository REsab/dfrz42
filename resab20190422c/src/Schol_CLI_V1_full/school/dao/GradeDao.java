package Schol_CLI_V1_full.school.dao;



import Schol_CLI_V1_full.school.bean.Grade;

import java.util.List;

public interface GradeDao {
    Integer insert(Grade bean);

    Integer delete(Integer id);

    Integer update(Grade bean);

    List<Grade> GRADE_LIST();


}
