package DAO;

public interface IDAO {
	//�򵥽ӿ�
	public void insert(int key, String name);	//�������
	public void delete(int key);	//ɾ������
	public void update(int key, String name);	//���²���
	public void query(int key);	//��ѯ����
	//DAO--DB����
	public void insertToDB(VO vo);	//��ѯ����
	public void updateById(int key, VO vo); //���²���
	public void deleteById(int key);	//ɾ������
	public void queryById(int key);	//��ѯ����
}
