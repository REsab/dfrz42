package edu.school.ui.cli_v1.ctrl;

import java.util.List;
import java.util.Scanner;

import edu.school.bean.*;
import edu.school.server.*;
import edu.school.server.impl.*;

public class GradeCtrl {
	private GradeServer gradeServer = new GradeServerImpl();
	Scanner input = new Scanner(System.in);

	public void list() {
		System.out.println("-----------------------------");
		System.out.println("--------当前年级列表如下:");
		System.out.println("-----------------------------");
		List<Grade> list = gradeServer.list();

		System.out.print("\t");
		System.out.print("序号\t");
		System.out.print("年级Id\t");
		System.out.print("年级名称\t");
		System.out.println();

		int i = 0;
		for (Grade bean : list) {
			System.out.print("\t");
			System.out.print((i + 1) + "\t");
			System.out.print(bean.getGradeId() + "\t");
			System.out.print(bean.getGradeName() + "\t");
			System.out.println();
			i++;
		}
	}

	public void search() {
		System.out.println("-----------------------------");
		System.out.println("--------搜索年级Id:");
		System.out.println("-----------------------------");

		System.out.print("请输入要搜索的年级Id:");
		Integer gradeId = input.nextInt();

		Grade bean = gradeServer.load(gradeId);

		if (bean == null) {
			System.out.println("不存在年级Id为[" + gradeId + "]的记录.");
			return;
		}
		System.out.print("\t");
		System.out.print("序号\t");
		System.out.print("年级Id\t");
		System.out.print("年级名称\t");
		System.out.println();

		System.out.print("\t");
		System.out.print((1) + "\t");
		System.out.print(bean.getGradeId() + "\t");
		System.out.print(bean.getGradeName() + "\t");
		System.out.println();
	}

	public void insert() {
		System.out.println("-----------------------------");
		System.out.println("--------添加年级信息");
		System.out.println("-----------------------------");
		System.out.print("请输入年级名称:");
		String gradeName = input.next();

		Grade bean = new Grade();
		bean.setGradeName(gradeName);
		Integer result = gradeServer.insert(bean);

		if (result > 0) {
			System.out.println("添加成功." + result);
		} else {
			System.out.println("添加失败.");
		}
	}

	public void delete() {
		System.out.println("-----------------------------");
		System.out.println("--------删除年级信息");
		System.out.println("-----------------------------");
		System.out.print("请输入要删除的年级Id:");
		Integer id = input.nextInt();

		Integer result = gradeServer.delete(id);

		if (result > 0) {
			System.out.println("删除成功." + result);
		} else {
			System.out.println("删除失败.");
		}
	}

	public void update() {
		System.out.println("-----------------------------");
		System.out.println("--------修改年级信息");
		System.out.println("-----------------------------");
		System.out.print("请输入要修改的年级Id:");
		Integer id = input.nextInt();
		System.out.print("请输入新的年级名称:");
		String gradeName = input.next();

		Grade bean = new Grade();
		bean.setGradeName(gradeName);
		bean.setGradeId(id);

		Integer result = gradeServer.update(bean);

		if (result > 0) {
			System.out.println("修改成功.");
		} else {
			System.out.println("修改失败.");
		}
	}
}
