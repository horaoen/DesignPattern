package Interceptor;


import java.util.List;
import java.util.ArrayList; 

/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2ÔÂ-2020 14:09:34
 */
public class InterceptorCode1xx implements Interceptor {

	@Override
	public List<HttpStatusCode> doInterceptor(List<HttpStatusCode> httpStatusCodes) {
		List<HttpStatusCode> code1xxes = new ArrayList<HttpStatusCode>(); 
		for (HttpStatusCode httpStatusCode : httpStatusCodes) {
		 if(httpStatusCode.getCode()<200){
			code1xxes.add(httpStatusCode);
		 }
		}
		System.out.println("***InterceptorCode1xx***");
		return code1xxes;
	}
}//end InterceptorCode1xx