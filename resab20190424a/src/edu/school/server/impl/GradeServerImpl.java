package edu.school.server.impl;

import java.util.*;
import edu.school.bean.*;
import edu.school.dao.*;
import edu.school.dao.impl.*;
import edu.school.server.*;

public class GradeServerImpl implements GradeServer {

	private GradeDao gradeDao = new GradeDaoImpl();

	@Override
	public Integer insert(Grade bean) {
		// TODO Auto-generated method stub
		return gradeDao.insert(bean);
	}

	@Override
	public Integer update(Grade bean) {
		// TODO Auto-generated method stub
		return gradeDao.update(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return gradeDao.delete(id);
	}

	@Override
	public List<Grade> list() {
		// TODO Auto-generated method stub
		return gradeDao.list();
	}

	@Override
	public Grade load(Integer id) {
		// TODO Auto-generated method stub
		return gradeDao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return gradeDao.count();
	}

	@Override
	public Grade loadByName(String name) {
		// TODO Auto-generated method stub
		return gradeDao.loadByName(name);
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return gradeDao.countByName(name);
	}

}