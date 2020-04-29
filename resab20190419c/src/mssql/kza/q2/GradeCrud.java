package mssql.kza.q2;

import java.sql.*;

public class GradeCrud {


    static String sql_delete = "delete grade where GradeId=3";   //sql 命令
    static String sql_update = "update Grade set GradeName ='S2B' where GradeId=2";   //sql 命令
    static String sql_insert = "insert into grade values (4,'S4')";   //sql 命令
    static String sql_select = "select * from grade";   //sql 命令

    public static void list() {


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DbPub.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_select);

            while (resultSet.next()) {
                System.out.print("\t" + resultSet.getInt("gradeid"));
                System.out.print("\t" + resultSet.getString("gradename"));
                System.out.println();

            }

        } catch (SQLException e) {

            System.out.println("可能连接错误 ");
            e.printStackTrace();
        } finally {

            DbPub.close(connection, statement, resultSet);
        }


    }

    public static void insert() {


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbPub.getConnection();
            statement = connection.createStatement();
            int reutlt = statement.executeUpdate(sql_insert);
            if (reutlt > 0) {

                System.out.println("insert success");
            } else {
                System.out.println("insert failed");
            }

        } catch (SQLException e) {

            // System.out.println("可能连接错误 ");
            e.printStackTrace();
        } finally {
            DbPub.close(connection, statement, resultSet);

        }


    }

    public static void delete() {


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DbPub.getConnection();
            statement = connection.createStatement();
            boolean reuslt = statement.execute(sql_delete);
            System.out.println("删除成功");


        } catch (SQLException e) {

            // System.out.println("可能连接错误 ");
            e.printStackTrace();
        } finally {
            DbPub.close(connection, statement, resultSet);

        }


    }


    public static void update() {

        try {
            Class.forName(DbPub.driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("driverClassName  有误");
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DbPub.getConnection();
            statement = connection.createStatement();
            int reuslt = statement.executeUpdate(sql_update);
            if (reuslt > 0) {
                System.out.println("删除成功");

            }} catch (SQLException e) {

            e.printStackTrace();
        } finally {
            DbPub.close(connection, statement, resultSet);

        }


    }


}
