package Filter;

import java.util.List;
/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2ÔÂ-2020 14:44:36
 */
public class FilterCode4xxOr5xx implements Filter {

	private Filter code4xx;
	private Filter code5xx;

	public FilterCode4xxOr5xx(Filter code4xx, Filter code5xx) {
	  this.code4xx = code4xx;
	  this.code5xx = code5xx; 
	}

	@Override
	public List<HttpStatusCode> doFilter(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> code4xxes = code4xx.doFilter(httpStatusCodes); 
		List<HttpStatusCode> code5xxes = code5xx.doFilter(httpStatusCodes); 
		for (HttpStatusCode httpStatusCode : code5xxes) {
		 if(!code4xxes.contains(httpStatusCode)){
			code4xxes.add(httpStatusCode);
		 }
		}
		return code4xxes;
	}
}//end FilterCode4xxOr5xx