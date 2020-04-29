package edu.school.ui.cli_v1.ctrl;

import java.util.List;
import java.util.Scanner;

import edu.school.bean.*;
import edu.school.server.*;
import edu.school.server.impl.*;

public class SubjectCtrl {
	private SubjectServer subjectServer = new SubjectServerImpl();
	Scanner input = new Scanner(System.in);

	public void list() {
		System.out.println("-----------------------------");
		System.out.println("--------当前科目列表如下:");
		System.out.println("-----------------------------");
		List<Subject> list = subjectServer.list();

		System.out.print("\t");
		System.out.print("序号\t");
		System.out.print("科目Id\t");
		System.out.print("科目名称\t");
		System.out.print("课时\t");
		System.out.print("年级Id\t");
		System.out.println();

		int i = 0;
		for (Subject bean : list) {
			System.out.print("\t");
			System.out.print((i + 1) + "\t");
			System.out.print(bean.getSubjectId() + "\t");
			System.out.print(bean.getSubjectName() + "\t");
			System.out.print(bean.getClassHour() + "\t");
			System.out.print(bean.getGradeId() + "\t");
			System.out.println();
			i++;
		}
	}

	public void search() {
		System.out.println("-----------------------------");
		System.out.println("--------搜索科目编号:");
		System.out.println("-----------------------------");

		System.out.print("请输入要搜索的年级Id:");
		Integer subjectId = input.nextInt();

		Subject bean = subjectServer.load(subjectId);
		
		if (bean == null) {
			System.out.println("不存在科目编号为[" + subjectId + "]的记录.");
			return;
		}

		System.out.print("\t");
		System.out.print("序号\t");
		System.out.print("科目Id\t");
		System.out.print("科目名称\t");
		System.out.print("课时\t");
		System.out.print("年级Id\t");
		System.out.println();

		System.out.print("\t");
		System.out.print((1) + "\t");
		System.out.print(bean.getSubjectId() + "\t");
		System.out.print(bean.getSubjectName() + "\t");
		System.out.print(bean.getClassHour() + "\t");
		System.out.print(bean.getGradeId() + "\t");
		System.out.println();
	}

	public void insert() {
		System.out.println("-----------------------------");
		System.out.println("--------添加科目信息");
		System.out.println("-----------------------------");
		System.out.print("请输入科目名称:");
		String SubjectName = input.next();
		System.out.print("请输入课时:");
		Integer ClassHour = input.nextInt();
		System.out.print("请输入年级Id:");
		Integer GradeId = input.nextInt();
		Subject bean = new Subject();
		bean.setSubjectName(SubjectName);
		bean.setClassHour(ClassHour);
		bean.setGradeId(GradeId);
		Integer result = subjectServer.insert(bean);

		if (result > 0) {
			System.out.println("添加成功." + result);
		} else {
			System.out.println("添加失败.");
		}
	}

	public void delete() {
		System.out.println("-----------------------------");
		System.out.println("--------删除科目信息");
		System.out.println("-----------------------------");
		System.out.print("请输入要删除的科目Id:");
		Integer id = input.nextInt();

		Integer result = subjectServer.delete(id);

		if (result > 0) {
			System.out.println("删除成功." + result);
		} else {
			System.out.println("删除失败.");
		}
	}

	public void update() {
		System.out.println("-----------------------------");
		System.out.println("--------修改科目信息");
		System.out.println("-----------------------------");
		System.out.print("请输入要修改的科目Id:");
		Integer id = input.nextInt();
		System.out.print("请输入新的科目名称:");
		String SubjectName = input.next();
		System.out.print("请输入课时:");
		Integer ClassHour = input.nextInt();
		System.out.print("请输入年级Id:");
		Integer GradeId = input.nextInt();
		Subject bean = new Subject();
		bean.setSubjectName(SubjectName);
		bean.setClassHour(ClassHour);
		bean.setGradeId(GradeId);
		bean.setSubjectId(id);
		Integer result = subjectServer.update(bean);

		if (result > 0) {
			System.out.println("修改成功.");
		} else {
			System.out.println("修改失败.");
		}
	}
}
