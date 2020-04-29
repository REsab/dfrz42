package mssql.kza.q2;

import java.sql.*;

public class DbPub {

    public final static String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://127.0.0.1:61433;DataBase=School;";
    public final static String user = "super";
    public final static String pwd = "123";

    static {
        try {
            Class.forName(DbPub.driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("driverClassName  有误");
        }
    }


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbPub.url, DbPub.user, DbPub.pwd);
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


}
