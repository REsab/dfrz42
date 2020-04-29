package stu_v5;

import java.util.Scanner;

/**
 * 控制器类StudentCtrl【相当于三层结构中的UI层的控制器】
 * 只有控制器类，才能出现输入输出。
 * 定义一个StudentService类型的属性，名称为studentService；
 * 控制器类的四个方法list()/insert()/update()/delete()都是无参无返回
 */

public class StudentCtrl {

    studentService studentService = new studentService();
    Student student = new Student();
    Scanner scanner = new Scanner(System.in);

    public void list() {

        System.out.println("当前学生信息 ");
        System.out.println("学号\t\t\t姓名\t\t\t性别");

        Student[] students = studentService.list();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i].toString());
            }
        }

    }

    public void insert() {
        System.out.println("输入要增加的学号");
        Student student = new Student();
        student.setId(scanner.nextInt());

        if (studentService.exists(student.getId()) == 1) {
            System.out.println("该学号已存在");
        } else {
            System.out.print("请输入姓名:");
            student.setName(scanner.next());
            System.out.print("请输入性别:");
            student.setSex(scanner.next());

            int result = studentService.insert(student);
            if (result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败" + ",失败代码:" + result);
            }
        }
    }

    public void update() {

        System.out.println("输入学号");
        student.setId(scanner.nextInt());


        if (1 == studentService.exists(student.getId())) {  //寻找是否有这个学号 的学生
            Integer index = studentService.searchIdIndex(student.getId());  //有这个学生再找他的下标位置
            System.out.println("请输入 " + student.getId() + "号的新名字");
            student.setName(scanner.next());
            System.out.println("请输入 " + student.getId() + "号的性别");
            student.setSex(scanner.next());
            int result = studentService.update(student);
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
        student.setId(scanner.nextInt());

        int result = studentService.delete(student.getId());

        if (result > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败" + ",失败代码:" + result);
        }


    }



}
