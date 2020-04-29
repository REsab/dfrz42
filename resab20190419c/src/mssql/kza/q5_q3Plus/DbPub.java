package mssql.kza.q5_q3Plus;


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
        } catch (NullPointerException e) {
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

    public static ResultSet query(Connection connection, String sql) {
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;


        try {
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

            resultSet1 = resultSet;
            resultSet2 = resultSet1;
            resultSet = resultSet2;



        } catch (SQLException e) {
            System.out.println("执行" + sql + "出错 ");
            e.printStackTrace();
        }
        return resultSet;


    }

    //以下两个方法修改,自己连接  ,自己关闭connect
    public static ResultSet query(String sql) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            Thread.sleep(1000);
        } catch (SQLException e) {
            System.out.println("执行" + sql + "出错 ");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            close(connection, statement, resultSet);
        }
        return resultSet;

    }


    public static Integer update(String sql) {
        Connection connection = getConnection();
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
        } finally {
            close(connection, statement, resultSet);
        }

        return num;


    }

//    public CachedRowSetImpl queryExecute(String sql)
//    {
//
//        try {
//            ct = this.getConnection();
//            ps = ct.prepareStatement(sql);
//
//            rs = ps.executeQuery();
//
//            //填充离线结果集
//            rowSet = new CachedRowSetImpl();
//            rowSet.populate(rs);
//
//        } catch (SQLException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }finally
//        {
//            this.close();
//        }
//
//        return rowSet;
//    }
//---------------------
//    作者：Krishnna
//    来源：CSDN
//    原文：https://blog.csdn.net/Krishnna/article/details/52973388
//    版权声明：本文为博主原创文章，转载请附上博文链接！
}
