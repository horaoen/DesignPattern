package Factory;


/**
 * @author dll
 * @version 1.0
 * @created 28-2月-2020 18:37:26
 */
public class Factory {

	public Factory(){
	}
	public Product createProduct(){
		return new ConcreteProduct();//使用new创建对象
	}
}//end Factory