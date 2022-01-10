package TemplateMethod;

/**
 * This class (a) defines abstract primitive operations that concrete subclasses
 * define to implement steps of an algorithm, and (b) implements a template method
 * defining the skeleton of an algorithm.
 * @author dll
 * @version 1.0
 * @created 01-5月-2020 11:37:41
 */
public abstract class AbstractClass {

	public void TemplateMethod(){
		//// do something
		System.out.println("抽象类的模板方法：SpecificOperation1\n");
		PrimitiveOperation1();
		//// do something
		System.out.println("抽象类的模板方法：SpecificOperation2\n");
		PrimitiveOperation2();
		//// do something
	}

	public abstract void PrimitiveOperation1();

	public abstract void PrimitiveOperation2();
}//end AbstractClass