package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author dll
 * @version 1.0
 * @created 15-3ÔÂ-2020 12:00:14
 */
public class RiverDAOImpl implements IRiverDAO{

	private Connection conn ;
	private PreparedStatement pstmt ;

	public RiverDAOImpl(){
		try{
			this.conn = DBUtil.getConnection(); 
		}catch(Exception e){
		
		}
	}

	/**
	 * 
	 * @param vo
	 * @exception Exception
	 */
	public boolean doCreate(River vo)
	  throws Exception{
		String sql = "INSERT INTO river(rid, rname, rprovince) VALUES (?,?,?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, vo.getId());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setString(3, vo.getProvince());
		return this.pstmt.executeUpdate() > 0;
	}

	/**
	 * 
	 * @param vo
	 * @exception Exception
	 */
	public boolean doUpdate(River vo)
	  throws Exception{
		String sql = "UPDATE river SET rname=?, rprovince=? WHERE rid=?" ;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(3, vo.getId());
		this.pstmt.setString(1, vo.getName());
		this.pstmt.setString(2, vo.getProvince());
		return this.pstmt.executeUpdate() > 0 ;
	}

	/**
	 * 
	 * @param ids
	 * @exception Exception
	 */
	public boolean doRemoveBatch(Set<Integer> ids)
	  throws Exception{
		if(ids == null || ids.size() == 0){	
			System.out.println("É¾³ýÊ§°Ü£¡");
			return false ;
		}
		StringBuffer sql = new StringBuffer() ;
		sql.append("DELETE FROM river WHERE rid IN(") ;
		Iterator<Integer> iter = ids.iterator() ;
		while(iter.hasNext()){
			sql.append(iter.next()).append(",") ;
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		this.pstmt = this.conn.prepareStatement(sql.toString());
		return this.pstmt.executeUpdate() == ids.size();
	}

	public River findById(Integer id)
	  throws Exception{
		River vo = null ;
		String sql = "SELECT rid, rname, rprovince FROM river WHERE rid=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			vo = new River() ;
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setProvince(rs.getString(3));
		}
		return vo ;
	}

	/**
	 * 
	 * @exception Exception
	 */
	public List<River> findAll()
	  throws Exception{
		List<River> all = new ArrayList<River>() ;
		String sql = "SELECT rid, rname, rprovince FROM river" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while(rs.next()){
			River vo = new River() ;
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setProvince(rs.getString(3));
			all.add(vo);
		}
		return all;
	}

	/**
	 * 
	 * @param currentPage
	 * @param lineSize
	 * @param column
	 * @param keyWord
	 * @exception Exception
	 */
	public List<River> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
	  throws Exception{
		List<River> all = new ArrayList<River>() ;
		String sql = "SELECT * FROM "
				+ " (SELECT rid, rname, rprovince, ROWNUM rn"
				+ " FROM river"
				+ " WHERE " + column + " LIKE ? AND ROWNUM<=?) temp "
				+ " WHERE temp.rn>? " ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setInt(2, currentPage * lineSize);
		this.pstmt.setInt(3, (currentPage - 1) * lineSize);
		ResultSet rs = this.pstmt.executeQuery() ;
		while(rs.next()) {
			River vo = new River() ;
			vo.setId(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setProvince(rs.getString(3));
			all.add(vo) ;
		}
		return all;

	}

	/**
	 * 
	 * @param column
	 * @param keyWord
	 * @exception Exception
	 */
	public Integer getAllCount(String column, String keyWord)
	  throws Exception{
		String sql = "SELECT COUNT(rid) FROM river WHERE " + column + " LIKE ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()) {
			return rs.getInt(1) ;
		}
		return null;
	}
}//end RiverDAOImpl