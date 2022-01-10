package Controller;

import java.util.List;

public class Dispatcher{
	
  private SuccessPage successPage;
   private FailPage failPage;
   public Dispatcher(){
      successPage = new SuccessPage();
      failPage = new FailPage();
   }
 
   public void dispatch(List<HttpStatusCode> httpStatusCodes, int request){

		for (HttpStatusCode httpStatusCode : httpStatusCodes)
			if(httpStatusCode.getCode()==request&&httpStatusCode.getSuccessor()){
				successPage.printHttpStatusCode(httpStatusCode);
			}else{
				failPage.printHttpStatusCode(httpStatusCode);
			}  
   }
}