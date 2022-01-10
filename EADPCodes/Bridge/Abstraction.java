package Bridge;


/**
 * This class (a) defines the abstraction's interface, and (b) maintains a
 * reference to an object of type Implementor.
 * @author dll
 * @version 1.0
 * @created 23-2��-2020 11:35:15
 */
public abstract class Abstraction {

	protected Implementor implementor;//# �ۺϹ�ϵ��Abstraction��Implementor�ۺ϶���

	public Implementor getImplementor(){
		return implementor;
	}
	
	public void setImplementor(Implementor impl){
		this.implementor=impl;
	}

	public Abstraction(){
	}
	
	public void Operation(){
		implementor.OperationImp();//implementor.OperationImp���š�Abstractionүү���̳�Implementor�����̳�ConcreteImplementorA�Ӵ�
	}
}//end Abstraction