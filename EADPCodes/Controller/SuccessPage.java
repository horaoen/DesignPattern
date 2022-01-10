package Controller;

public class SuccessPage{
   public void printHttpStatusCode(HttpStatusCode httpStatusCode){
		System.out.println("\n****************OK****************");
		System.out.println("HttpStatusCode code, name, describe");
		   System.out.println("[ " + httpStatusCode.getCode() 
		      +",  " + httpStatusCode.getName() 
		      +",  " + httpStatusCode.getDescribe()
		      +" ]\n");
	}
}