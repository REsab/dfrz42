package edu.school.ui.cli_v1;

import java.util.List;
import java.util.Scanner;

import edu.school.bean.*;
import edu.school.server.*;
import edu.school.server.impl.*;

public class StudentCtrl {
	private StudentServer studentServer = new StudentServerImpl();
	Scanner input = new Scanner(System.in);

	public void list() {
		System.out.println("-----------------------------");
		System.out.println("--------当前学生列表如下:");
		System.out.println("-----------------------------");
		List<Student> list = studentServer.list();

		System.out.print("\t");
		System.out.print("序号\t");
		System.out.print("学生Id\t");
		System.out.print("学号\t");
		System.out.print("密码\t");
		System.out.print("学生姓名\t");
		System.out.print("学生性别\t");
		System.out.print("年级编号\t");
		System.out.print("联系方式\t");
		System.out.print("地址\t");
		System.out.print("出生日期\t");
		System.out.print("邮箱\t");
		System.out.println();

		int i = 0;
		for (Student bean : list) {
			System.out.print("\t");
			System.out.print((i + 1) + "\t");
			System.out.print(bean.getStudentId() + "\t");
			System.out.print(bean.getStudentNo() + "\t");
			System.out.print(bean.getLoginPwd() + "\t");
			System.out.print(bean.getStudentName() + "\t");
			System.out.print(bean.getSex() + "\t");
			System.out.print(bean.getGradeId() + "\t");
			System.out.print(bean.getPhone() + "\t");
			System.out.print(bean.getAddress() + "\t");
			System.out.print(bean.getBronDate() + "\t");
			System.out.print(bean.getEmail() + "\t");
			System.out.println();
			i++;
		}
	}

	public void search() {
		System.out.println("-----------------------------");
		System.out.println("--------搜索学生学号:");
		System.out.println("-----------------------------");

		System.out.print("请输入要搜索的年级Id:");
		String studentNo = input.next();

		Student bean = studentServer.load(studentNo);

		if (bean == null) {
			System.out.println("不存在学号为[" + studentNo + "]的记录.");
			return;
		}

		System.out.print("\t");
		System.out.print("序号\t");
		System.out.print("学生Id\t");
		System.out.print("学号\t");
		System.out.print("密码\t");
		System.out.print("学生姓名\t");
		System.out.print("学生性别\t");
		System.out.print("年级编号\t");
		System.out.print("联系方式\t");
		System.out.print("地址\t");
		System.out.print("出生日期\t");
		System.out.print("邮箱\t");
		System.out.println();

		System.out.print("\t");
		System.out.print((1) + "\t");
		System.out.print(bean.getStudentId() + "\t");
		System.out.print(bean.getStudentNo() + "\t");
		System.out.print(bean.getLoginPwd() + "\t");
		System.out.print(bean.getStudentName() + "\t");
		System.out.print(bean.getSex() + "\t");
		System.out.print(bean.getGradeId() + "\t");
		System.out.print(bean.getPhone() + "\t");
		System.out.print(bean.getAddress() + "\t");
		System.out.print(bean.getBronDate() + "\t");
		System.out.print(bean.getEmail() + "\t");
		System.out.println();
	}

	public void insert() {
		System.out.println("-----------------------------");
		System.out.println("--------添加学生信息");
		System.out.println("-----------------------------");
		System.out.print("请输入学号:");
		String StudentNo = input.next();
		System.out.print("请输入密码:");
		String LoginPwd = input.next();
		System.out.print("请输入姓名:");
		String StudentName = input.next();

		System.out.print("请输入性别:");
		String Sex = input.next();
		System.out.print("请输入年级编号:");
		Integer GradeId = input.nextInt();

		System.out.print("请输入联系方式:");
		String Phone = input.next();
		System.out.print("请输入地址:");
		String Address = input.next();

		System.out.print("请输入出生日期:");
		String BronDate = input.next();
		System.out.print("请输入邮箱:");
		String Email = input.next();

		Student bean = new Student();
		bean.setStudentNo(StudentNo);
		bean.setLoginPwd(LoginPwd);
		bean.setStudentName(StudentName);
		bean.setSex(Sex);
		bean.setGradeId(GradeId);
		bean.setPhone(Phone);
		bean.setAddress(Address);
		bean.setBronDate(BronDate);
		bean.setEmail(Email);

		Integer result = studentServer.insert(bean);

		if (result > 0) {
			System.out.println("添加成功." + result);
		} else {
			System.out.println("添加失败.");
		}
	}

	public void delete() {
		System.out.println("-----------------------------");
		System.out.println("--------删除学生信息");
		System.out.println("-----------------------------");
		System.out.print("请输入要删除的学生账号:");
		String id = input.next();

		Integer result = studentServer.delete(id);

		if (result > 0) {
			System.out.println("删除成功." + result);
		} else {
			System.out.println("删除失败.");
		}
	}

	public void update() {
		System.out.println("-----------------------------");
		System.out.println("--------修改学生信息");
		System.out.println("-----------------------------");
		System.out.print("请输入要修改的学号:");
		String StudentNo = input.next();

		System.out.print("请输入密码:");
		String LoginPwd = input.next();
		System.out.print("请输入姓名:");
		String StudentName = input.next();

		System.out.print("请输入性别:");
		String Sex = input.next();
		System.out.print("请输入年级编号:");
		Integer GradeId = input.nextInt();

		System.out.print("请输入联系方式:");
		String Phone = input.next();
		System.out.print("请输入地址:");
		String Address = input.next();

		System.out.print("请输入出生日期:");
		String BronDate = input.next();
		System.out.print("请输入邮箱:");
		String Email = input.next();

		Student bean = new Student();
		bean.setStudentNo(StudentNo);
		bean.setLoginPwd(LoginPwd);
		bean.setStudentName(StudentName);
		bean.setSex(Sex);
		bean.setGradeId(GradeId);
		bean.setPhone(Phone);
		bean.setAddress(Address);
		bean.setBronDate(BronDate);
		bean.setEmail(Email);
		Integer result = studentServer.update(bean);

		if (result > 0) {
			System.out.println("修改成功.");
		} else {
			System.out.println("修改失败.");
		}
	}
}
