package Proxy;

import java.lang.Void;

public class Proxy extends Subject {

	private RealSubject realSubject;

	public Proxy(){
	}
	
	//增强处理：AOP
	public void Request(){
		if (realSubject == null)
		   realSubject = new RealSubject();
		
		preRequest();
		realSubject.Request();
		postRequest();
		
	}
	public void preRequest(){
        System.out.println("我是学霸，请你在课前预习!");
    }
    public void postRequest(){
        System.out.println("学霸还说，你课后还要复习!");
    }
}//end Proxy