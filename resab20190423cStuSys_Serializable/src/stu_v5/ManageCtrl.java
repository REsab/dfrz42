package stu_v5;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.Scanner;

public class ManageCtrl {
    ManageService manageService = new ManageService();
    Scanner scanner = new Scanner(System.in);
    Manager manager = new Manager();

    public boolean login() {
        System.out.print("请输入账号:");
        String userName = scanner.next();
        System.out.print("请输入密码:");
        String userpwd = scanner.next();

        Manager manager = new Manager();
        manager.setUserName(userName);
        manager.setUserPass(userpwd);
        boolean isLogin = manageService.login(manager);
        if (isLogin) {
            DataCenter.loginName = userName;
        }     //记住登录用户
        return isLogin;

    }


    public void list() {
        Manager[] managers = manageService.list();
        System.out.println("--------------------------------------");
        System.out.println("-*-----------当前列表如下 ");
        System.out.println("--------------------------------------");
        System.out.print("\t");
        System.out.print("id\t");
        System.out.print("账号\t\t\t");
        System.out.print("密码\t");
        System.out.println("");
        for (int i = 0; i < managers.length; i++) {
            if (managers[i] != null) {

                System.out.println(managers[i].toString());
            } else {
                break;
            }

        }

    }

    public void insert() {
        System.out.println("输入要增加的管理员id");
        manager.setId(scanner.nextInt());


        if (manageService.exists(manager.getId()) == 1) {
            System.out.println("该学号已存在");
        } else {
            System.out.print("请输入管理员名称:");
            manager.setUserName(scanner.next());
            System.out.print("请输入密码:");
            manager.setUserPass(scanner.next());

            int result = manageService.insert(manager);
            if (result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败" + ",失败代码:" + result);
            }
        }


    }


    public void update() {

        System.out.println("输入id");
        manager.setId(scanner.nextInt());


        if (1 == manageService.exists(manager.getId())) {  //寻找是否有这个学号 的学生
            Integer index = manageService.searchIdIndex(manager.getId());  //有这个学生再找他的下标位置
            System.out.println("请输入 " + manager.getId() + "号的新名字");
            manager.setUserName(scanner.next());
            System.out.println("请输入 " + manager.getId() + "号的密码");
            manager.setUserPass(scanner.next());
            int result = manageService.update(manager);

            if (result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败" + ",失败代码:" + result);
            }

        } else {
            System.out.println("id不存在,修改失败");
            System.out.println();
        }
    }


    public void delete() {

        System.out.println("请输入要删除的号数");
        manager.setId(scanner.nextInt());

        int result = manageService.delete(manager.getId());

        if (result > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败" + ",失败代码:" + result);
        }


    }

    public boolean updatePass() {
        boolean result = false;

        System.out.println("正在修改" + DataCenter.loginName + "的密码");

        System.out.println("请输入旧密码");
        String oldPass = scanner.next();

        manager.setUserName(DataCenter.loginName);
        manager.setUserPass(oldPass);

        if (!manageService.login(manager)) {
            System.out.println("密码错误");
            return result;
        }
        System.out.println("请输入新密码");
        String newPass1 = scanner.next();
        System.out.println("请确认新密码");
        String newPass2 = scanner.next();
        if (!newPass1.equals(newPass2)) {
            System.out.println("两次密码不匹配");
            System.out.println("两次密码不匹配");

            System.out.println("两次密码不匹配");
            return result;
        }
        manageService.updatePass(DataCenter.loginName, newPass1);
        result = true;
        System.out.println("密码已更改,请记好");
        return result;

    }
}
