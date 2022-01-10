package ChainOfResponsibility;


/**
 * @author dll
 * @version 1.0
 * @created 25-2��-2020 9:21:21
 */
public class CORApp {

	public static void main(String[] args) {
		//��װ������ 
        Handler handler1=new ConcreteHandler1();
        Handler handler2=new ConcreteHandler2();
		Handler handler3=new ConcreteHandler3();
        handler1.setSuccessor(handler2);
		handler2.setSuccessor(handler3);
        //�ύ���� 
        handler1.HandleRequest(1);
		handler1.HandleRequest(2);
		handler1.HandleRequest(3);
		
		handler1.HandleRequest(4);//4Ϊ�������ִ���
		
		handler2.HandleRequest(1);//handler2Ϊ���״���
		
		handler2.HandleRequest(2);
		handler2.HandleRequest(3);
		handler2.HandleRequest(4);)//4Ϊ�������ִ���
		System.out.println("\n");
		//���봦�����˳�����
		handler1.HandleRequest(1);//OK
		handler2.HandleRequest(1);//handler2Ϊ���״���
		handler3.HandleRequest(1);//handler2Ϊ���״���
		
		handler3.HandleRequest(1);//handler2Ϊ���״���
		handler2.HandleRequest(1);//handler2Ϊ���״���
		handler1.HandleRequest(1);//OK
	}
}//end CORApp