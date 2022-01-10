//package JDBCTemplate;
package TemplateMethod;

import java.sql.SQLException;
/**
 * @author dll
 * @version 1.0
 * @created 23-5ÔÂ-2020 10:16:35
 */
public class JdbcTemplateApp {

	public JdbcTemplate m_JdbcTemplate;
	public JdbcTemplateApp(){
		m_JdbcTemplate=new JdbcTemplate();
	}
	
	public void JdbcTemplateCRUD()  throws SQLException {
		User u = new User("root", "password");
		
		m_JdbcTemplate.addTemplateMethod(u);
		m_JdbcTemplate.queTemplateMethod("root");
		u.setPass("pass");
		m_JdbcTemplate.updTemplateMethod("root",u);
		m_JdbcTemplate.delTemplateMethod("root");
	}
}//end JdbcTemplateApp