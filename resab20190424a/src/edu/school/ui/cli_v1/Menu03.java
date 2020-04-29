package edu.school.ui.cli_v1;

import java.util.Scanner;

public class Menu03 {

	private StudentCtrl StudentCtrl = new StudentCtrl();
	public Menu00 menu00 = null;

	public void run() {
		showStudentCurdMenu();
	}

	private void showStudentCurdMenu() {
		// TODO Auto-generated method stub
		System.out.println("**********************************");
		System.out.println("\n\t\t学生管理菜单");
		System.out.println("**********************************");
		System.out.println("\t\t1.显示学生列表");
		System.out.println("\t\t2.添加学生信息");
		System.out.println("\t\t3.修改学生信息");
		System.out.println("\t\t4.删除学生信息");
		System.out.println("\t\t5.搜索学生信息");
		System.out.println("\t\t6.返回主菜单");
		System.out.println("**********************************");
		execStudentCurdMenu();
	}

	private void execStudentCurdMenu() {
		// TODO Auto-generated method stub
		switch (choose()) {
		case "1":
			StudentCtrl.list();
			showStudentCurdMenu();
			break;
		case "2":
			StudentCtrl.insert();
			StudentCtrl.list();
			backStudentCurdMenu();
			break;
		case "3":
			StudentCtrl.update();
			StudentCtrl.list();
			backStudentCurdMenu();
			break;
		case "4":
			StudentCtrl.delete();
			StudentCtrl.list();
			backStudentCurdMenu();
			break;
		case "5":
			StudentCtrl.search();
			backStudentCurdMenu();
			break;
		case "6":
			menu00.showMainMenu();
			break;
		default:
			break;
		}
	}

	public static String choose() {
		Scanner sc = new Scanner(System.in);
		System.out.print("请选择,输入数字:");
		String chose = sc.next();
		return chose;
	}

	public static String input() {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		return str;

	}

	public void backStudentCurdMenu() {
		System.out.print("按任意键,返回学生管理菜单:");
		Scanner sc = new Scanner(System.in);
		String anwser = sc.next();
		showStudentCurdMenu();
	}
}
