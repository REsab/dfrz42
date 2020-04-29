package Schol_CLI_V1_full.school.services;

import Schol_CLI_V1_full.school.bean.Result;
import Schol_CLI_V1_full.school.dao.ResultDao;
import Schol_CLI_V1_full.school.dao.ResultDaoImpl;

import java.util.List;

public class ResultServiceImlp implements ResultService {
    private ResultDao resultDao = new ResultDaoImpl();

    @Override
    public Integer insert(Result bean) {
        return resultDao.insert(bean);
    }


    @Override
    public Integer delete(Integer id) {
        return resultDao.delete(id);
    }

    @Override
    public Integer update(Result bean) {
        return resultDao.update(bean);
    }

    @Override
    public List<Result> GRADE_LIST() {
        return resultDao.GRADE_LIST();
    }
}
