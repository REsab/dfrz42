package edu.school.ui.cli_v1.menu;

import edu.school.ui.cli_v1.ctrl.SubjectCtrl;

import java.util.Scanner;

public class Menu02 {

	private edu.school.ui.cli_v1.ctrl.SubjectCtrl SubjectCtrl = new SubjectCtrl();
	public Menu00 menu00 = null;
	public void run() {
		showSubjectCurdMenu();
	}

	private void showSubjectCurdMenu() {
		// TODO Auto-generated method stub
		System.out.println("**********************************");
		System.out.println("\n\t\t科目管理菜单");
		System.out.println("**********************************");
		System.out.println("\t\t1.显示科目列表");
		System.out.println("\t\t2.添加科目信息");
		System.out.println("\t\t3.修改科目信息");
		System.out.println("\t\t4.删除科目信息");
		System.out.println("\t\t5.搜索科目信息");
		System.out.println("\t\t6.返回主菜单");
		System.out.println("**********************************");
		execSubjectCurdMenu();
	}

	private void execSubjectCurdMenu() {
		// TODO Auto-generated method stub
		switch (choose()) {
		case "1":
			SubjectCtrl.list();
			showSubjectCurdMenu();
			break;
		case "2":
			SubjectCtrl.insert();
			SubjectCtrl.list();
			backSubjectCurdMenu();
			break;
		case "3":
			SubjectCtrl.update();
			SubjectCtrl.list();
			backSubjectCurdMenu();
			break;
		case "4":
			SubjectCtrl.delete();
			SubjectCtrl.list();
			backSubjectCurdMenu();
			break;
		case "5":
			SubjectCtrl.search();
			backSubjectCurdMenu();
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

	public void backSubjectCurdMenu() {
		System.out.print("按任意键,返回科目管理菜单:");
		Scanner sc = new Scanner(System.in);
		String anwser = sc.next();
		showSubjectCurdMenu();
	}
}
