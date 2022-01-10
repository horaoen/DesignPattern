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
	  //��¼ÿһ������
	  trackRequest(request);
	  //���û����������֤
	  if(isAuthenticUser()){
		 dispatcher.dispatch(httpStatusCodes, request);
	  }  
	}
}