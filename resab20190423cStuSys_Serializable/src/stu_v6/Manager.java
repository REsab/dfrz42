package stu_v6;

public class Manager {
	private Integer id;
	private String userName;
	private String userPass;
	public Manager(){
		
	}
	public Manager(Integer id,String userName,String userPass) {
		setId(id);
		setUserName(userName);
		setUserPass(userPass);
	}
	public Integer getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public void setUserPass(String userPass) {
		this.userPass=userPass;
	}
	public String toString() {
		return "\t"+id+"\t"+userName+"\t"+userPass;
	}
}
