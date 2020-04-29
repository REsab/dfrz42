package Schol_CLI_V1_full.school.dao;

import Schol_CLI_V1_full.school.bean.Result;

import java.util.List;

public  interface ResultDao {

    Integer insert(Result bean);

    Integer delete(Integer id);

    Integer update(Result bean);

    List<Result> GRADE_LIST();


}
