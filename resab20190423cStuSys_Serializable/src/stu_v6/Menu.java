package stu_v6;
import java.util.Scanner;

public class Menu {
	Scanner input=new Scanner(System.in);
	StudentCtrl studentCtrl=new StudentCtrl();
	ManagerCtrl managerCtrl=new ManagerCtrl();
	public void run(){
		showLoginMenu();
	}
	public void back(){
		String answer = "";
		do{
			System.out.print("按0返回：");
			answer=input.next();
		} while (!answer.equals("0"));
		System.out.println();
	}
	public String choose(){
		System.out.print("请选择：");
		String num = input.next();
		return num;
	}
	
	public void showLoginMenu() {
		System.out.println("*******************************");
		System.out.println("\t欢迎使用学生管理系统");
		System.out.println("*******************************");
		System.out.println("\t1.登陆系统");
		System.out.println("\t2.退出");
		System.out.println("*******************************");
		
		showLoginMenu_choose();
	}
	public void showLoginMenu_choose() {
		switch(choose()) {
		case "1":
			if(managerCtrl.login()) {
				showMainMenu();
			}else {
				System.out.println("账密不正确！");
				showLoginMenu();
			}
			break;
		case "2":
			System.out.println("已退出，感谢您使用本系统！");
			System.exit(0);
			break;
		default:
			System.out.println("您输入有误,请重新输入：");
			back();
			showLoginMenu();
			break;
		}
	}
	public void showMainMenu() {
		System.out.println("*******************************");
		System.out.println("	主菜单");
		System.out.println("*******************************");
		System.out.println("	1.学生管理");
		System.out.println("	2.账号管理");
		System.out.println("	3.修改密码");
		System.out.println("	4.注销");
		System.out.println("*******************************");
		String num = choose();
		showMainMenuExec(num);
	}
	
	public void showMainMenuExec(String num) {
		switch(num) {
		case "0":
			showLoginMenu();
			break;
		case "1":
			showStudentMenu();
			break;
		case "2":
			showManagerMenu();
			break;
		case "3":
			managerCtrl.updateLoginPass();
			back();
			showMainMenu();
			break;
		case "4":
			DataCenter.loginName=null;
			showLoginMenu();
			break;
		default:
			System.out.println("您输入有误,请重新输入：");
			back();
			showMainMenu();
			break;
		}
	}
	
	public void showStudentMenu(){
		System.out.println("*******************************");
		System.out.println("               ");
		System.out.println("\t主菜单");
		System.out.println("*******************************");
		System.out.println("               ");
		System.out.println("\t1. 显示学生列表     ");
		System.out.println("\t2. 添加学生信息");
		System.out.println("\t3. 修改学生信息 ");
		System.out.println("\t4. 删除学生信息");
		System.out.println("*******************************");
		showStudentMenuExec();
	}

	public void showStudentMenuExec(){
		String num = choose();
		switch (num){
			case "0":
				showMainMenu();
				break;
			case "1":
				studentCtrl.list();
				back();
				showStudentMenu();
				break;
			case "2":
				studentCtrl.insert();
				back();
				showStudentMenu();
				break;
			case "3":
				studentCtrl.update();
				back();
				showStudentMenu();
				break;
			case "4":
				studentCtrl.delete();
				back();
				showStudentMenu();
				break;
			default:
				System.out.println("您输入有误,请重新输入：");
				back();
				showStudentMenu();
			    break;
		}
	}
	
	public void showManagerMenu() {
		System.out.println("*******************************");
		System.out.println("\t账号管理主菜单");
		System.out.println("*******************************");
		System.out.println("\t1.显示账号列表");
		System.out.println("\t2.添加账号信息");
		System.out.println("\t3.修改账号信息");
		System.out.println("\t4.删除账号信息");
		System.out.println("*******************************");
		String num = choose();
		showMangerMenuExec(num);
	}
	
	public void showMangerMenuExec(String num) {
		switch(num) {
			case "0":
				showMainMenu();
				break;
			case "1":
				managerCtrl.list();
				back();
				showManagerMenu();
				break;
			case "2":
				managerCtrl.insert();
				back();
				showManagerMenu();
				break;
			case "3":
				managerCtrl.updata();
				back();
				showManagerMenu();
				break;
			case "4":
				managerCtrl.delete();
				back();
				showManagerMenu();
			default:
				System.out.println("您输入有误,请重新输入：");
				showManagerMenu();
				break;
		}
	}
}

