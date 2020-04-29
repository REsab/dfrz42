package edu.mssql.kza.q3;

import java.sql.*;

public class JDBCforStu_grade {
    public final static String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://127.0.0.1:61433;DataBase=School;";
    public final static String user = "super";
    public final static String pwd = "123";


    static String sql_delete = null;
    static String sql_update = null;
    static String sql_insert = null;
    static String sql_select = null;

    public static void list() {

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("driverClassName  有误");
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, pwd);
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
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void insert() {

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("driverClassName  有误");
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, user, pwd);
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
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void delete() {

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("driverClassName  有误");
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, pwd);
            statement = connection.createStatement();
            boolean reuslt = statement.execute(sql_delete);
            System.out.println("删除成功");


        } catch (SQLException e) {

            // System.out.println("可能连接错误 ");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


    public static void update() {

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("driverClassName  有误");
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, pwd);
            statement = connection.createStatement();
            int reuslt = statement.executeUpdate(sql_update);
            if (reuslt > 0) {
                System.out.println("修改成功");

            }


        } catch (SQLException e) {

            // System.out.println("可能连接错误 ");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


}
