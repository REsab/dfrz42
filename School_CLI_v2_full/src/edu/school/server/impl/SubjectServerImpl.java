package edu.school.server.impl;

import java.util.*;
import edu.school.bean.*;
import edu.school.dao.*;
import edu.school.dao.impl.*;
import edu.school.server.*;

public class SubjectServerImpl implements SubjectServer {

	private SubjectDao SubjectDao = new SubjectDaoImpl();

	@Override
	public Integer insert(Subject bean) {
		// TODO Auto-generated method stub
		return SubjectDao.insert(bean);
	}

	@Override
	public Integer update(Subject bean) {
		// TODO Auto-generated method stub
		return SubjectDao.update(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return SubjectDao.delete(id);
	}

	public List<Subject> list() {
		// TODO Auto-generated method stub
		return SubjectDao.list();
	}

	@Override
	public Subject load(Integer SubjectId) {
		// TODO Auto-generated method stub
		return SubjectDao.load(SubjectId);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return SubjectDao.count();
	}

	@Override
	public Subject loadByName(String SubjectName) {
		// TODO Auto-generated method stub
		return SubjectDao.loadByName(SubjectName);
	}

	@Override
	public Integer countByName(String SubjectName) {
		// TODO Auto-generated method stub
		return SubjectDao.countByName(SubjectName);
	}

}