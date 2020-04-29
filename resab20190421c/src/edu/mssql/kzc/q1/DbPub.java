package edu.mssql.kzc.q1;


import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbPub {

    public static String fileName = "/app.properties";
    public static String STD_DRIVER;
    public static String STD_URL;
    public static String STD_USERNAME;
    public static String STD_PASSWARD;

    static {

     Properties properties = new Properties();
        try {
            properties.load(DbPub.class.getResourceAsStream(fileName));
            STD_DRIVER = properties.getProperty("STD_DRIVER");
            STD_URL = properties.getProperty("STD_URL");
            STD_USERNAME = properties.getProperty("STD_USERNAME");
            STD_PASSWARD = properties.getProperty("STD_PASSWARD");

        } catch (IOException e) {
            System.out.println(fileName + "不存在");
        } catch (ExceptionInInitializerError e) {
            System.out.println("q3423");
        } catch (NullPointerException e)

        {
            System.out.println("hell");
        }
        try {
            Class.forName(DbPub.STD_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("driverClassName  有误");
        }
    }


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbPub.STD_URL, DbPub.STD_USERNAME, DbPub.STD_PASSWARD);
        } catch (SQLException e) {
            System.out.println("connection  error ");
            e.printStackTrace();
        }

        return connection;

    }


    public static void close(Connection connection, Statement statement, ResultSet resultSet) {

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
            System.out.println("关闭资源时出错");
            e.printStackTrace();
        }


    }

    public static void close(Connection connection, ResultSet resultSet) {


        close(connection, null, resultSet);
    }

    public static void close(Connection connection) {

        close(connection, null, null);
    }

    public static ResultSet query(Connection connection, String sql) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("执行" + sql + "出错 ");
            e.printStackTrace();
        }
        return resultSet;


    }


    public static Integer update(Connection connection, String sql) {
        Statement statement = null;
        ResultSet resultSet = null;

        Integer num = 0;  //update 受 影响的行数
        try {
            connection = DbPub.getConnection();
            statement = connection.createStatement();
            num = statement.executeUpdate(sql);


        } catch (SQLException e) {
            System.out.println("DbPub update  失败 ");
            // e.printStackTrace();
        }

        return num;


    }


}
