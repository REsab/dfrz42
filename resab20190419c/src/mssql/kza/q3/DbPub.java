package mssql.kza.q3;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
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
