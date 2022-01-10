package Factory;


/**
 * This class implements the Product interface.
 * @author dll
 * @version 1.0
 * @created 28-2月-2020 18:36:54
 */
public class ConcreteProduct implements Product {

	public ConcreteProduct(){
	}

	public void Operation(){
		System.out.println("这里是Product接口的具体实现类，通过接口Product隔离具体实现");
	}
}//end ConcreteProduct