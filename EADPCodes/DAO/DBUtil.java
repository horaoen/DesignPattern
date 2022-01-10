package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * @author dll
 * @version 1.0
 * @created 14-3ÔÂ-2020 12:11:43
 */
public class DBUtil {
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql:///eadp?useSSL=FALSE&serverTimezone=UTC&characterEncoding=UTF-8";//&amp;
	private static String user="root";
	private static String password="password";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		//return DriverManager.getConnection(url, user, password);    
		DefaultConnectionFactory dcf = new DefaultConnectionFactory();
		return dcf.getConnection();
	}
	
	public static void closeAll(Connection conn,Statement stmt,ResultSet rs) throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
		
}//end DBUtil