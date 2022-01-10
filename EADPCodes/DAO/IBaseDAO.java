package DAO;
 
import java.util.List;
import java.util.Set;
 
public interface IBaseDAO<K,V> {//Java泛型对各种实体类进行封装：k是主键/唯一编号；V是实体类：City、River、Lake

	public boolean doCreate(V vo) throws Exception;
 
	public boolean doUpdate(V vo) throws Exception;

	public boolean doRemoveBatch(Set<K> ids) throws Exception;
 
	public V findById(K id) throws Exception;

	public List<V> findAll() throws Exception;
 
	public List<V> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception;

	public Integer getAllCount(String column, String keyWord) throws Exception;
}