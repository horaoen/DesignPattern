package Filter;

import java.util.ArrayList; 
import java.util.List;
/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2ÔÂ-2020 14:20:41
 */
public class FilterCode2xx implements Filter {

	@Override
	public List<HttpStatusCode> doFilter(List<HttpStatusCode> httpStatusCodes) {
		List<HttpStatusCode> code2xxes = new ArrayList<HttpStatusCode>(); 
		for (HttpStatusCode httpStatusCode : httpStatusCodes) {
		 if(httpStatusCode.getCode()>=200 && httpStatusCode.getCode()<300){
			code2xxes.add(httpStatusCode);
		 }
		}
		return code2xxes;
	}
}//end FilterCode2xx