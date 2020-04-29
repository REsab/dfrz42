package mssql.kza.q4;

public class Start_B {


    public static void main(String[] args) {

        SubjectCurd.sql_delete =  "delete Subject where GradeId=2 and SubjectName='javaSe plus'";
        SubjectCurd.sql_update = "update Subject set SubjectName='JavaEE',ClassHour=120 where Subjectid=1 and gradeid=1";
        SubjectCurd.sql_select = "select * from Subject";
        SubjectCurd.sql_insert = "insert into Subject values (26,'FrontEnd',100,2) ";


        System.out.println("IDU之前的数据为");
        System.out.println("-------------------------------------");
        SubjectCurd.list();

        System.out.println("-------------------------------------");
        System.out.println("正在执行IDU操作");

        SubjectCurd.insert();
        SubjectCurd.update();
        SubjectCurd.delete();

        System.out.println("-------------------------------------");


        System.out.println("-------------------------------------");
        System.out.println("IDU之后的数据为");
        System.out.println("-------------------------------------");
        SubjectCurd.list();

        System.out.println("-------------------------------------");

    }

}
