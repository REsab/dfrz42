package edu.mssql.kza.q3;

public class Start_Q3 {


    public static void main(String[] args) {
        JDBCforStu_grade.url = "jdbc:sqlserver://127.0.0.1:61433;DataBase=School;";
        JDBCforStu_grade.sql_delete =  "delete Subject where GradeId=2 and SubjectName='javaSe plus'";
        JDBCforStu_grade.sql_update = "update Subject set SubjectName='JavaEE',ClassHour=120 where Subjectid=1 and gradeid=1";
        JDBCforStu_grade.sql_select = "select * from Subject";
        JDBCforStu_grade.sql_insert = "insert into Subject values (6,'FrontEnd',100,2) ";


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
