package stu_v5;

public class ManageService {
    ManageDao manageDao = new ManageDao();

    public boolean login(Manager manager) {
        return manageDao.login(manager);
    }

    public Integer delete(Integer id) {
        return manageDao.delete(id);
    }

    public Integer exists(Integer id) {
        return manageDao.exists(id);
    }

    public Integer insert(Manager manager) {
        return manageDao.insert(manager);
    }

    public Manager[] list() {
        return manageDao.list();
    }

    public Integer update(Manager manager) {
        return manageDao.update(manager);
    }

    public Integer searchIdIndex(int id) {
        return manageDao.searchIdIndex(id);
    }

    public Integer updatePass(String userName, String userPass) {
        return manageDao.updatePass(userName, userPass);

    }


}
