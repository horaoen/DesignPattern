package Interceptor;

import java.util.List;
import java.util.ArrayList; 

/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2ÔÂ-2020 14:35:59
 */
public class InterceptorCode5xx implements Interceptor {

	@Override
	public List<HttpStatusCode> doInterceptor(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> code5xxes = new ArrayList<HttpStatusCode>(); 
		for (HttpStatusCode httpStatusCode : httpStatusCodes) {
		 if(httpStatusCode.getCode()>=500){
			code5xxes.add(httpStatusCode);
		 }
		}
		System.out.println("***InterceptorCode5xx***");
		return code5xxes;
	}
}//end InterceptorCode5xx