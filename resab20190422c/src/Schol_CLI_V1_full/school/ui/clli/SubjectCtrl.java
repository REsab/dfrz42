package Schol_CLI_V1_full.school.ui.clli;

import Schol_CLI_V1_full.school.bean.Subject;
import Schol_CLI_V1_full.school.services.SubjectService;
import Schol_CLI_V1_full.school.services.SubjectServiceImlp;

import java.util.List;
import java.util.Scanner;

public class SubjectCtrl {


    private SubjectService SubjectService = new SubjectServiceImlp();
    Scanner input = new Scanner(System.in);

    public void insert() {
        System.out.println("------------------------------------------");
        System.out.println("--------添加学科信息  ----");
        System.out.println("------------------------------------------");

        System.out.print("请输入学科名称 :");
        String SubjectName = input.nextLine();
        System.out.print("请输入学科学时 :");
        Integer classHour = input.nextInt();
        System.out.print("请输入学科班级的id :");
        Integer gradeid = input.nextInt();


        Subject bean = new Subject();
        bean.setGradeId(gradeid);
        bean.setClassHour(classHour);
        bean.setSubjectName(SubjectName);

        Integer resutlt = SubjectService.insert(bean);
        if (resutlt > 0) {
            System.out.println("添加成功" + resutlt);
        } else {
            System.out.println("添加失败");
        }


    }

    public void delete() {
        System.out.println("------------------------------------------");
        System.out.println("--------删除学科信息  ----");
        System.out.println("------------------------------------------");

        System.out.print("请输入要删除学科的id :");
        Integer id = input.nextInt();

        Integer resutlt = SubjectService.delete(id);
        if (resutlt > 0) {
            System.out.println("删除成功.");
        } else {
            System.out.println("删除失败");
        }
    }

    public void update() {

        System.out.println("------------------------------------------");
        System.out.println("--------修改学科信息  ----");
        System.out.println("------------------------------------------");

        System.out.print("请输入要修改学科的id :");
        Integer SubjectId = input.nextInt();

        System.out.print("请输入要修改学科的名称 :");
        String SubjectNamme = input.next();

        System.out.print("请输入要修改学科的学时 :");
        Integer classHour = input.nextInt();

        System.out.print("请输入要修改学科的班级id :");
        Integer gradeId = input.nextInt();


        Subject bean = new Subject();
        bean.setClassHour(classHour);
        bean.setGradeId(gradeId);
        bean.setSubjectName(SubjectNamme);
        bean.setSubjetId(SubjectId);

        Integer resutlt = SubjectService.update(bean);
        if (resutlt > 0) {
            System.out.println("修改成功.");
        } else {
            System.out.println("修改失败.");

        }


    }

    public void list() {

        System.out.println("------------------------------------------");
        System.out.println("--------当前学科列表如下  ----");
        System.out.println("------------------------------------------");

        List<Subject> list = SubjectService.Subject_LIST();
        System.out.println("\t");
        System.out.print("学科id\t");
        System.out.print("学科名称\t");
        System.out.print("学科学时\t");
        System.out.print("学科班级id\t");
        System.out.println("");

        int i = 0;
        for (Subject bean :
                list) {
            System.out.println("\t");

            System.out.print(bean.getSubjetId() + "\t");
            System.out.print(bean.getSubjectName() + "\t");
            System.out.println(bean.getClassHour() + "\t");
            System.out.println(bean.getGradeId() + "\t");

        }
        System.out.println();
    }


}
