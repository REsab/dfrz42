package edu.school.ui.cli_v1.menu;

import java.util.Scanner;

public class Menu00 {

	// TODO Auto-generated method stub
	public void run() {
		showMainMenu();
	}

	public void showMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("**********************************");
		System.out.println("\n\t\t主菜单");
		System.out.println("**********************************");
		System.out.println("\t\t1.年级管理");
		System.out.println("\t\t2.科目管理");
		System.out.println("\t\t3.学生管理");
		System.out.println("\t\t4.成绩管理");
		System.out.println("\t\t5.退出");
		System.out.println("**********************************");

		showMainMenuExec();
	}

	private void showMainMenuExec() {
		// TODO Auto-generated method stub
		switch (choose()) {
		case "1":
			Menu01 menu01 = new Menu01();
			menu01.menu00 = this;
			menu01.run();
			showMainMenu();
			break;
		case "2":
			Menu02 menu02 = new Menu02();
			menu02.menu00 = this;
			menu02.run();
			showMainMenu();
			break;
		case "3":
			Menu03 menu03 = new Menu03();
			menu03.menu00 = this;
			menu03.run();
			showMainMenu();
			break;
		case "4":
			Menu04 menu04 = new Menu04();
			menu04.menu00 = this;
			menu04.run();
			showMainMenu();
			break;
		case "5":
			System.out.println("欢迎下次使用!");
			System.exit(0);
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
}
