package DAO;

public interface IDAO {
	//简单接口
	public void insert(int key, String name);	//插入操作
	public void delete(int key);	//删除操作
	public void update(int key, String name);	//更新操作
	public void query(int key);	//查询操作
	//DAO--DB操作
	public void insertToDB(VO vo);	//查询操作
	public void updateById(int key, VO vo); //更新操作
	public void deleteById(int key);	//删除操作
	public void queryById(int key);	//查询操作
}
