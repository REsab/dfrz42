package edu.school.dao;

import edu.school.bean.Grade;

import java.util.List;

public interface GradeDao {
    Integer insert(Grade bean);

    Integer delete(Integer id);

    Integer update(Grade bean);

    List<Grade> GRADE_LIST();


}
