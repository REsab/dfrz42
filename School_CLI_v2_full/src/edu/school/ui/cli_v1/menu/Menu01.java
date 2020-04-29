package edu.school.ui.cli_v1.menu;

import edu.school.ui.cli_v1.ctrl.GradeCtrl;

import java.util.Scanner;

public class Menu01 {

	private GradeCtrl gradeCtrl = new GradeCtrl();
	public Menu00 menu00 = null;

	public void run() {
		showGradeCurdMenu();
	}

	private void showGradeCurdMenu() {
		// TODO Auto-generated method stub
		System.out.println("**********************************");
		System.out.println("\n\t\t年级管理菜单");
		System.out.println("**********************************");
		System.out.println("\t\t1.显示年级列表");
		System.out.println("\t\t2.添加年级信息");
		System.out.println("\t\t3.修改年级信息");
		System.out.println("\t\t4.删除年级信息");
		System.out.println("\t\t5.搜索年级信息");
		System.out.println("\t\t6.返回主菜单");
		System.out.println("**********************************");
		execGradeCurdMenu();
	}

	private void execGradeCurdMenu() {
		// TODO Auto-generated method stub
		switch (choose()) {
		case "1":
			gradeCtrl.list();
			showGradeCurdMenu();
			break;
		case "2":
			gradeCtrl.insert();
			gradeCtrl.list();
			backGradeCurdMenu();
			break;
		case "3":
			gradeCtrl.update();
			gradeCtrl.list();
			backGradeCurdMenu();
			break;
		case "4":
			gradeCtrl.delete();
			gradeCtrl.list();
			backGradeCurdMenu();
			break;
		case "5":
			gradeCtrl.search();
			backGradeCurdMenu();
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

	public void backGradeCurdMenu() {
		System.out.print("按任意键,返回年级管理菜单:");
		Scanner sc = new Scanner(System.in);
		String anwser = sc.next();
		showGradeCurdMenu();
	}
}
