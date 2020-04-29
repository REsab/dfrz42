package edu.school.ui.clli;

import edu.school.bean.Grade;
import edu.school.services.GradeService;
import edu.school.services.GradeServiceImlp;

import java.net.NoRouteToHostException;
import java.util.List;
import java.util.Scanner;

public class GradeCtrl {

    private GradeService gradeService = new GradeServiceImlp();
    Scanner input = new Scanner(System.in);

    public void insert() {
        System.out.println("------------------------------------------");
        System.out.println("--------添加年级信息  ----");
        System.out.println("------------------------------------------");

        System.out.print("请输入年级名称 :");
        String gradeName = input.nextLine();
        Grade bean = new Grade();
        bean.setGradeName(gradeName);

        Integer resutlt = gradeService.insert(bean);
        if (resutlt > 0) {
            System.out.println("添加成功" + resutlt);
        } else {
            System.out.println("添加失败");
        }


    }

    public void delete() {
        System.out.println("------------------------------------------");
        System.out.println("--------删除年级信息  ----");
        System.out.println("------------------------------------------");

        System.out.print("请输入要删除年级的id :");
        Integer id = input.nextInt();

        Integer resutlt = gradeService.delete(id);
        if (resutlt > 0) {
            System.out.println("删除成功.");
        } else {
            System.out.println("删除失败");
        }
    }

    public void update() {

        System.out.println("------------------------------------------");
        System.out.println("--------修改年级信息  ----");
        System.out.println("------------------------------------------");

        System.out.print("请输入要修改年级的id :");
        Integer gradeId = input.nextInt();

        System.out.print("请输入要修改年级的名称 :");
        String gradeNamme = input.next();

        Grade bean = new Grade();
        bean.setGradeName(gradeNamme);
        bean.setGradeId(gradeId);


        Integer resutlt = gradeService.update(bean);
        if (resutlt > 0) {
            System.out.println("修改成功.");
        } else {
            System.out.println("修改失败.");

        }


    }

    public void list() {

        System.out.println("------------------------------------------");
        System.out.println("--------当前年级列表如下  ----");
        System.out.println("------------------------------------------");

        List<Grade> list = gradeService.LIST();
        System.out.println("\t");
        System.out.print("序号\t");
        System.out.print("年级id\t");
        System.out.print("年级名称\t");
        System.out.println("");

        int i = 0;
        for (Grade bean :
                list) {
            System.out.println("\t");

            System.out.print(bean.getGradeId() + "\t");
            System.out.print(bean.getGradeName() + "\t");


        }
        System.out.println();
    }


}
