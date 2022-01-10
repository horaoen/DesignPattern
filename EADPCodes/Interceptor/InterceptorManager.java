package Interceptor;

import java.util.List;

public class InterceptorManager {
	
   InterceptorChain interceptorChain;
 
   public InterceptorManager(Target target){
      interceptorChain = new InterceptorChain();
      interceptorChain.setTarget(target);
   }
   public void setInterceptor(Interceptor interceptor){
      interceptorChain.addInterceptor(interceptor);
   }
 
   public void interceptorRequest(List<HttpStatusCode> httpStatusCodes, int request){
      interceptorChain.execute(httpStatusCodes, request);
   }
}