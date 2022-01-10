package Interceptor;

public class HttpStatusCode {

	private int code;
	private String name;
	private String describe;
	private boolean successor;

	public HttpStatusCode(int c, String n, String d, boolean s){
		this.code=c;
		this.name=n;
		this.describe=d;
		this.successor = s;
	}

	public int getCode(){
		return code;
	}

	public String getName(){
		return name;
	}

	public String getDescribe(){
		return describe;
	}

	public boolean getSuccessor(){
		return successor;
	}
}//end HttpStatusCode