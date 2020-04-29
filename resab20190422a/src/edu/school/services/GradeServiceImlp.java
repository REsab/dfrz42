package edu.school.services;

import edu.school.bean.Grade;
import edu.school.dao.GradeDao;
import edu.school.dao.GradeDaoImlp;

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
