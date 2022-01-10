
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
			//Class.forName(....);//ע������
			//DriverManager.getConnection();//��������
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
					System.out.println("���ݿ�ɾ����¼�ɹ�");
				else
					System.out.println("���ݿ�ɾ����¼ʧ��");
				DBUtil.closeAll(conn, pstmt, null);//�ر�
			}catch(Exception e){
				System.out.println("ɾ�����ݿ��¼ʧ�ܣ�");
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
					System.out.println("�������ݿ��¼�ɹ�");
				else
					System.out.println("�������ݿ��¼ʧ�ܣ�");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("�������ݿ��¼ʧ�ܣ�");
				e.printStackTrace();
			}
		}
	}
	public void update(int key, String name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		
		System.out.println("\n�޸�ǰ��¼Ϊ��");
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
					System.out.println("�޸����ݿ��¼�ɹ�");
					System.out.println("\n�޸ĺ��¼Ϊ��");
					queryById(key);
				}
				else
					System.out.println("�޸����ݿ��¼ʧ��");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("�޸����ݿ��¼ʧ�ܣ�");
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
				System.out.println("���ݿ��ѯ��¼�ɹ�");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("��ѯ���ݿ��¼ʧ�ܣ�");
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
					System.out.println("�������ݿ��¼�ɹ�");
				else
					System.out.println("�������ݿ��¼ʧ�ܣ�");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("�������ݿ��¼ʧ�ܣ�");
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
				System.out.println("���ݿ��ѯ��¼�ɹ�");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("��ѯ���ݿ��¼ʧ�ܣ�");
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
					System.out.println("���ݿ�ɾ����¼�ɹ�");
				else
					System.out.println("���ݿ�ɾ����¼ʧ��");
				DBUtil.closeAll(conn, pstmt, null);
			}catch(Exception e){
				System.out.println("ɾ�����ݿ��¼ʧ�ܣ�");
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
		
		System.out.println("\n�޸�ǰ��¼Ϊ��");
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
					System.out.println("�޸����ݿ��¼�ɹ�");
					System.out.println("\n�޸ĺ��¼Ϊ��");
					queryById(key);
				}
				else
					System.out.println("�޸����ݿ��¼ʧ��");
				DBUtil.closeAll(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println("�޸����ݿ��¼ʧ�ܣ�");
			}
		}
	}
	
}
