package mssql.kza.q5_q3Plus;

import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentNavigableMap;

public class SubjectCurd {


    static String sql_delete = null;
    static String sql_update = null;
    static String sql_insert = null;
    static String sql_select = null;

    public static void list() {
        Connection connection=DbPub.getConnection();

        ResultSet resultSet = null;

        try {

            resultSet = DbPub.query( connection,sql_select);

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
        }


    }

    public static void insert() {

  int reutlt = DbPub.update(sql_insert);
            if (reutlt > 0) {
                System.out.println("insert success");
            } else {
                System.out.println("insert failed");
            }



    }

    public static void delete() {

            int reuslt = DbPub.update(sql_delete);
            if (reuslt > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除不成功");

            }
    }


    public static void update() {

            int reuslt = DbPub.update( sql_update);
            if (reuslt > 0) {
                System.out.println("修改成功");

            }

    }


}
