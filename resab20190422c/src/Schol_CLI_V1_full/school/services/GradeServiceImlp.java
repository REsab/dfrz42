package Schol_CLI_V1_full.school.services;



import Schol_CLI_V1_full.school.bean.Grade;
import Schol_CLI_V1_full.school.dao.GradeDao;
import Schol_CLI_V1_full.school.dao.GradeDaoImlp;

import java.util.List;

public class GradeServiceImlp implements GradeService {
    private GradeDao gradeDao = new GradeDaoImlp();

    @Override
    public Integer insert(Grade bean) {
        return gradeDao.insert(bean);
    }

    @Override
    public Integer delete(Integer id) {
        return gradeDao.delete(id);
    }

    @Override
    public Integer update(Grade bean) {
        return gradeDao.update(bean);
    }

    @Override
    public List<Grade> LIST() {
        return gradeDao.GRADE_LIST();
    }
}
