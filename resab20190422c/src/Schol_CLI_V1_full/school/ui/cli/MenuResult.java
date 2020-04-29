package Schol_CLI_V1_full.school.ui.cli;

import Schol_CLI_V1_full.school.ui.clli.ResultCtrl;

public class MenuResult {

    private ResultCtrl resultCtrl = new ResultCtrl();

    public void run() {
        showSubjectCrudMenu();
    }



    public void showSubjectCrudMenu() {
        System.out.println("***********************************************");

        System.out.println("\n\t\t成绩管理菜单 ");
        System.out.println("***********************************************");
        System.out.println("\t\t1.显示成绩列表");
        System.out.println("\t\t2.添加成绩信息");
        System.out.println("\t\t3.修改成绩信息");
        System.out.println("\t\t3.删除成绩信息");
        System.out.println("\t\t");
        System.out.println("***********************************************");

        execSubjectCrudMenu();

    }

    public void backSubjectCrudMenu() {
        System.out.println("按任意键返回成绩管理菜单 ");
        PubMenu.input();
        showSubjectCrudMenu();
    }

    private void execSubjectCrudMenu() {

        switch (PubMenu.choose()) {

            case "1":
                resultCtrl.list();
                        backSubjectCrudMenu();
                break;
            case "2":
                resultCtrl.insert();
                backSubjectCrudMenu();
                break;
            case "3":
                resultCtrl.update();
                backSubjectCrudMenu();
                break;
            case "4":
                resultCtrl.delete();
                backSubjectCrudMenu();
                break;
            default:
                System.out.println("你输入的选择有误,请重新输入:");
                showSubjectCrudMenu();
                break;


        }


    }


}
