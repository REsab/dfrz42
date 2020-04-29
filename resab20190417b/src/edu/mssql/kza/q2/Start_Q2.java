package edu.mssql.kza.q2;

public class Start_Q2 {


    public static void main(String[] args) {

        System.out.println("IDU之前的数据为");
        System.out.println("-------------------------------------");
        JDBCforStu_grade.list();

        System.out.println("-------------------------------------");
        System.out.println("正在执行IDU操作");

        JDBCforStu_grade.insert();
        JDBCforStu_grade.update();
        JDBCforStu_grade.delete();

        System.out.println("-------------------------------------");


        System.out.println("-------------------------------------");
        System.out.println("IDU之后的数据为");
        System.out.println("-------------------------------------");
        JDBCforStu_grade.list();

        System.out.println("-------------------------------------");

    }


}
