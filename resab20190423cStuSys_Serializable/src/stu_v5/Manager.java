package stu_v5;

import java.io.Serializable;

public class Manager implements Serializable {
    private int id;
    private String userName;
    private String userPass;
    Manager() {
    }

    public String toString(){
        return  "\t"+id+"\t"+userName+"\t"+userPass;
    }

    Manager(int id, String userName, String userPass) {
        this.setId(id);
        this.setUserName(userName);
        this.setUserPass(userPass);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
