package ChainOfResponsibility;


/**
 * @author dll
 * @version 1.0
 * @created 25-2月-2020 9:21:21
 */
public class CORApp {

	public static void main(String[] args) {
		//组装责任链 
        Handler handler1=new ConcreteHandler1();
        Handler handler2=new ConcreteHandler2();
		Handler handler3=new ConcreteHandler3();
        handler1.setSuccessor(handler2);
		handler2.setSuccessor(handler3);
        //提交请求 
        handler1.HandleRequest(1);
		handler1.HandleRequest(2);
		handler1.HandleRequest(3);
		
		handler1.HandleRequest(4);//4为请求数字错误
		
		handler2.HandleRequest(1);//handler2为链首错误
		
		handler2.HandleRequest(2);
		handler2.HandleRequest(3);
		handler2.HandleRequest(4);)//4为请求数字错误
		System.out.println("\n");
		//进入处理与退出处理
		handler1.HandleRequest(1);//OK
		handler2.HandleRequest(1);//handler2为链首错误
		handler3.HandleRequest(1);//handler2为链首错误
		
		handler3.HandleRequest(1);//handler2为链首错误
		handler2.HandleRequest(1);//handler2为链首错误
		handler1.HandleRequest(1);//OK
	}
}//end CORApp