package Factory;


/**
 * @author dll
 * @version 1.0
 * @created 28-2��-2020 18:37:26
 */
public class Factory {

	public Factory(){
	}
	public Product createProduct(){
		return new ConcreteProduct();//ʹ��new��������
	}
}//end Factory