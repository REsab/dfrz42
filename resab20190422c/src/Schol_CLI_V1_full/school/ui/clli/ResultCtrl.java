package Schol_CLI_V1_full.school.ui.clli;

import Schol_CLI_V1_full.school.bean.Result;
import Schol_CLI_V1_full.school.services.ResultService;
import Schol_CLI_V1_full.school.services.ResultServiceImlp;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;

public class ResultCtrl {
    private ResultService ResultService = new ResultServiceImlp();
    Scanner input = new Scanner(System.in);

    public void insert() {


    }

    public void delete() {
        System.out.println("------------------------------------------");
        System.out.println("--------删除成绩信息  ----");
        System.out.println("------------------------------------------");

        System.out.print("请输入要删除成绩的id :");
        Integer id = input.nextInt();

        Integer resutlt = ResultService.delete(id);
        if (resutlt > 0) {
            System.out.println("删除成绩.");
        } else {
            System.out.println("删除失败");
        }
    }

    public void update() {

        System.out.println("------------------------------------------");
        System.out.println("--------修改成绩信息  ----");
        System.out.println("------------------------------------------");

        System.out.print("请输入要修改成绩的id :");
        Integer subjectId = input.nextInt();

        System.out.print("请输入要修改成绩的分数 :");
        Integer subjectResult = input.nextInt();
        System.out.print("请输入要修改成绩的考试时间 :");

        String date = input.next();
        Result bean = new Result();

        bean.setSubjectId(subjectId);
        bean.setStudentResult(subjectResult);
        bean.setExamdate(date);


        Integer resutlt = ResultService.update(bean);
        if (resutlt > 0) {
            System.out.println("修改成绩.");
        } else {
            System.out.println("修改失败.");

        }


    }

    public void list() {

        System.out.println("------------------------------------------");
        System.out.println("--------当前成绩列表如下  ----");
        System.out.println("------------------------------------------");

        List<Result> list = ResultService.GRADE_LIST();
        System.out.println("\t");
        System.out.print("序号\t");
        System.out.print("学生姓名\t");
        System.out.print("成绩id\t");
        System.out.print("成绩\t");
        System.out.print("考试时间\t");
        System.out.println("");

        int i = 0;
        for (Result bean :
                list) {
            System.out.println("\t");
            System.out.print(bean.getId() + "\t");
            System.out.print(bean.getStudentNo() + "\t");
            System.out.print(bean.getSubjectId() + "\t");
            System.out.print(bean.getExamdate() + "\t");
            System.out.print(bean.getExamdate() + "\t");
        }
        System.out.println();
    }


}
