package stu_v5;

import java.util.Date;

public class ManageDao {


    ManageDao() {

    }

    public boolean login(Manager manager) {
        boolean isLogin = false;

        for (int i = 0; i < DataCenter.managersArr.length; i++) {
            if (DataCenter.managersArr[i] == null) {
                break;  //如果没有管理者

            }
            //对比密码
            isLogin = manager.getUserName().equals(DataCenter.managersArr[i].getUserName()) &&
                    manager.getUserPass().equals(DataCenter.managersArr[i].getUserPass());
            if (isLogin) {  //找到对应的账号密码

                break;
            }
        }
        return isLogin;

    }


    public Integer insert(Manager manager) {
        Integer result = -1;
        for (int i = 0; i < DataCenter.managersArr.length; i++) {
            if (DataCenter.managersArr[i] == null) {
                DataCenter.managersArr[i] = manager;
                result = 1;
                break;

            }
        }
        return result;

    }

    public Manager[] list() {
        return DataCenter.managersArr;

    }

    public Integer update(Manager manager) {
        Integer result = -1;
        for (int i = 0; i < DataCenter.managersArr.length; i++) {
            if (DataCenter.managersArr[i] != null) {
                if (manager.getId() == DataCenter.managersArr[i].getId()) {
                    DataCenter.managersArr[i] = manager;
                    result = 1;
                    break;
                }
            } else {
                break;  //为空退出
            }
        }


        return result;

    }

    public Integer exists(Integer id) {
        Integer result = 0;
        Integer index = -1;
        for (int i = 0; i < DataCenter.managersArr.length; i++) {
            if (DataCenter.managersArr[i] != null) {
                if (DataCenter.managersArr[i].getId() == id) {
                    index = i;
                    break;
                }
            }
        }
        if (index > -1) {
            result = 1;
        }
        return result;

    }

    /**
     * 获取id对应的下标
     * 获取id对应的下标
     * 获取id对应的下标
     * 查找id对应下标searchId()： 传入id，获得其下标，不存是返回-1.
     */
    public Integer searchIdIndex(Integer id) {
        for (Integer i = 0; i < DataCenter.managersArr.length; i++) {
            if (DataCenter.managersArr[i] != null) {
                if (id.equals(DataCenter.managersArr[i].getId())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Integer delete(Integer id) {
        Integer result = 0;

        if (1 == exists(id)) {   //判断学号是否存在
            moveIndex(id);
            result = 1;
        } else {
            result = -1;
        }

        return result;

    }

    /* w
     删除id
        */
    private void moveIndex(int id) {

        if (id >= 0 && id < DataCenter.managersArr.length) {
            int last = -1;
            for (int i = 0; i < DataCenter.managersArr.length; i++) {
                if (DataCenter.managersArr[i + 1] == null) {

                    last = i;
                    break;
                }

                DataCenter.managersArr[i] = DataCenter.managersArr[i + 1];


            }
            if (last != -1) {

                DataCenter.managersArr[last] = null;
            }

        }


    }

    public Integer updatePass(String userName, String userPass) {

        Integer result = -11;
        for (int i = 0; i < DataCenter.managersArr.length; i++) {
            if (DataCenter.managersArr[i] != null) {
                if (DataCenter.managersArr[i].getUserName().equals(userName)) {
                    DataCenter.managersArr[i].setUserPass(userPass);
                    result = 1;
                    break;
                }
            }

        }

        return result;

    }

}



