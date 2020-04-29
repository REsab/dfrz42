package Schol_CLI_V1_full.school.services;



import Schol_CLI_V1_full.school.bean.Grade;

import java.util.List;

public interface GradeService {

    Integer insert(Grade bean);

    Integer delete(Integer id);

    Integer update(Grade bean);

    List<Grade> LIST();


}
