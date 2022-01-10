//package JDBCTemplate;
package TemplateMethod;

/**
 * @author dll
 * @version 1.0
 * @created 23-5ÔÂ-2020 9:28:36
 */
public class User {

	private String name;
	private String pass;

	public User(){
	}
	
	public User(String n, String p){
		name=n;
		pass=p;
	}
	
	public String getName(){return name;}
	public String getPass(){return pass;}
	public void setName(String u){ this.name=u;}
	public void setPass(String p){ this.pass=p;}
	
	public String toString(){
		return "User [name="+name+"], [pass="+pass+"]";
	}
}//end User