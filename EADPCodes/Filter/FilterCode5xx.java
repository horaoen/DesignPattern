package Filter;

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
public class FilterCode5xx implements Filter {

	@Override
	public List<HttpStatusCode> doFilter(List<HttpStatusCode> httpStatusCodes){
		List<HttpStatusCode> code5xxes = new ArrayList<HttpStatusCode>(); 
		for (HttpStatusCode httpStatusCode : httpStatusCodes) {
		 if(httpStatusCode.getCode()>=500){
			code5xxes.add(httpStatusCode);
		 }
		}
		return code5xxes;
	}
}//end FilterCode5xx