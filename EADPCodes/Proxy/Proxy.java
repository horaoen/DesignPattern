package Proxy;

import java.lang.Void;

public class Proxy extends Subject {

	private RealSubject realSubject;

	public Proxy(){
	}
	
	//��ǿ����AOP
	public void Request(){
		if (realSubject == null)
		   realSubject = new RealSubject();
		
		preRequest();
		realSubject.Request();
		postRequest();
		
	}
	public void preRequest(){
        System.out.println("����ѧ�ԣ������ڿ�ǰԤϰ!");
    }
    public void postRequest(){
        System.out.println("ѧ�Ի�˵����κ�Ҫ��ϰ!");
    }
}//end Proxy