package Schol_CLI_V1_full.school.services;

import Schol_CLI_V1_full.school.bean.Subject;

import java.util.List;

public interface SubjectService {

    Integer insert(Subject bean);

    Integer delete(Integer id);

    Integer update(Subject bean);

    List<Subject> Subject_LIST();
}
