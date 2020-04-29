import java.sql.*;

public class JDBCforStu {

    public static void main(String[] args) {
        // String driverClassName = "com.micorsoft.sqlserver.jdbc.SQLServer";
        String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://127.0.0.1:61433;DataBase=School;";
        String user = "super";
        String pwd = "123";

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("driverClassName  有误");
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from Subject";   //sql 命令
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.print("\t" + resultSet.getInt("subjectid"));
                System.out.print("\t" + resultSet.getString("subjectName"));
                System.out.print("\t\t\t\t" + resultSet.getInt("classHour"));
                System.out.println("\t\t\t" + resultSet.getInt("gradeId"));

            }

        } catch (SQLException e) {

            System.out.println("连接错误 ");
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
