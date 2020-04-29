package Schol_CLI_V1_full.school.services;

import Schol_CLI_V1_full.school.bean.Subject;
import Schol_CLI_V1_full.school.dao.SubjectDao;
import Schol_CLI_V1_full.school.dao.SubjectDaoImlp;

import java.util.List;

public class SubjectServiceImlp implements SubjectService {
    private SubjectDao subjectDao = new SubjectDaoImlp();

    @Override
    public Integer insert(Subject bean) {
        return subjectDao.insert(bean);
    }

    @Override
    public Integer delete(Integer id) {
        return subjectDao.delete(id);
    }

    @Override
    public Integer update(Subject bean) {
        return subjectDao.update(bean);
    }

    @Override
    public List<Subject> Subject_LIST() {
        return subjectDao.Subject_LIST();
    }
}
