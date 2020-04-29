package Schol_CLI_V1_full.school.services;

import Schol_CLI_V1_full.school.bean.StudentInfo;
import Schol_CLI_V1_full.school.dao.StudentInfoDao;
import Schol_CLI_V1_full.school.dao.StudentInfoDaoImlp;

import java.util.List;

public class StudentInfoServiceImpl implements StudentInfoDao {


    private StudentInfoDao studentInfoDao = new StudentInfoServiceImpl();


    @Override
    public Integer insert(StudentInfo bean) {
        return studentInfoDao.insert(bean);
    }

    @Override
    public Integer delete(Integer id) {
        return studentInfoDao.delete(id);
    }

    @Override
    public Integer update(StudentInfo bean) {
        return studentInfoDao.update(bean);
    }

    @Override
    public List<StudentInfo> GRADE_LIST() {
        return studentInfoDao.GRADE_LIST();
    }
}
