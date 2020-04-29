package stu_v6;

public class Student {
	private Integer id;
	private String name;
	private String sex;
	public Student() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}
	public String toString() {
		return "\t"+getId()+"	"+getName()+"	"+getSex();
	}
}
