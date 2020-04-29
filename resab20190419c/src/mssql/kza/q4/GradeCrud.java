package mssql.kza.q4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeCrud {


    static String sql_delete = "delete grade where GradeId=3";   //sql 命令
    static String sql_update = "update Grade set GradeName ='S2B' where GradeId=2";   //sql 命令
    static String sql_insert = "insert into grade values (4,'S4')";   //sql 命令
    static String sql_select = "select * from grade";   //sql 命令

    public static void insert() {


        Connection connection = null;

        ResultSet resultSet = null;
        try {
            connection = DbPub.getConnection();

            int reutlt = DbPub.update(connection, sql_insert);
            if (reutlt > 0) {

                System.out.println("insert success");
            } else {
                System.out.println("insert failed");
            }

        } finally {
            DbPub.close(connection, resultSet);

        }


    }

    public static void delete() {


        Connection connection = null;

        ResultSet resultSet = null;

        try {
            connection = DbPub.getConnection();


            int i = DbPub.update(connection, sql_delete);
            if (i > 0) {
                System.out.println("删除成功");

            } else {
                System.out.println("删除失败");
            }


        } finally {
            DbPub.close(connection, resultSet);

        }


    }


    public static void update() {


        Connection connection = null;

        ResultSet resultSet = null;

        try {
            connection = DbPub.getConnection();
            int reuslt = DbPub.update(connection, sql_update);
            if (reuslt > 0) {
                System.out.println("修改成功");

            }
        } finally {
            DbPub.close(connection, resultSet);

        }


    }

    public static void list() {

        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DbPub.getConnection();
            resultSet = DbPub.query(connection, sql_select);

            while (resultSet.next()) {
                System.out.print("\t" + resultSet.getInt("gradeid"));
                System.out.print("\t" + resultSet.getString("gradename"));
                System.out.println();

            }

        } catch (SQLException e) {

            System.out.println("可能连接错误 ");
            e.printStackTrace();
        } finally {

            DbPub.close(connection, resultSet);


        }

    }
}





