package mssql.kza.q5_q3Plus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GradeCrud {


    static String sql_delete = "delete grade where GradeId=3";   //sql 命令
    static String sql_update = "update Grade set GradeName ='S2B' where GradeId=2";   //sql 命令
    static String sql_insert = "insert into grade values (4,'S4')";   //sql 命令
    static String sql_select = "select * from grade";   //sql 命令

    public static void insert() {

        int reutlt = DbPub.update(sql_insert);
        if (reutlt > 0) {

            System.out.println("insert success");
        } else {
            System.out.println("insert failed");
        }

    }

    public static void delete() {

        int i = DbPub.update(sql_delete);
        if (i > 0) {
            System.out.println("删除成功");

        } else {
            System.out.println("删除失败");
        }
    }


    public static void update() {

        int reuslt = DbPub.update(sql_update);
        if (reuslt > 0) {
            System.out.println("修改成功");
        }


    }
    public static void list() {

        Connection connection = DbPub.getConnection();
        ResultSet resultSet = null;
        try {

            resultSet = DbPub.query(connection, sql_select);

            ResultSet resultSet1=resultSet;
            ResultSet resultSet2=resultSet1;
            while (resultSet.next()) {
                System.out.print("\t" + resultSet.getInt("gradeid"));
                System.out.print("\t" + resultSet.getString("gradename"));
                System.out.println();

            }

        } catch (SQLException e) {

            System.out.println("可能连接错误 ");
            e.printStackTrace();
        }

    }

    public static void list2() {
//java里每个ResultSet结果集都需要一个单独的statement来支撑，
// 如果想使用多个Result就必须使用创建多个statement。

        ResultSet resultSet = null;
        try {

            resultSet = DbPub.query(  sql_select);

            while (resultSet.next()) {
                System.out.print("\t" + resultSet.getInt("gradeid"));
                System.out.print("\t" + resultSet.getString("gradename"));
                System.out.println();

            }

        } catch (SQLException e) {



            System.out.println(e.getMessage());

        }

    }
}





