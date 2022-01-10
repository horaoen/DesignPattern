//package JDBCTemplate;
package TemplateMethod;

import java.sql.SQLException;

/**
 * @author dll
 * @version 1.0
 * @created 23-5月-2020 10:13:47
 */
public class JdbcTemplate extends JdbcAbstract {

	public JdbcTemplate(){

	}

	public void addOpr(User u){
		try{
			String sql="insert into user(name,pass) values(?,?)";
			pstatement=createPState(sql);
			pstatement.setString(1,u.getName());
			pstatement.setString(2,u.getPass());
			System.out.println("增："+u.toString());
		}catch (SQLException sqle){
			 sqle.printStackTrace();
		}
	}

	public void delOpr(String un){
		try{
			String sql="delete from student where name=?";
			pstatement=createPState(sql);
			pstatement.setString(1,un);
			System.out.println("删："+un);
		}catch (SQLException sqle){
			 sqle.printStackTrace();
		}
	}

	public void updOpr(String un, User u){
		try{
			String sql="select * from user where name='"+ un +"'";
			pstatement=createPState(sql);
			pstatement.setString(1,un);
			resultset=pstatement.executeQuery();
			if(!resultset.next()){
				System.out.println("DB Is Not Exist User:"+un);
				return;
			}
			System.out.println("改前："+un);
			sql="update from user set pass=? where name='"+ un +"'";
			pstatement=createPState(sql);
			pstatement.setString(1,u.getPass());
			System.out.println("改后："+u.toString());
		}catch (SQLException sqle){
			 sqle.printStackTrace();
		}
	}

	public User queOpr(String un){
		try{
			User u = new User();
		
			String sql="select * from user where name='"+ un +"'";
			pstatement=createPState(sql);
			resultset=pstatement.executeQuery();
			u.setName(resultset.getString(1));
			u.setPass(resultset.getString(1));
			System.out.println("查："+u.toString());
			return u;
		}catch (SQLException sqle){
			 sqle.printStackTrace();
		}
		return null;
	}
}//end JdbcTemplate