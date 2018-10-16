package connDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {

	//数据库url
	private final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=company";
	//用户名
	private static final String user = "sa";
	//密码
	private static final String password = "123456";
	
	private static Connection conn = null;
	
	//静态代码块,完成加载驱动，连接数据库
	static {
		try {
			//连接sql server数据库,可以换为其他数据库
			String dburl = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			//加载驱动程序
			Class.forName(dburl);
			conn = DriverManager.getConnection(url, user,password);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
}
