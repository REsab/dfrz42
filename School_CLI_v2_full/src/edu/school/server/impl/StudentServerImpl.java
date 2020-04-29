package edu.school.server.impl;

import java.util.*;
import edu.school.bean.*;
import edu.school.dao.*;
import edu.school.dao.impl.*;
import edu.school.server.*;

public class StudentServerImpl implements StudentServer {

	private StudentDao StudentDao = new StudentDaoImpl();

	@Override
	public Integer insert(Student bean) {
		// TODO Auto-generated method stub
		return StudentDao.insert(bean);
	}

	@Override
	public Integer update(Student bean) {
		// TODO Auto-generated method stub
		return StudentDao.update(bean);
	}

	@Override
	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return StudentDao.delete(id);
	}

	public List<Student> list() {
		// TODO Auto-generated method stub
		return StudentDao.list();
	}

	@Override
	public Student load(String StudentNo) {
		// TODO Auto-generated method stub
		return StudentDao.load(StudentNo);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return StudentDao.count();
	}

	@Override
	public Student loadByName(String studentName) {
		// TODO Auto-generated method stub
		return StudentDao.loadByName(studentName);
	}

	@Override
	public Integer countByName(String studentName) {
		// TODO Auto-generated method stub
		return StudentDao.countByName(studentName);
	}

}