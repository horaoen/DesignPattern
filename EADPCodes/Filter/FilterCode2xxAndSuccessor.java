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
public class FilterCode2xxAndSuccessor implements Filter {
	
	private Filter successor;
	private Filter code2xx;

	public FilterCode2xxAndSuccessor(Filter code2xx, Filter successor) {
	  this.code2xx = code2xx;
	  this.successor = successor; 
	}

   @Override
	public List<HttpStatusCode> doFilter(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> code2xxes = code2xx.doFilter(httpStatusCodes); 
		return successor.doFilter(code2xxes);//200 201 202
	}
}