package chb06.lx.mytest.q1;

public class Penguin {

    private String name;
    private int heath;
    private int love;

    private String sex;
    static final String SEX_MALE = "Q仔";
    static final String SEX_FEMALE = "Q妹";

    Penguin() {
    }


    Penguin(String name, String sex) {
        this.setName(name);
        this.setSex(sex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {


        if (sex.equals(SEX_MALE)) {
            this.sex = sex;
        } else if (sex.equals(SEX_FEMALE)) {
            this.sex = sex;

        }

    }

    public String toString() {
        return this.getName() + "  " + this.getSex();

    }
}
