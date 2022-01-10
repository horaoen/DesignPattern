package Filter;

import java.util.ArrayList; 
import java.util.List;
/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2ÔÂ-2020 14:34:54
 */
public class FilterCode4xx implements Filter {

	@Override
	public List<HttpStatusCode> doFilter(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> code4xxes = new ArrayList<HttpStatusCode>(); 
		for (HttpStatusCode httpStatusCode : httpStatusCodes) {
		 if(httpStatusCode.getCode()>=400 && httpStatusCode.getCode()<500){
			code4xxes.add(httpStatusCode);
		 }
		}
		return code4xxes;
	}
}//end FilterCode4xx