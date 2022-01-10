
package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOImpl implements IDAO{

	public void delete(int key) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			VO vo=new VO();
			//Class.forName(....);//注册驱动
			//DriverManager.getConnection();//创建连接
			conn = DBUtil.getConnection(); 
			String sql="delete from vo where Id="+key;
			pstmt= conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
				if(result>0)
					System.out.println("数据库删除记录成功");
				else
					System.out.println("数据库删除记录失败");
				DBUtil.closeAll(conn, pstmt, null);//关闭
			}catch(Exception e){
				System.out.println("删除数据库记录失败！");
				e.printStackTrace();
			}
		}
	}

	public void insert(int key, String name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			conn = DBUtil.getConnection(); 
			String sql="insert into vo(Id, Name) values(?,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, key);
			pstmt.setString(2, name);
			result = pstmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(result>0)
					System.out.println("插入数据库记录成功");
				else
					System.out.println("插入数据库记录失败！");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("插入数据库记录失败！");
				e.printStackTrace();
			}
		}
	}
	public void update(int key, String name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		
		System.out.println("\n修改前记录为：");
		queryById(key);
		try{
			conn = DBUtil.getConnection(); 
			String sql="update vo set Name='"+ name +"' where Id="+key;
			pstmt= conn.prepareStatement(sql);
			result=pstmt.executeUpdate();
		}catch(Exception e){
		}
		finally{
			try{
				if(result>0){
					System.out.println("修改数据库记录成功");
					System.out.println("\n修改后记录为：");
					queryById(key);
				}
				else
					System.out.println("修改数据库记录失败");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("修改数据库记录失败！");
			}
		}
	}

	public void query(int key) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			VO vo=new VO();
			conn = DBUtil.getConnection(); 
			String sql="select * from vo where Id="+key;
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo.setId(rs.getInt("Id"));
				vo.setName(rs.getString("Name"));
			}
			System.out.println(vo.toString());
			}catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
				System.out.println("数据库查询记录成功");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("查询数据库记录失败！");
				e.printStackTrace();
			}
		}
	}
	
	public void insertToDB(VO vo) {
		int key=vo.getId();
		String name=vo.getName();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			conn = DBUtil.getConnection(); 
			String sql="insert into vo(Id, Name) values(?,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, key);
			pstmt.setString(2, name);
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(result>0)
					System.out.println("插入数据库记录成功");
				else
					System.out.println("插入数据库记录失败！");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("插入数据库记录失败！");
				e.printStackTrace();
			}
		}
	}
	
	public void queryById(int key) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			VO vo=new VO();
			conn = DBUtil.getConnection(); 
			String sql="select * from vo where Id="+key;
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo.setId(rs.getInt("Id"));
				vo.setName(rs.getString("Name"));
			}
			System.out.println(vo.toString());
			}catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
				System.out.println("数据库查询记录成功");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("查询数据库记录失败！");
				e.printStackTrace();
			}
		}
	}
	public void deleteById(int key){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try{
			VO vo=new VO();
			conn = DBUtil.getConnection(); 
			String sql="delete from vo where Id="+key;
			pstmt= conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
		}
		finally{
			try{
				if(result>0)
					System.out.println("数据库删除记录成功");
				else
					System.out.println("数据库删除记录失败");
				DBUtil.closeAll(conn, pstmt, null);
			}catch(Exception e){
				System.out.println("删除数据库记录失败！");
				e.printStackTrace();
			}
		}
	}
	public void updateById(int key, VO vo) {
		String name=vo.getName();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		
		System.out.println("\n修改前记录为：");
		queryById(key);
		try{
			conn = DBUtil.getConnection(); 
			String sql="update vo set Name='"+ name +"' where Id="+key;
			pstmt= conn.prepareStatement(sql);
			result=pstmt.executeUpdate();
		}catch(Exception e){
		}
		finally{
			try{
				if(result>0){
					System.out.println("修改数据库记录成功");
					System.out.println("\n修改后记录为：");
					queryById(key);
				}
				else
					System.out.println("修改数据库记录失败");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("修改数据库记录失败！");
			}
		}
	}
	
}
