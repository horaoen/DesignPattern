package Interceptor;

import java.util.ArrayList;
import java.util.List;
 
public class InterceptorChain {
	
   private List<Interceptor> interceptors = new ArrayList<Interceptor>();
   private Target target;
 
   public void addInterceptor(Interceptor interceptor){
      interceptors.add(interceptor);
   }
 	
   public void execute(List<HttpStatusCode> httpStatusCodes, int request){
      for (Interceptor interceptor : interceptors) {
			List<HttpStatusCode> inHttpStatusCodes=interceptor.doInterceptor(httpStatusCodes);
			for (HttpStatusCode httpStatusCode : inHttpStatusCodes)
				if(httpStatusCode.getCode()==request)
					target.printHttpStatusCode(httpStatusCode);
      }
   }
 
   public void setTarget(Target target){
      this.target = target;
   }
}