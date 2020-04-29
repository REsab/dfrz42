package mssql.kza.q4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectCurd {


    static String sql_delete = null;
    static String sql_update = null;
    static String sql_insert = null;
    static String sql_select = null;

    public static void list() {

        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DbPub.getConnection();

            resultSet = DbPub.query(connection, sql_select);

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
            DbPub.close(connection, resultSet);
        }


    }

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

            int reuslt = DbPub.update(connection, sql_delete);
            if (reuslt > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除不成功");

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


}
