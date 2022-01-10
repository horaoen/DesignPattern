package DAO;

/**
 * @author dll
 * @version 1.0
 * @created 14-3月-2020 10:46:58
 */
public class VO implements java.io.Serializable{

	private Integer id;//账号(表主键), int-->Integer, 属性propert有get/set; memeber无get/set
	private String name;//姓名

	public VO(){}
	public VO(Integer id, String name){
		this.id=id;
		this.name=name;
	}
	public Integer getId(){return id;}
	
	public String getName(){return name;}
	
	public void setId(Integer id){this.id=id;}
	
	public void setName(String name){this.name=name;}
	
	public String toString(){
		return "Vo:	id= " + id + "  name= " + name;
	}
}//end VO