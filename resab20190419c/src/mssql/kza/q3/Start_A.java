package mssql.kza.q3;

public class Start_A {


    public static void main(String[] args) {

        System.out.println("IDU之前的数据为");
        System.out.println("-------------------------------------");
        GradeCrud.list();

        System.out.println("-------------------------------------");
        System.out.println("正在执行IDU操作");

        GradeCrud.insert();
        GradeCrud.update();
        GradeCrud.delete();

        System.out.println("-------------------------------------");


        System.out.println("-------------------------------------");
        System.out.println("IDU之后的数据为");
        System.out.println("-------------------------------------");
        GradeCrud.list();

        System.out.println("-------------------------------------");

    }


}
