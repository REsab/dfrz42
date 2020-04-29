package chb06.lx.q2;

public class Dog extends Pet {
    private String stratin;

    public Dog(String stratin , String name) {
        this.setName(name);
        this.setStratin(stratin);

    }

    public String getStratin() {
        return stratin;
    }

    public void setStratin(String stratin) {
        this.stratin = stratin;
    }

    public String toString() {
        return this.getName() + "\t" + this.getStratin();
    }
}
