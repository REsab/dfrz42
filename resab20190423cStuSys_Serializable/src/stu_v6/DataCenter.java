package stu_v6;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
	public static String loginName=null;
	public static List<Student> arrStu=new ArrayList<Student>();
	public static List<Manager> arrMgr=new ArrayList<Manager>();
	static{
		initData();
	}
	public static void initData(){
		Student stu = null;
		stu = new Student();
		stu.setId(1);
		stu.setName("张三");
		stu.setSex("男");
		arrStu.add(stu);
		stu = new Student();
		stu.setId(2);
		stu.setName("李四");
		stu.setSex("女");
		arrStu.add(stu);
		stu=new Student();
		stu.setId(3);
		stu.setName("王五");
		stu.setSex("男");
		arrMgr.add(new Manager(1,"admin","123"));
		arrMgr.add(new Manager(2,"user","123"));
		arrMgr.add(new Manager(3,"guest","123"));
	}
}
