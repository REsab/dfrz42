package chb06.lx.q4;

public class Penguin {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name = "无名氏";
    private int heath = 100;
    private int love = 0;

    private String sex = SEX_MALE;
    static final String SEX_MALE = "Q仔";
    static final String SEX_FEMALE = "Q妹";

    Penguin() {
    }


    Penguin(String name, String sex,int id) {
        this.setName(name);
        this.setSex(sex);
        this.id=id;
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
