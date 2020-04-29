package stu_v6;
import java.util.List;
import java.util.Scanner;

public class StudentCtrl {
	StudentService studentService=new StudentService();
	Scanner input=new Scanner(System.in);
	public void list() {
		List<Student> arrStu=studentService.list();
		System.out.println("--------------------------------");
		System.out.println("-----当前学生列表如下");
		System.out.println("--------------------------------");
		System.out.println("\t学号"+"\t姓名"+"\t性别");
		for(Student stu:arrStu) {
			if (stu!=null) {
				System.out.println(stu);
			}
		}
	}
	public void insert() {
		System.out.println("--------------------------------");
		System.out.println("-----添加学生信息");
		System.out.println("--------------------------------");
		System.out.print("请输入您要添加的学号：");
		Integer id = input.nextInt();
		int index=studentService.exists(id);
		if(index==1){
			System.out.print("id已存在，添加失败。");
		}else{
			System.out.print("请输入您要添加的姓名：");
			String name = input.next();
			System.out.print("请输入您要添加的性别：");
			String sex = input.next();
			
			Student student=new Student();
			student.setId(id);
			student.setName(name);
			student.setSex(sex);
			Integer result=studentService.insert(student);
			if(result>0) {
				System.out.println("添加成功。");
			}else {
				System.out.println("添加失败。");
			}
			
		}	
	}
	public void update() {
		System.out.println("--------------------------------");
		System.out.println("-----修改学生信息");
		System.out.println("--------------------------------");
		System.out.print("请你输入要修改的学号：");
		Integer id=input.nextInt();
		int index=studentService.exists(id); 
		if(index==-1){
			System.out.print("id不存在，修改失败。");
			return;
		}
			System.out.print("请输入新的姓名：");
			String name=input.next();
			System.out.print("请输入新的性别：");
			String sex=input.next();
			Student student=new Student();
			student.setId(id);
			student.setName(name);
			student.setSex(sex);
			Integer result=studentService.update(student);
			if(result>0) {
				System.out.println("修改成功。");
			}else {
				System.out.println("修改失败。");
			}
	}
	public void delete() {
		System.out.println("--------------------------------");
		System.out.println("-----删除学生信息");
		System.out.println("--------------------------------");
		System.out.print("请你输入要删除的学号：");
		Integer id=input.nextInt();
		int index=studentService.exists(id);
		if(index==-1) {
			System.out.print("id不存在，删除失败。");
			return;
		}
		Integer result=studentService.delete(id);
		if(result>0) {
			System.out.println("删除成功。");
		}else {
			System.out.println("删除失败。");
		}
	}
}