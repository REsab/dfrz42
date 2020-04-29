package JDBC;

import java.sql.*;
import static java.lang.Class.forName;
//Java中显示Grade表的信息
public class TestJDBC {


    public static void main(String[] args) {

        String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://127.0.0.1:61433;DatabaseName=School";
        String user = "super";
        String password = "123";

        try {
            forName(driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("类名" + driverClassName + "找不到");
        }

        //三大金刚
        Connection connection = null;  //连接数库
        Statement statement = null;   //用于执行sql 命令语句
        ResultSet resultSet = null;  //接收sql的结果
        String sql = "select * from Grade";   //sql 命令

        //尝试连接 获取结果
        System.out.println("数据school的Grade表的信息");
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.print("\t" + resultSet.getInt("GradeId"));
                System.out.print("\t" + resultSet.getString("GradeName"));
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("执行" + sql + "出错");
        }


    }
}
