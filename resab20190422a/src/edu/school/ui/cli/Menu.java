package edu.school.ui.cli;

import edu.school.ui.clli.GradeCtrl;

import java.util.Scanner;

public class Menu {

    private GradeCtrl gradeCtrl = new GradeCtrl();

    public void run() {
        showGradeCrudMenu();
    }

    public static String choose() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择,输入数字: ");
        String string = scanner.next();
        return string;
    }

    public static String input() {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        return string;
    }

    private void showGradeCrudMenu() {
        System.out.println("***********************************************");

        System.out.println("\n\t\t年级管理菜单 ");
        System.out.println("***********************************************");
        System.out.println("\t\t1.显示年级列表");
        System.out.println("\t\t2.添加年级信息");
        System.out.println("\t\t3.修改年级信息");
        System.out.println("\t\t3.删除年级信息");
        System.out.println("\t\t");
        System.out.println("***********************************************");

        execGradeCrudMenu();

    }

    public void backGradeCrudMenu() {
        System.out.println("按任意键返回年级管理菜单 ");
        input();
        showGradeCrudMenu();
    }

    private void execGradeCrudMenu() {

        switch (choose()) {

            case "1":
                gradeCtrl.list();
                backGradeCrudMenu();
                break;
            case "2":
                gradeCtrl.insert();
                backGradeCrudMenu();
                break;
            case "3":
                gradeCtrl.update();
                backGradeCrudMenu();
                break;
            case "4":
                gradeCtrl.delete();
                backGradeCrudMenu();
                break;
            default:
                System.out.println("你输入的选择有误,请重新输入:");
                showGradeCrudMenu();
                break;


        }


    }


}
