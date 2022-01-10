package DAO;

/**
 * @author dll
 * @version 1.0
 * @created 14-3��-2020 10:46:58
 */
public class VO implements java.io.Serializable{

	private Integer id;//�˺�(������), int-->Integer, ����propert��get/set; memeber��get/set
	private String name;//����

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