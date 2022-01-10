package Controller;

import java.util.List;

/**
 * This class defines an interface for handling requests and optionally implements
 * the successor link.
 * @author dll
 * @version 1.0
 * @created 25-2ÔÂ-2020 17:45:16
 */
public interface Interceptor {

	public List<HttpStatusCode> doInterceptor(List<HttpStatusCode> httpStatusCodes);
}//end Interceptor