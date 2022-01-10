package Prototype;


/**
 * This class implements an operation for cloning itself.
 * @author dll
 * @version 1.0
 * @created 01-5ÔÂ-2020 10:24:38
 */
public class ConcretePrototype2 extends Prototype {

	public ConcretePrototype2(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public Prototype Clone(){
		//return this.Clone();

		return null;
	}
}//end ConcretePrototype2