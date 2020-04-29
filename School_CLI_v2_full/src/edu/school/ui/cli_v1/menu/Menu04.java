package edu.school.ui.cli_v1.menu;

import edu.school.ui.cli_v1.ctrl.ResultCtrl;

import java.util.Scanner;

public class Menu04 {

	private edu.school.ui.cli_v1.ctrl.ResultCtrl ResultCtrl = new ResultCtrl();
	public Menu00 menu00 = null;
	public void run() {
		showResultCurdMenu();
	}

	private void showResultCurdMenu() {
		// TODO Auto-generated method stub
		System.out.println("**********************************");
		System.out.println("\n\t\t成绩管理菜单");
		System.out.println("**********************************");
		System.out.println("\t\t1.显示成绩列表");
		System.out.println("\t\t2.添加成绩信息");
		System.out.println("\t\t3.修改成绩信息");
		System.out.println("\t\t4.删除成绩信息");
		System.out.println("\t\t5.搜索成绩信息");
		System.out.println("\t\t6.返回主菜单");
		System.out.println("**********************************");
		execResultCurdMenu();
	}

	private void execResultCurdMenu() {
		// TODO Auto-generated method stub
		switch (choose()) {
		case "1":
			ResultCtrl.list();
			showResultCurdMenu();
			break;
		case "2":
			ResultCtrl.insert();
			ResultCtrl.list();
			backResultCurdMenu();
			break;
		case "3":
			ResultCtrl.update();
			ResultCtrl.list();
			backResultCurdMenu();
			break;
		case "4":
			ResultCtrl.delete();
			ResultCtrl.list();
			backResultCurdMenu();
			break;
		case "5":
			ResultCtrl.search();
			backResultCurdMenu();
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

	public void backResultCurdMenu() {
		System.out.print("按任意键,返回成绩管理菜单:");
		Scanner sc = new Scanner(System.in);
		String anwser = sc.next();
		showResultCurdMenu();
	}
}
