package stu_v6;

import java.util.List;

public class ManagerDao {
	public ManagerDao() {
		
	}
	public List<Manager> list() {
		return DataCenter.arrMgr;
	}
	private Integer getNewIndex() {
		int index=0;
		for(int i=0;i<DataCenter.arrMgr.size();i++) {
			if(DataCenter.arrMgr.get(i)==null) {
				index=i;
				break;
			}
		}
		return index;
	}
	
	public Integer insert(Manager manager) {
		Integer result=0;
		if(exists(manager.getId())!=1) {
			DataCenter.arrMgr.add(manager);
			result = 1;
		}
		return result;
	}
	
	public Integer exists(Integer id){
		Integer result=0,index=-1;
		for (Integer i=0;i<DataCenter.arrMgr.size();i++){
			if (DataCenter.arrMgr.get(i).getId()==id) {
				index = i;
				break;
			}
		}
		if (index>-1) {
			result = 1;
		}
		return result;
	}
	
	public Integer searchUserName(String userName) {
		int index=-1;
		for(int i=0;i<DataCenter.arrMgr.size();i++){	
			if(DataCenter.arrMgr.get(i)!=null&&DataCenter.arrMgr.get(i).getUserName()==userName){
				index=i;
				break;
			}
		}
		return index;
	}
	
	public Integer update(Manager manager) {
		Integer result=0;
		for (int i = 0; i < DataCenter.arrMgr.size(); i++) {
			if(DataCenter.arrMgr.get(i) !=null) {
				if (DataCenter.arrMgr.get(i).getId()==manager.getId()) {
					DataCenter.arrMgr.set(i, manager);
					result=1;
					break;
				}
			}
		}
		return result;
	}
	
	public Integer delete(Integer id) {
		Integer result=0;
		int index=-1;
		for (int i = 0; i < DataCenter.arrMgr.size(); i++) {
			if (DataCenter.arrMgr.get(i)!=null) {
				if (DataCenter.arrMgr.get(i).getId()==id) {
					index = i;
					break;
				}
			}
		}
		if(index>-1) {
			DataCenter.arrMgr.remove(DataCenter.arrMgr.get(index));
			result = 1;
		}
		return result;
	}
	
	public boolean login(Manager manager) {
		boolean isOk=false;
		for(int i=0;i<DataCenter.arrMgr.size();i++) {
			if(DataCenter.arrMgr.get(i)==null) {
				break;
			}
			//在数据中找到对应的账密，则登录成功，返回true
			isOk=manager.getUserName().equals(DataCenter.arrMgr.get(i).getUserName())
					&&manager.getUserPass().equals(DataCenter.arrMgr.get(i).getUserPass());
			if(isOk) {
				break;
			}
		}
		return isOk;
	}
	
	public Integer updatePass(String userName, String userPass) {
		Integer result = 0;
		for (int i = 0; i < DataCenter.arrMgr.size(); i++) {
			if (DataCenter.arrMgr.get(i) != null) {
				if (DataCenter.arrMgr.get(i).getUserName().equals(userName)) {
					DataCenter.arrMgr.get(i).setUserPass(userPass);
					result = 1;
					break;
				}
			}
		}
		return result;
	}
}
