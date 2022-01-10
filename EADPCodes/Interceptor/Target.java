package Interceptor;

public class Target {
	public void printHttpStatusCode(HttpStatusCode httpStatusCode){
		System.out.println("HttpStatusCode code, name, describe");
		   System.out.println("[ " + httpStatusCode.getCode() 
		      +",  " + httpStatusCode.getName() 
		      +",  " + httpStatusCode.getDescribe()
		      +" ]");
	}
}