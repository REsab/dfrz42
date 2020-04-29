package Schol_CLI_V1_full.school.ui.cli;

import Schol_CLI_V1_full.school.ui.clli.SubjectCtrl;

public class MenuSubject {
    private SubjectCtrl SubjectCtrl = new SubjectCtrl();

    public void run() {
        showSubjectCrudMenu();
    }




    public void showSubjectCrudMenu() {
        System.out.println("***********************************************");

        System.out.println("\n\t\t学科管理菜单 ");
        System.out.println("***********************************************");
        System.out.println("\t\t1.显示学科列表");
        System.out.println("\t\t2.添加学科信息");
        System.out.println("\t\t3.修改学科信息");
        System.out.println("\t\t3.删除学科信息");
        System.out.println("\t\t");
        System.out.println("***********************************************");

        execSubjectCrudMenu();

    }

    public void backSubjectCrudMenu() {
        System.out.println("按任意键返回学科管理菜单 ");
        PubMenu.input();
        showSubjectCrudMenu();
    }

    private void execSubjectCrudMenu() {

        switch (PubMenu.choose()) {

            case "1":
                SubjectCtrl.list();
                backSubjectCrudMenu();
                break;
            case "2":
                SubjectCtrl.insert();
                backSubjectCrudMenu();
                break;
            case "3":
                SubjectCtrl.update();
                backSubjectCrudMenu();
                break;
            case "4":
                SubjectCtrl.delete();
                backSubjectCrudMenu();
                break;
            default:
                System.out.println("你输入的选择有误,请重新输入:");
                showSubjectCrudMenu();
                break;


        }


    }
    
    
}
