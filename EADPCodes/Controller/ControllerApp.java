package Controller;


import java.util.ArrayList; 
import java.util.List;

/**
 * @author dll
 * @version 1.0
 * @created 25-2月-2020 15:03:36
 */
public class ControllerApp {

	public static void printHttpStatusCodes(List<HttpStatusCode> httpStatusCodes){
		System.out.println("HttpStatusCode code, name, describe");
		for (HttpStatusCode httpStatusCode : httpStatusCodes) {
		   System.out.println("[ " + httpStatusCode.getCode() 
		      +",  " + httpStatusCode.getName() 
		      +",  " + httpStatusCode.getDescribe()
		      +" ]");
		}
	}
		
	public static void main(String[] args){
		List<HttpStatusCode> httpStatusCodes = new ArrayList<HttpStatusCode>();
		 
		httpStatusCodes.add(new HttpStatusCode(100, "Continue", "初始的请求已经接受，客户应当继续发送请求的其余部分（HTTP 1.1）", false));
		httpStatusCodes.add(new HttpStatusCode(101, "Switching Protocols", "服务器将遵从客户的请求转换到另外一种协议（HTTP 1.1新）", false));
		httpStatusCodes.add(new HttpStatusCode(200, "OK", "一切正常，对GET和POST请求的应答文档跟在后面", true));
		httpStatusCodes.add(new HttpStatusCode(201,	"Created", "已创建。成功请求并创建了新的资源", true));
		httpStatusCodes.add(new HttpStatusCode(202,	"Accepted", "已接受。已经接受请求，但未处理完成", true));
		httpStatusCodes.add(new HttpStatusCode(300, "Multiple Choices", "多种选择", true));
		httpStatusCodes.add(new HttpStatusCode(301, "Moved Permanently", "资源（网页等）被永久转移到其它URL", false));
		httpStatusCodes.add(new HttpStatusCode(400, "Bad Request", "客户端请求的语法错误，服务器无法理解", false));
		httpStatusCodes.add(new HttpStatusCode(401, "Unauthorized", "请求要求用户的身份认证", false));
		httpStatusCodes.add(new HttpStatusCode(402, "Payment Required", "保留，将来使用", false));
		httpStatusCodes.add(new HttpStatusCode(403, "Forbidden", "服务器理解请求客户端的请求，但是拒绝执行此请求", false));
		httpStatusCodes.add(new HttpStatusCode(404, "Not Found", "无法找到指定位置的资源", false));
		httpStatusCodes.add(new HttpStatusCode(500, "Internal Server Error", "服务器内部错误，无法完成请求", false));
		httpStatusCodes.add(new HttpStatusCode(501, "Not Implemented", "服务器不支持请求的功能，无法完成请求", false));
		httpStatusCodes.add(new HttpStatusCode(502, "Bad Gateway", "作为网关或者代理工作的服务器尝试执行请求时收到一个无效的响应", false));
		httpStatusCodes.add(new HttpStatusCode(503, "Service Unavailable", "服务器由于维护或者负载过重未能应答", false));
		
		Interceptor code1xx = new InterceptorCode1xx();
		Interceptor code2xx = new InterceptorCode2xx();
		Interceptor code3xx = new InterceptorCode3xx();
		Interceptor code4xx = new InterceptorCode4xx();
		Interceptor code5xx = new InterceptorCode5xx();
		Interceptor successor = new InterceptorSuccessor();
		Interceptor code1xxAnd2xx = new InterceptorCode1xxAnd2xx(code1xx, code2xx);
		Interceptor code2xxAndSuccessor = new InterceptorCode2xxAndSuccessor(code2xx, successor);
		Interceptor code4xxOr5xx = new InterceptorCode4xxOr5xx(code4xx, code5xx);
		 
		System.out.println("1xx: ");
		printHttpStatusCodes(code1xx.doInterceptor(httpStatusCodes));
		System.out.println("\n2xx: ");
		printHttpStatusCodes(code2xx.doInterceptor(httpStatusCodes));
		System.out.println("\n3xx: ");
		printHttpStatusCodes(code3xx.doInterceptor(httpStatusCodes));
		System.out.println("\n4xx: ");
		printHttpStatusCodes(code4xx.doInterceptor(httpStatusCodes));
		System.out.println("\n5xx: ");
		printHttpStatusCodes(code5xx.doInterceptor(httpStatusCodes));
		System.out.println("\nSuccessor: ");
		printHttpStatusCodes(successor.doInterceptor(httpStatusCodes));
		System.out.println("\n1xx and 2xx: ");
		printHttpStatusCodes(code1xxAnd2xx.doInterceptor(httpStatusCodes));
		System.out.println("\n2xx and successor: ");
		printHttpStatusCodes(code2xxAndSuccessor.doInterceptor(httpStatusCodes));		
		System.out.println("\n4xx or 5xx: ");
		printHttpStatusCodes(code4xxOr5xx.doInterceptor(httpStatusCodes));
		
		System.out.println("\n**********************************************************\n");		
		InterceptorManager interceptorManager = new InterceptorManager(new Target());
		//interceptorManager.setInterceptor(code1xx);
		interceptorManager.setInterceptor(code2xx);
		interceptorManager.setInterceptor(code3xx);
		interceptorManager.setInterceptor(code4xx);
		interceptorManager.setInterceptor(code5xx);
		//interceptorManager.setInterceptor(successor);
		//interceptorManager.setInterceptor(code2xxAndSuccessor);
		//interceptorManager.setInterceptor(code4xxOr5xx);	

		Client client = new Client();
		client.setInterceptorManager(interceptorManager);
		//client.sendRequest(httpStatusCodes, 100);System.out.println("\n");
		client.sendRequest(httpStatusCodes, 200);System.out.println("\n");
		//client.sendRequest(httpStatusCodes, 303);System.out.println("\n");
		client.sendRequest(httpStatusCodes, 404);System.out.println("\n");
		client.sendRequest(httpStatusCodes, 500);System.out.println("\n");
		
		System.out.println("\n**********************************************************\n");
		FrontController frontController = new FrontController();
		frontController.dispatchRequest(httpStatusCodes, 200);
		//frontController.dispatchRequest(httpStatusCodes, 404);
	}
}//end InterceptorApp