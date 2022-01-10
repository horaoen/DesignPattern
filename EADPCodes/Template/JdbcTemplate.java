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
		/**/try{
			String sql="insert into user(name,pass) values(?,?)";
			pstatement=createPState(sql);
			pstatement.setString(1,u.getName());
			pstatement.setString(2,u.getPass());
			System.out.println("新增："+u.toString());
		}catch (SQLException sqle){
			 sqle.printStackTrace();
		}
	}

	public void delOpr(int id){
		try{
			String sql="delete from user where id=?";
			pstatement=createPState(sql);
			pstatement.setInt(1,id);
			System.out.println("删除："+id);
		}catch (SQLException sqle){
			 sqle.printStackTrace();
		}
	}

	public void updOpr(int id, User u){
		try{
			String sql="select * from user where id="+ id;
			pstatement=createPState(sql);
			resultset=pstatement.executeQuery();
			if(!resultset.next()){
				System.out.println("DB Is Not Exist User:"+id);
				return;
			}
			System.out.println("改前：User Id="+resultset.getString(1)+" Name="+resultset.getString(2)+" Pass="+resultset.getString(3));
			sql="update user set name=?, pass=? where id=" + id;
			pstatement=createPState(sql);
			pstatement.setString(1,u.getName());
			pstatement.setString(2,u.getPass());
			System.out.println("改后：User Id="+id+" Name="+u.getName()+" Pass="+u.getPass());
		}catch (SQLException sqle){
			 sqle.printStackTrace();
		}
	}

	public User queOpr(int id){
		try{
			User u = new User();
		
			String sql="select * from user where id="+id;
			pstatement=createPState(sql);
			resultset=pstatement.executeQuery();
			if(resultset.next()){
				u.setId(resultset.getInt(1));
				u.setName(resultset.getString(2));
				u.setPass(resultset.getString(3));
				System.out.println("查找："+u.toString());
				return u;
			}
		}catch (SQLException sqle){
			 sqle.printStackTrace();
		}
		return null;
	}
}//end JdbcTemplate