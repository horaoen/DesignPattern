package Controller;

import java.util.List;
/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2ÔÂ-2020 14:44:36
 */
public class InterceptorCode4xxOr5xx implements Interceptor {

	private Interceptor code4xx;
	private Interceptor code5xx;

	public InterceptorCode4xxOr5xx(Interceptor code4xx, Interceptor code5xx) {
	  this.code4xx = code4xx;
	  this.code5xx = code5xx; 
	}

	@Override
	public List<HttpStatusCode> doInterceptor(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> code4xxes = code4xx.doInterceptor(httpStatusCodes); 
		List<HttpStatusCode> code5xxes = code5xx.doInterceptor(httpStatusCodes); 
		for (HttpStatusCode httpStatusCode : code5xxes) {
		 if(!code4xxes.contains(httpStatusCode)){
			code4xxes.add(httpStatusCode);
		 }
		}
		System.out.println("***InterceptorCode4xxOr5xx***");
		return code4xxes;
	}
}//end InterceptorCode4xxOr5xx