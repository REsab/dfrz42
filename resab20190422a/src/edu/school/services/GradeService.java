package edu.school.services;

import edu.school.bean.Grade;

import java.util.List;

public interface GradeService {

    Integer insert(Grade bean);

    Integer delete(Integer id);

    Integer update(Grade bean);

    List<Grade> LIST();


}
