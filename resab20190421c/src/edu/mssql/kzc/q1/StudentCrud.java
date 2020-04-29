package edu.mssql.kzc.q1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCrud {


    public static boolean login(String name, String userPwd) {
        boolean vIsOK = false;
        Integer num = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = null;

        ///sql 注入
        // ' or 1=1 or "='

        StringBuilder stringBuilderSQL = new StringBuilder();
        stringBuilderSQL.append("select count (1) from studentinfo ");
        stringBuilderSQL.append(" where 1=1 ");
        stringBuilderSQL.append("and studentno ='" + name + "'");
        stringBuilderSQL.append("and loginPwd ='" + userPwd + "'");

        sql = stringBuilderSQL.toString();
        System.out.println(sql);

        try {
            connection = DbPub.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                num = resultSet.getInt(1);
            }
        } catch (SQLException e) {
           // e.printStackTrace();
            System.out.println("数据库出错");
        } finally {
        DbPub.close(connection);
    }


        if (num > 0) {
            vIsOK = true;
        }

        return vIsOK;
    }
}
