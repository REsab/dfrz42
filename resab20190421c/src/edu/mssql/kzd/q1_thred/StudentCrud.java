package edu.mssql.kzd.q1_thred;

import java.io.PipedWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCrud {

    //    PreparedStatement
    public static boolean login(String name, String userPwd) {
        boolean vIsOK = false;
        Integer num = 0;
        Connection connection = null;
//        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = null;

        ///sql 注入
        // ' or 1=1 or "='

        StringBuilder stringBuilderSQL = new StringBuilder();
        stringBuilderSQL.append("select count (1) from studentinfo ");
        stringBuilderSQL.append(" where 1=1 ");
        stringBuilderSQL.append("and studentno = ? ");
        stringBuilderSQL.append("and loginPwd = ? ");

        sql = stringBuilderSQL.toString();

        ///////////////////////////////////  add
        List<Object> listParms = new ArrayList<Object>();
        listParms.add(name);
        listParms.add(userPwd);

        Object[] params = listParms.toArray();


        try {
            connection = DbPub.getConnection();
            resultSet= DbPub.query(connection, sql, params) ;
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

    public static boolean loginOld(String name, String userPwd) {
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
