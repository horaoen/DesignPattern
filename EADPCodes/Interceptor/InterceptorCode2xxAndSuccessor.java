package Interceptor;

import java.util.ArrayList; 
import java.util.List;
/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2ÔÂ-2020 14:38:19
 */
public class InterceptorCode2xxAndSuccessor implements Interceptor {
	
	private Interceptor successor;
	private Interceptor code2xx;

	public InterceptorCode2xxAndSuccessor(Interceptor code2xx, Interceptor successor) {
	  this.code2xx = code2xx;
	  this.successor = successor; 
	}

   @Override
	public List<HttpStatusCode> doInterceptor(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> code2xxes = code2xx.doInterceptor(httpStatusCodes); 
		System.out.println("***InterceptorCode2xxAndSuccessor***");
		return successor.doInterceptor(code2xxes);
	}
}