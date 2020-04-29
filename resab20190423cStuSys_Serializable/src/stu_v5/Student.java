package stu_v5;

import java.io.Serializable;

public class Student  implements Serializable {
    private static final long serialVersionUID = -5481283587086505912L;
    private Integer id;
    private String name;
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toString() {
        return "\t" + id + "\t" + "\t" + name + "\t\t\t" + sex;
    }
}
