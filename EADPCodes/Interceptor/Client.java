package Interceptor;

import java.util.List;

public class Client {
   InterceptorManager interceptorManager;
 
   public void setInterceptorManager(InterceptorManager interceptorManager){
      this.interceptorManager = interceptorManager;
   }
 
   public void sendRequest(List<HttpStatusCode> httpStatusCodes, int request){
      interceptorManager.interceptorRequest(httpStatusCodes, request);
   }
}