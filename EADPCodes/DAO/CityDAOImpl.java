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
public class CityDAOImpl implements ICityDAO{

	private Connection conn ;
	private PreparedStatement pstmt ;

	public CityDAOImpl(){
		try{
			this.conn = DBUtil.getConnection(); 
		}catch(Exception e){
		
		}
	}

	/**
	 * Êý¾ÝÂß¼­
	 * @param vo
	 * @exception Exception
	 */
	public boolean doCreate(City vo)
	  throws Exception{
		String sql = "INSERT INTO city(cid, cname, cprovince) VALUES (?,?,?)" ;
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
	public boolean doUpdate(City vo)
	  throws Exception{
		String sql = "UPDATE city SET cname=?, cprovince=? WHERE cid=?" ;
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
		sql.append("DELETE FROM City WHERE cid IN(") ;
		Iterator<Integer> iter = ids.iterator() ;
		while(iter.hasNext()){
			sql.append(iter.next()).append(",") ;
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		this.pstmt = this.conn.prepareStatement(sql.toString());
		return this.pstmt.executeUpdate() == ids.size();
	}

	public City findById(Integer id)
	  throws Exception{
		City vo = null ;
		String sql = "SELECT cid, cname, cprovince FROM City WHERE cid=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			vo = new City() ;
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
	public List<City> findAll()
	  throws Exception{
		List<City> all = new ArrayList<City>() ;
		String sql = "SELECT cid, cname, cprovince FROM City" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while(rs.next()){
			City vo = new City() ;
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
	public List<City> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
	  throws Exception{
		List<City> all = new ArrayList<City>() ;
		String sql = "SELECT * FROM "
				+ " (SELECT cid, cname, cprovince, ROWNUM rn"
				+ " FROM City"
				+ " WHERE " + column + " LIKE ? AND ROWNUM<=?) temp "
				+ " WHERE temp.rn>? " ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setInt(2, currentPage * lineSize);
		this.pstmt.setInt(3, (currentPage - 1) * lineSize);
		ResultSet rs = this.pstmt.executeQuery() ;
		while(rs.next()) {
			City vo = new City() ;
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
		String sql = "SELECT COUNT(cid) FROM city WHERE " + column + " LIKE ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()) {
			return rs.getInt(1) ;
		}
		return null;
	}
}//end CityDAOImpl