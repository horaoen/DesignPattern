package Flyweight;


/**
 * Not all Flyweight subclasses need to be shared. The Flyweight interface enables
 * sharing; it doesn't enforce it.
 * @author dll
 * @version 1.0
 * @created 23-2月-2020 22:04:01
 */
public class UnsharedConcreteFlyweight extends Flyweight {

	/**
	 * 
	 * @param intrinsicState
	 */
	public UnsharedConcreteFlyweight(Object intrinsicState) {
		super(intrinsicState);
	}
	/**
	 * 
	 * @param extrinsicState
	 */
	public void Operation(Object extrinsicState){
		System.out.println("不共享的具体享元类，内部状态："+(String)intrinsicState+" 外部状态："+(String)extrinsicState);
	}
}//end UnsharedConcreteFlyweight