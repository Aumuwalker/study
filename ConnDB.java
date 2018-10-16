package connDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {

	//���ݿ�url
	private final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=company";
	//�û���
	private static final String user = "sa";
	//����
	private static final String password = "123456";
	
	private static Connection conn = null;
	
	//��̬�����,��ɼ����������������ݿ�
	static {
		try {
			//����sql server���ݿ�,���Ի�Ϊ�������ݿ�
			String dburl = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			//������������
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
