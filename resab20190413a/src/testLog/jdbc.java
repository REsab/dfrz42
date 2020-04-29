package testLog;

import org.apache.log4j.Logger;

import java.sql.*;

import static java.lang.Class.forName;

public class jdbc {

    private static Logger logger = Logger.getLogger(jdbc.class.getName());

    public static void main(String[] args) {


        logger.warn("warn!!!");
        logger.error("error!!!");
        logger.fatal("fatal!!!");

        //四大金刚
        //                        <        包名              > <   类名       >
        String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //          <类似    http:// >< 127 本机  : 端口> <数据库名字=  **  >
        String url = "jdbc:sqlserver://127.0.0.1:61433;DatabaseName=School";
        //用户名  密码
        String user = "super";
        String password = "123";

//测试连接驱动driverClassName  是否写对
        try {
            forName(driverClassName);
            logger.info("找到驱动器类名");
        } catch (ClassNotFoundException e) {
            logger.info(e.getMessage());
            System.out.println("类名" + driverClassName + "找不到");
        }

        //三大金刚
        Connection connection = null;  //连接数库
        Statement statement = null;   //用于执行sql 命令语句
        ResultSet resultSet = null;  //接收sql的结果

        String sql = "select * from Grade";   //sql 命令

        try {
            connection = DriverManager.getConnection(url, user, password);
            logger.debug("数据库连接成功");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            logger.warn("数据库查询成功");
            while (resultSet.next()) {
                System.out.print("\t" + resultSet.getInt("GradeId"));
                System.out.print("\t" + resultSet.getString("GradeName"));
                System.out.println();
            }
            logger.error("数据库成功接收结果");
            //发送邮件  email 发送log4j发送email
            

        } catch (SQLException e) {
            System.out.println("执行" + sql + "出错");
        }


    }
}
