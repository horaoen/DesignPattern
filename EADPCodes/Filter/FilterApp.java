package Filter;


import java.util.ArrayList; 
import java.util.List;

/**
 * @author dll
 * @version 1.0
 * @created 25-2��-2020 15:03:36
 */
public class FilterApp {

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
		
		Filter code1xx = new FilterCode1xx();
		Filter code2xx = new FilterCode2xx();
		Filter code3xx = new FilterCode3xx();
		Filter code4xx = new FilterCode4xx();
		Filter code5xx = new FilterCode5xx();
		Filter successor = new FilterSuccessor();
		Filter code1xxAnd2xx = new FilterCode1xxAnd2xx(code1xx, code2xx);
		Filter code2xxAndSuccessor = new FilterCode2xxAndSuccessor(code2xx, successor);
		Filter code4xxOr5xx = new FilterCode4xxOr5xx(code4xx, code5xx);
		 
		System.out.println("1xx: ");
		printHttpStatusCodes(code1xx.doFilter(httpStatusCodes));
		System.out.println("\n2xx: ");
		printHttpStatusCodes(code2xx.doFilter(httpStatusCodes));
		System.out.println("\n3xx: ");
		printHttpStatusCodes(code3xx.doFilter(httpStatusCodes));
		System.out.println("\n4xx: ");
		printHttpStatusCodes(code4xx.doFilter(httpStatusCodes));
		System.out.println("\n5xx: ");
		printHttpStatusCodes(code5xx.doFilter(httpStatusCodes));
		System.out.println("\nSuccessor: ");
		printHttpStatusCodes(successor.doFilter(httpStatusCodes));
		System.out.println("\n1xx and 2xx: ");
		printHttpStatusCodes(code1xxAnd2xx.doFilter(httpStatusCodes));
		System.out.println("\n2xx and successor: ");
		printHttpStatusCodes(code2xxAndSuccessor.doFilter(httpStatusCodes));		
		System.out.println("\n4xx or 5xx: ");
		printHttpStatusCodes(code4xxOr5xx.doFilter(httpStatusCodes));
	}
	public static void printHttpStatusCodes(List<HttpStatusCode> httpStatusCodes){
		System.out.println("HttpStatusCode code, name, describe");
		for (HttpStatusCode httpStatusCode : httpStatusCodes) {
		   System.out.println("[ " + httpStatusCode.getCode() 
		      +",  " + httpStatusCode.getName() 
		      +",  " + httpStatusCode.getDescribe()
		      +" ]");
		}
	}
}//end FilterApp