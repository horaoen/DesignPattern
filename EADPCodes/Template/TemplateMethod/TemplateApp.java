package TemplateMethod;

//import JDBCTemplate.JdbcTemplateApp;
import java.sql.SQLException;
/**
 * @author dll
 * @version 1.0
 * @created 01-5ÔÂ-2020 11:48:28
 */
public class TemplateApp {

	public static void main0(String[] args) {      
	        AbstractClass ac=new ConcreteClass();
        	ac.TemplateMethod();
   }
   
   	public static void main(String[] args) {      
	        JdbcTemplateApp jt=new JdbcTemplateApp();
		try{
        	jt.JdbcTemplateCRUD();
		}catch (SQLException sqle){
			 sqle.printStackTrace();
		}
   }
}//end TemplateApp