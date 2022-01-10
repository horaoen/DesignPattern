package Interceptor;

import java.util.ArrayList; 
import java.util.List;

/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2ÔÂ-2020 17:25:04
 */
public class InterceptorSuccessor implements Interceptor {

	@Override
	public List<HttpStatusCode> doInterceptor(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> successors = new ArrayList<HttpStatusCode>(); 
		for (HttpStatusCode httpStatusCode : httpStatusCodes) {
		 if(httpStatusCode.getSuccessor()){
			successors.add(httpStatusCode);
		 }
		}
		System.out.println("***InterceptorSuccessor***");
		return successors;
	}
}//end InterceptorSuccessor