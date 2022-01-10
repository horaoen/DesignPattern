package Controller;

import java.util.List;

public class FrontController{
	private Dispatcher dispatcher;

	public FrontController(){
	  dispatcher = new Dispatcher();
	}

	private boolean isAuthenticUser(){
	  System.out.println("User is authenticated successfully.");
	  return true;
	}

	private void trackRequest(int request){
	  System.out.println("Page requested: " + request);
	}

	public void dispatchRequest(List<HttpStatusCode> httpStatusCodes, int request){
	  //记录每一个请求
	  trackRequest(request);
	  //对用户进行身份验证
	  if(isAuthenticUser()){
		 dispatcher.dispatch(httpStatusCodes, request);
	  }  
	}
}