package Controller;


import java.util.ArrayList; 
import java.util.List;

/**
 * @author dll
 * @version 1.0
 * @created 25-2��-2020 15:03:36
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
		 
		httpStatusCodes.add(new HttpStatusCode(100, "Continue", "��ʼ�������Ѿ����ܣ��ͻ�Ӧ������������������ಿ�֣�HTTP 1.1��", false));
		httpStatusCodes.add(new HttpStatusCode(101, "Switching Protocols", "����������ӿͻ�������ת��������һ��Э�飨HTTP 1.1�£�", false));
		httpStatusCodes.add(new HttpStatusCode(200, "OK", "һ����������GET��POST�����Ӧ���ĵ����ں���", true));
		httpStatusCodes.add(new HttpStatusCode(201,	"Created", "�Ѵ������ɹ����󲢴������µ���Դ", true));
		httpStatusCodes.add(new HttpStatusCode(202,	"Accepted", "�ѽ��ܡ��Ѿ��������󣬵�δ�������", true));
		httpStatusCodes.add(new HttpStatusCode(300, "Multiple Choices", "����ѡ��", true));
		httpStatusCodes.add(new HttpStatusCode(301, "Moved Permanently", "��Դ����ҳ�ȣ�������ת�Ƶ�����URL", false));
		httpStatusCodes.add(new HttpStatusCode(400, "Bad Request", "�ͻ���������﷨���󣬷������޷����", false));
		httpStatusCodes.add(new HttpStatusCode(401, "Unauthorized", "����Ҫ���û��������֤", false));
		httpStatusCodes.add(new HttpStatusCode(402, "Payment Required", "����������ʹ��", false));
		httpStatusCodes.add(new HttpStatusCode(403, "Forbidden", "�������������ͻ��˵����󣬵��Ǿܾ�ִ�д�����", false));
		httpStatusCodes.add(new HttpStatusCode(404, "Not Found", "�޷��ҵ�ָ��λ�õ���Դ", false));
		httpStatusCodes.add(new HttpStatusCode(500, "Internal Server Error", "�������ڲ������޷��������", false));
		httpStatusCodes.add(new HttpStatusCode(501, "Not Implemented", "��������֧������Ĺ��ܣ��޷��������", false));
		httpStatusCodes.add(new HttpStatusCode(502, "Bad Gateway", "��Ϊ���ػ��ߴ������ķ���������ִ������ʱ�յ�һ����Ч����Ӧ", false));
		httpStatusCodes.add(new HttpStatusCode(503, "Service Unavailable", "����������ά�����߸��ع���δ��Ӧ��", false));
		
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