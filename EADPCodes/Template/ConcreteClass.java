package TemplateMethod;

/**
 * This class implements the primitive operations to carry out subclass-specific
 * steps of the algorithm.
 * @author dll
 * @version 1.0
 * @created 01-5月-2020 11:37:57
 */
public class ConcreteClass extends AbstractClass {

	public void PrimitiveOperation1(){
		System.out.println("具体子类的继承或重写方法：PrimitiveOperation1\n");
	}

	public void PrimitiveOperation2(){
		System.out.println("具体子类的继承或重写方法：PrimitiveOperation2\n");
	}
}//end ConcreteClass