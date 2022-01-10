package Filter;

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
public class FilterCode1xxAnd2xx implements Filter {
	
	private Filter code1xx;
	private Filter code2xx;

	public FilterCode1xxAnd2xx(Filter code1xx, Filter code2xx) {
	  this.code1xx = code1xx;
	  this.code2xx = code2xx; 
	}

   @Override
	public List<HttpStatusCode> doFilter(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> code1xxes = code1xx.doFilter(httpStatusCodes); 
		return code2xx.doFilter(code1xxes);
	}
}//end FilterCode1xxAnd2xx