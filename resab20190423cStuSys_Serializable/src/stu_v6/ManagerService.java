package stu_v6;

import java.util.List;

public class ManagerService {
	ManagerDao managerDao=new ManagerDao();
	public List<Manager> list() {
		return managerDao.list();
	}
	public Integer insert(Manager manager) {
		return managerDao.insert(manager);
	}
	
	public Integer exists(Integer id){
		return managerDao.exists(id);
	}
	
	public Integer searchUserName(String userName) {
		return managerDao.searchUserName(userName);
	}
	
	public Integer update(Manager manager) {
		return managerDao.update(manager);
	}
	
	public Integer delete(Integer id) {
		return managerDao.delete(id);
	}
	
	public boolean login(Manager manager) {
		return managerDao.login(manager);
	}
	
	public Integer updatePass(String userName, String userPass) {
		return managerDao.updatePass(userName, userPass);
	}
}
