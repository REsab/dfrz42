package stusysv6;
import java.util.List;
import java.util.Scanner;

public class ManagerCtrl {
	ManagerService managerService=new ManagerService();
	Scanner input=new Scanner(System.in);
	public boolean login() {
		System.out.print("请输入账号：");
		String userName=input.next();
		System.out.print("请输入密码：");
		String userPass=input.next();
		
		Manager manager=new Manager();
		manager.setUserName(userName);
		manager.setUserPass(userPass);
		
		boolean vIsOK = managerService.login(manager);
		if (vIsOK) {
			DataCenter.loginName = userName;
		}
		return vIsOK;
	}
	
	public void list() {
		List<Manager> arr = managerService.list();
		System.out.println("--------------------------------");
		System.out.println("-----当前列表如下");
		System.out.println("--------------------------------");
		System.out.println("\tid"+"\t账号"+"\t密码");
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) != null) {
				if (arr.get(i)!= null) {
					System.out.println(arr.get(i));
				}
				
			}
		}
	}
	
	public void insert() {
		System.out.println("--------------------------------");
		System.out.println("-----添加账号信息");
		System.out.println("--------------------------------");
		System.out.print("请输入id:");
		Integer id = input.nextInt();
		Integer exists = managerService.exists(id);
		if (exists != 0) {
			System.out.println("id存在，添加失败。");
			return;
		} 
		System.out.print("请输入账号:");
		String userName = input.next();
		System.out.print("请输入密码:");
		String userPass = input.next();
		Manager manager = new Manager();
		manager.setId(id);
		manager.setUserName(userName);
		manager.setUserPass(userPass);
		Integer result=managerService.insert(manager);
		if(result==1) {
			System.out.println("添加成功。");
		} else {
			System.out.println("添加失败。");
		}
	}	
	
	public void updata() {
		System.out.println("--------------------------------");
		System.out.println("-----修改账号信息");
		System.out.println("--------------------------------");
		System.out.print("请输入您要修改的id:");
		Integer id = input.nextInt();
		Integer exists = managerService.exists(id);
		if (exists == 0) {
			System.out.println("id不存在，修改失败。");
			return;
		} 
		System.out.print("请输入您要修改的账号:");
		String userName = input.next();
		System.out.print("请输入您要修改的密码:");
		String uesrPass = input.next();
		Manager manager = new Manager();
		manager.setId(id);
		manager.setUserName(userName);
		manager.setUserPass(uesrPass);
		Integer result=managerService.update(manager);
		if(result>0) {
			System.out.println("修改成功。");
		} else {
			System.out.println("修改失败。");
		}
	}
	
	public void delete() {
		System.out.println("--------------------------------");
		System.out.println("-----删除账号信息");
		System.out.println("--------------------------------");
		System.out.print("请输入您要删除的id:");
		Integer id = input.nextInt();
		Integer exists = managerService.exists(id);
		if (exists == 0) {
			System.out.println("id不存在，删除失败。");
			return;
		}
		Integer result=managerService.delete(id);
		if(result>0) {
			System.out.println("删除成功。");
		} else {
			System.out.println("删除失败。");
		}
	}
	
	public boolean updateLoginPass() {
		boolean vIsOK =false;
		System.out.println("-----准备修改当前登录用户【"+DataCenter.loginName+"】的密码-----");
		System.out.print("请输入旧密码:");
		String userPassOld =input.next();
		System.out.print("请输入新密码:");
		String userPassNew =input.next();
		System.out.print("请再次输入新密码:");
		String userPassNew2 =input.next();
		if(!userPassNew.equals(userPassNew2)) {
			System.out.print("两次输入的新密码不一致，修改失败。");
			return vIsOK;
		}
		Manager manager =new Manager();
		manager.setUserName(DataCenter.loginName);
		manager.setUserPass(userPassOld);
		if(!managerService.login(manager)) {
			System.out.print("旧密码不正确，修改失败。");
			return vIsOK;
		}
		Integer result =managerService.updatePass(DataCenter.loginName, userPassNew);
		if(result>0) {
			vIsOK =true;
			System.out.print("修改成功。");
		}
		return vIsOK;
	}
}
