//package JDBCTemplate;
package TemplateMethod;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dll
 * @version 1.0
 * @created 23-5ÔÂ-2020 8:25:58
 */
public abstract class JdbcAbstract {

	public Connection connection=null;
	public PreparedStatement pstatement=null;
	public ResultSet resultset=null;
	
	private void loadDriven(){
		String driver="com.mysql.cj.jdbc.Driver";
		try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
			System.out.println("Load Driver Failed!");
            e.printStackTrace();
        }
	}

	private Connection getConn() throws SQLException{
		String url="jdbc:mysql:///eadp?useSSL=FALSE&serverTimezone=UTC&characterEncoding=UTF-8";
		String user="root";
		String password="password";
        connection =  DriverManager.getConnection(url,user,password);
		return connection;
	}

	protected PreparedStatement createPState(String sql) throws SQLException{
		pstatement = connection.prepareStatement(sql);
		return pstatement;
	}

	public final int addTemplateMethod(User u) throws SQLException{
		loadDriven();
		connection=getConn();
		
		addOpr(u);
		
		int res = pstatement.executeUpdate();
		closeAll();
		return res;
	}
	public abstract void addOpr(User u);

	public final int delTemplateMethod(String un) throws SQLException{
		loadDriven();
		connection=getConn();
		
		delOpr(un);
		
		int res = pstatement.executeUpdate();
		closeAll();
		return res;
	}
	public abstract void delOpr(String un);
	public final int  updTemplateMethod(String un, User u)throws SQLException{
		loadDriven();
		connection=getConn();
		
		updOpr(un, u);
		
		int res = pstatement.executeUpdate();
		closeAll();
		return res;
	}
	public abstract void updOpr(String un, User u);

	public final User queTemplateMethod(String un)throws SQLException{
		loadDriven();
		connection=getConn();
		User u = new User();
	
		closeAll();
		return u;
	}
	
	public abstract User queOpr(String un);

	private void closeAll() throws SQLException{
		if(resultset!=null) {
			resultset.close();
		}
		if(pstatement!=null) {
			pstatement.close();
		}
		if(connection!=null) {
			connection.close();
		}
	}
}//end JdbcAbstract