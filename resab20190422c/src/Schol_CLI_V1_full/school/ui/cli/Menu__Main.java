package Schol_CLI_V1_full.school.ui.cli;

import Schol_CLI_V1_full.school.bean.StudentInfo;
import Schol_CLI_V1_full.school.util.DbPub;
import com.sun.source.tree.NewArrayTree;

public class Menu__Main {
private MenuGrade menuGrade=new MenuGrade();
private MenuResult menuResult=new MenuResult();
private  MenuSubject menuSubject =new MenuSubject();
private MenuStudentIfo menuStudentIfo=new MenuStudentIfo();

    public void run() {
        while (true) {
            showMainMenu();


        }


    }

    private  void showMainMenu() {

        System.out.println("***********************************************");

        System.out.println("\n\t\t主菜单 ");
        System.out.println("***********************************************");
        System.out.println("\t\t1.学科管理");
        System.out.println("\t\t2.科目管理");
        System.out.println("\t\t3.学生管理");
        System.out.println("\t\t4.成绩管理");
        System.out.println("\t\t");
        System.out.println("***********************************************");
        execSubjectCrudMenu();
        PubMenu.Back();


    }
    private  void execSubjectCrudMenu() {

        switch (PubMenu.choose()) {

            case "1":
                menuGrade.showMainMenu();
                PubMenu.Back();
                break;
            case "2":
              menuSubject.showSubjectCrudMenu();
                PubMenu.Back();
                break;
            case "3":
                System.out.println("学生正在开发");
                PubMenu.Back();
                break;
            case "4":
                menuResult.showSubjectCrudMenu();
                PubMenu.Back();
                break;
            default:
                System.out.println("你输入的选择有误,请重新输入:");
                showMainMenu();
                break;


        }


    }
}
