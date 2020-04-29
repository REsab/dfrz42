package mssql.kza.q2;

import java.sql.*;

public class SubjectCurd {


    static String sql_delete = null;
    static String sql_update = null;
    static String sql_insert = null;
    static String sql_select = null;




    public static void list() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DbPub.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_select);

            while (resultSet.next()) {
                System.out.print("\t" + resultSet.getInt("subjectid"));
                System.out.print("\t\t\t" + resultSet.getString("subjectName"));
                System.out.print("\t\t" + resultSet.getInt("classHour"));
                System.out.print("\t\t" + resultSet.getInt("Gradeid"));
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

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbPub.getConnection();
            statement = connection.createStatement();
            int reuslt = statement.executeUpdate(sql_update);
            if (reuslt > 0) {
                System.out.println("修改成功");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbPub.close(connection, statement, resultSet);
        }


    }


}
