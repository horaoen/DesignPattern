package DAO;


/**
 * @author dll
 * @version 1.0
 * @created 15-3��-2020 11:26:46
 */
public class River implements java.io.Serializable {

	/**
	 * �˺�,����
	 */
	private Integer id;
	/**
	 * ����
	 */
	private String name;
	
	private String province;

	public River(){

	}

	/**
	 * 
	 * @param id
	 * @param name
	 */
	public River(Integer id, String name, String province){
		this.id=id;
		this.name=name;
		this.province=province;
	}

	public Integer getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id){
		this.id=id;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name=name;
	}
	
	public void setProvince(String province){
		this.province=province;
	}
	public String getProvince(){
		return province;
	}
	public String toString(){
		return "River:	id= " + id + "  name= " + name +" province= "+province;
	}
}//end City