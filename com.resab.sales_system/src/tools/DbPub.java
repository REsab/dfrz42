package tools;

import java.sql.*;
import java.util.Properties;

public class DbPub {
    //                                /  代表src
//	                             /app.properties -->  /src/app.properties"
	public static String filename = "/app1.properties";

	public static String STD_DRIVER;
	public static String STD_URL;
	public static String STD_USERNAME;
	public static String STD_PASSWORD;




	static {
		Properties prop = new Properties();
		try {
			prop.load(DbPub.class.getResourceAsStream(filename));  //加载配置文件
			STD_DRIVER = prop.getProperty("STD_DRIVER");   //取出驱动类名
			STD_URL = prop.getProperty("STD_URL");
			STD_USERNAME = prop.getProperty("STD_USERNAME");
			STD_PASSWORD = prop.getProperty("STD_PASSWORD");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(filename + "不存在.");
		}

		try {
			Class.forName(STD_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("类全名[" + STD_DRIVER + "]没有找到.");
		}
	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(STD_URL, STD_USERNAME, STD_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接数据库失败,请检查四大金刚的相关参数");
		}
		return conn;
	}

	public static void close(Connection conn) {
		close(conn, null, null);
	}

	public static void close(Connection conn, ResultSet rs) {
		close(conn, null, rs);
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("关闭conn/stmt/rs失败.");
		}
	}

	public static ResultSet query(Connection conn, String sql, Object... params) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			rs = stmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("执行[" + sql + "]出现错误.");
		}
		return rs;
	}

	public static Integer upadte(Connection conn, String sql, Object... params) {
		PreparedStatement stmt = null;
		Integer num = null;
		try {
			stmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			num = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("执行[" + sql + "]出现错误.");
		}
		return num;
	}
}
