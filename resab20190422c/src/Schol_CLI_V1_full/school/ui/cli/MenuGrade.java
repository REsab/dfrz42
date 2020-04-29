package Schol_CLI_V1_full.school.ui.cli;


import Schol_CLI_V1_full.school.ui.clli.GradeCtrl;

import java.util.Scanner;

public class MenuGrade {

    private GradeCtrl gradeCtrl = new GradeCtrl();

    public void run() {
        showGradeCrudMenu();
    }


    public void showMainMenu() {

        System.out.println("***********************************************");

        System.out.println("\n\t\t主菜单 ");
        System.out.println("***********************************************");
        System.out.println("\t\t1.年级管理");
        System.out.println("\t\t2.科目管理");
        System.out.println("\t\t3.学生管理");
        System.out.println("\t\t4.成绩管理");
        System.out.println("\t\t");
        System.out.println("***********************************************");

        execGradeCrudMenu();


    }

    private void showGradeCrudMenu() {
        System.out.println("***********************************************");

        System.out.println("\n\t\t年级管理菜单 ");
        System.out.println("***********************************************");
        System.out.println("\t\t1.显示年级列表");
        System.out.println("\t\t2.添加年级信息");
        System.out.println("\t\t3.修改年级信息");
        System.out.println("\t\t4.删除年级信息");
        System.out.println("\t\t");
        System.out.println("***********************************************");

        execGradeCrudMenu();

    }

    public void backGradeCrudMenu() {
        System.out.println("按任意键返回年级管理菜单 ");
     PubMenu.input();
        showGradeCrudMenu();
    }

    private void execGradeCrudMenu() {

        switch (PubMenu.choose()) {

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
