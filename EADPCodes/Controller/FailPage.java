package Controller;

public class FailPage{
   public void printHttpStatusCode(HttpStatusCode httpStatusCode){
		System.out.println("----------------NO----------------");
		System.out.println("HttpStatusCode code, name, describe");
		   System.out.println("[ " + httpStatusCode.getCode() 
		      +",  " + httpStatusCode.getName() 
		      +",  " + httpStatusCode.getDescribe()
		      +" ]");
	}
}