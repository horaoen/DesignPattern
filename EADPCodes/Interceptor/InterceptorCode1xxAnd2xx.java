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
public class InterceptorCode1xxAnd2xx implements Interceptor {
	
	private Interceptor code1xx;
	private Interceptor code2xx;

	public InterceptorCode1xxAnd2xx(Interceptor code1xx, Interceptor code2xx) {
	  this.code1xx = code1xx;
	  this.code2xx = code2xx; 
	}

   @Override
	public List<HttpStatusCode> doInterceptor(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> code1xxes = code1xx.doInterceptor(httpStatusCodes); 
		return code2xx.doInterceptor(code1xxes);
	}
}//end InterceptorCode1xxAnd2xx