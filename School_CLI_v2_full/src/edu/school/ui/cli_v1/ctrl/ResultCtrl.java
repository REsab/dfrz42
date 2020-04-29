package edu.school.ui.cli_v1.ctrl;

import java.util.List;
import java.util.Scanner;

import edu.school.bean.*;
import edu.school.server.*;
import edu.school.server.impl.*;

public class ResultCtrl {
	private ResultServer resultServer = new ResultServerImpl();
	Scanner input = new Scanner(System.in);

	public void list() {
		System.out.println("-----------------------------");
		System.out.println("--------当前成绩列表如下:");
		System.out.println("-----------------------------");
		List<Result> list = resultServer.list();

		System.out.print("\t");
		System.out.print("序号\t");
		System.out.print("id\t");
		System.out.print("学号\t");
		System.out.print("科目id\t");
		System.out.print("学生成绩\t");
		System.out.print("考试日期\t");
		System.out.println();

		int i = 0;
		for (Result bean : list) {
			System.out.print("\t");
			System.out.print((i + 1) + "\t");
			System.out.print(bean.getId() + "\t");
			System.out.print(bean.getStudentNo() + "\t");
			System.out.print(bean.getSubjectId() + "\t");
			System.out.print(bean.getStudentResult() + "\t");
			System.out.print(bean.getExamDate() + "\t");
			System.out.println();
			i++;
		}
	}

	public void search() {
		System.out.println("-----------------------------");
		System.out.println("--------搜索成绩id:");
		System.out.println("-----------------------------");

		System.out.print("请输入要搜索的年级Id:");
		Integer resultId = input.nextInt();

		Result bean = resultServer.load(resultId);

		if (bean == null) {
			System.out.println("不存在年级Id为[" + resultId + "]的记录.");
			return;
		}
		System.out.print("\t");
		System.out.print("序号\t");
		System.out.print("id\t");
		System.out.print("学号\t");
		System.out.print("科目id\t");
		System.out.print("学生成绩\t");
		System.out.print("考试日期\t");
		System.out.println();

		System.out.print("\t");
		System.out.print((1) + "\t");
		System.out.print(bean.getId() + "\t");
		System.out.print(bean.getStudentNo() + "\t");
		System.out.print(bean.getSubjectId() + "\t");
		System.out.print(bean.getStudentResult() + "\t");
		System.out.print(bean.getExamDate() + "\t");
		System.out.println();
	}

	public void insert() {
		System.out.println("-----------------------------");
		System.out.println("--------添加成绩信息");
		System.out.println("-----------------------------");
		System.out.print("请输入学号:");
		String StudentNo = input.next();
		System.out.print("请输入科目编号:");
		Integer SubjectId = input.nextInt();

		System.out.print("请输入学生成绩:");
		Integer StudentResult = input.nextInt();
		System.out.print("请输入考试时间:");
		String ExamDate = input.next();

		Result bean = new Result();
		bean.setStudentNo(StudentNo);
		bean.setSubjectId(SubjectId);
		bean.setStudentResult(StudentResult);
		bean.setExamDate(ExamDate);

		Integer result = resultServer.insert(bean);

		if (result > 0) {
			System.out.println("添加成功." + result);
		} else {
			System.out.println("添加失败.");
		}
	}

	public void delete() {
		System.out.println("-----------------------------");
		System.out.println("--------删除成绩信息");
		System.out.println("-----------------------------");
		System.out.print("请输入要删除的成绩Id:");
		Integer id = input.nextInt();

		Integer result = resultServer.delete(id);

		if (result > 0) {
			System.out.println("删除成功." + result);
		} else {
			System.out.println("删除失败.");
		}
	}

	public void update() {
		System.out.println("-----------------------------");
		System.out.println("--------修改成绩信息");
		System.out.println("-----------------------------");
		System.out.print("请输入要修改成绩id:");
		Integer id = input.nextInt();
		System.out.print("请输入学号");
		String StudentNo = input.next();

		System.out.print("请输入科目编号:");
		Integer SubjectId = input.nextInt();
		System.out.print("请输入学生成绩:");
		Integer StudentResult = input.nextInt();
		System.out.print("请输入考试时间:");
		String ExamDate = input.next();

		Result bean = new Result();
		bean.setId(id);
		bean.setStudentNo(StudentNo);
		bean.setSubjectId(SubjectId);
		bean.setStudentResult(StudentResult);
		bean.setExamDate(ExamDate);

		Integer result = resultServer.update(bean);

		if (result > 0) {
			System.out.println("修改成功.");
		} else {
			System.out.println("修改失败.");
		}
	}
}
