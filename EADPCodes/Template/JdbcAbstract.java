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
		
		int res = pstatement.executeUpdate();/*
		Exception in thread "main" java.lang.NullPointerException
        at TemplateMethod.JdbcAbstract.addTemplateMethod(JdbcAbstract.java:49)
        at TemplateMethod.JdbcTemplateApp.JdbcTemplateCRUD(JdbcTemplateApp.java:20)
        at TemplateMethod.TemplateApp.mainJT(TemplateApp.java:25)
        at TemplateMethod.TemplateApp.main(TemplateApp.java:13)
		*/
		closeAll();
		return res;
	}
	public abstract void addOpr(User u);

	public final int delTemplateMethod(int id) throws SQLException{
		loadDriven();
		connection=getConn();
		
		delOpr(id);
		
		int res = pstatement.executeUpdate();
		closeAll();
		return res;
	}
	public abstract void delOpr(int id);
	
	public final int  updTemplateMethod(int id, User u)throws SQLException{
		loadDriven();
		connection=getConn();
		
		updOpr(id, u);
		
		int res = pstatement.executeUpdate();
		closeAll();
		return res;
	}
	public abstract void updOpr(int id, User u);

	public final User queTemplateMethod(int id)throws SQLException{
		loadDriven();
		connection=getConn();
		
		User u = new User();
		u=queOpr(id);
		
		closeAll();
		return u;
	}
	
	public abstract User queOpr(int id);

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