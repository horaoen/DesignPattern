package Bridge;


/**
 * This class (a) defines the abstraction's interface, and (b) maintains a
 * reference to an object of type Implementor.
 * @author dll
 * @version 1.0
 * @created 23-2月-2020 11:35:15
 */
public abstract class Abstraction {

	protected Implementor implementor;//# 聚合关系：Abstraction由Implementor聚合而成

	public Implementor getImplementor(){
		return implementor;
	}
	
	public void setImplementor(Implementor impl){
		this.implementor=impl;
	}

	public Abstraction(){
	}
	
	public void Operation(){
		implementor.OperationImp();//implementor.OperationImp：桥。Abstraction爷爷辈继承Implementor父辈继承ConcreteImplementorA子代
	}
}//end Abstraction