package stu_v5;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    StudentCtrl StudentCtrl = new StudentCtrl();
    ManageCtrl manageCtrl = new ManageCtrl();

    public void run() {

        showLoginMenu();


    }

    //    * start 页面
    public void showLoginMenu() {

        System.out.println("*************************************");
        System.out.println("\n\t\t欢迎使用学生管理系统");
        System.out.println("*************************************");
        System.out.println("\t\t 1.登录");
        System.out.println("\t\t 2.退出");
        System.out.println("*************************************");
        showLoginMenu_choose();

    }

    // 主菜单
    public void showMainMenu() {
        aaaa:
        while (true) {
            System.out.println("*****************************************************");
            System.out.println("*****************************************************");
            System.out.println("\t\t\t主菜单");
            System.out.println("*****************************************************");
            System.out.println("\t\t\t1.学生管理");
            System.out.println("\t\t\t2.账号管理");
            System.out.println("\t\t\t3.修改密码");
            System.out.println("\t\t\t4.注销");
            System.out.println("*****************************************************");
            System.out.println("请输入:");
            String sel = scanner.next();

            switch (sel) {
                case "1":
                    showStuMainMenu();

                    break;

                case "2":
                    showManagerMainMenu();
                    break;

                case "3":
                    manageCtrl.updatePass();
                    break;

                case "4":
                    DataCenter.loginName = null;
                    System.out.println("bye");
                    showLoginMenu();
                    break aaaa;

                case "5":
                    break;
                default:
                    System.out.println("请重新选择");
                    break;


            }


        }
    }


    //学生菜单
    public void showStuMainMenu() {
        stu:
        while (true) {


            System.out.println("*****************************************************");
            System.out.println("*****************************************************");
            System.out.println("\t\t\t学生菜单");
            System.out.println("\t\t\t1显示姓名列表");
            System.out.println("\t\t\t2.添加姓名");
            System.out.println("\t\t\t3.修改姓名 ");
            System.out.println("\t\t\t4.删除姓名");
            System.out.println("\t\t\t5.退出");
            System.out.println("*****************************************************");
            System.out.println("请输入:");
            String sel = scanner.next();

            switch (sel) {
                case "1":
                    StudentCtrl.list();
                    goBack();
                    break;

                case "2":
                    StudentCtrl.insert();
                    break;

                case "3":
                    StudentCtrl.update();
                    break;

                case "4":
                    StudentCtrl.delete();

                    break;

                case "5":

                    break stu;
                default:
                    System.out.println("请重新选择");
                    break;


            }


        }
    }

    //  登录选择
    public void showLoginMenu_choose() {
        switch (choose()) {
            case 1:
                if (manageCtrl.login()) {
                    showMainMenu();  //进入学生菜单
                } else {
                    System.out.println("密码不正确.");
                    showLoginMenu();
                }
                break;
            case 2:
                DataCenter.writeAll();
                System.out.println("谢谢使用.");
                break;
            default:
                System.out.println("选择错误");
                break;

        }

    }

    //选择
    private int choose() {
        int choose = 232;

        if (scanner.hasNextInt()) {
            choose = scanner.nextInt();
        } else {
            System.out.println("输入有误");
        }
        return choose;

    }

    //返回
    public void goBack() {
        System.out.println("按任意键返回");

        String s = scanner.next();

    }


    //管理菜单
    private void showManagerMainMenu() {
        mana:
        while (true) {
            System.out.println("*****************************************************");
            System.out.println("*****************************************************");
            System.out.println("\t\t\t管理菜单");
            System.out.println("*****************************************************");
            System.out.println("\t\t\t1显示账号列表");
            System.out.println("\t\t\t2.添加账号");
            System.out.println("\t\t\t3.修改账号");
            System.out.println("\t\t\t4.删除账号");
            System.out.println("\t\t\t5.退出");
            System.out.println("*****************************************************");
            System.out.println("请输入:");
            String sel = scanner.next();

            switch (sel) {
                case "1":
                    manageCtrl.list();
                    goBack();

                    break;

                case "2":
                    manageCtrl.insert();
                    break;

                case "3":
                    manageCtrl.update();
                    break;

                case "4":
                    manageCtrl.delete();

                    break;

                case "5":
                    showMainMenu();
                    DataCenter.loginName = null;
                    break mana;
                default:
                    System.out.println("请重新选择");
                    break;


            }


        }
    }


}
