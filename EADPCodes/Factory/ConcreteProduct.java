package Factory;


/**
 * This class implements the Product interface.
 * @author dll
 * @version 1.0
 * @created 28-2��-2020 18:36:54
 */
public class ConcreteProduct implements Product {

	public ConcreteProduct(){
	}

	public void Operation(){
		System.out.println("������Product�ӿڵľ���ʵ���࣬ͨ���ӿ�Product�������ʵ��");
	}
}//end ConcreteProduct