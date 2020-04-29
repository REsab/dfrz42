package edu.school.server.impl;

import java.util.*;
import edu.school.bean.*;
import edu.school.dao.*;
import edu.school.dao.impl.*;
import edu.school.server.*;

public class ResultServerImpl implements ResultServer {

	private ResultDao ResultDao = new ResultDaoImpl();

	@Override
	public Integer insert(Result bean) {
		// TODO Auto-generated method stub
		return ResultDao.insert(bean);
	}

	@Override
	public Integer update(Result bean) {
		// TODO Auto-generated method stub
		return ResultDao.update(bean);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return ResultDao.delete(id);
	}

	@Override
	public List<Result> list() {
		// TODO Auto-generated method stub
		return ResultDao.list();
	}

	@Override
	public Result load(Integer id) {
		// TODO Auto-generated method stub
		return ResultDao.load(id);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return ResultDao.count();
	}

	@Override
	public Result loadByName(String studentNo) {
		// TODO Auto-generated method stub
		return ResultDao.loadByName(studentNo);
	}

	@Override
	public Integer countByName(String studentNo) {
		// TODO Auto-generated method stub
		return ResultDao.countByName(studentNo);
	}

}