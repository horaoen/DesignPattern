package Flyweight;


/**
 * This class implements the Flyweight interface and adds storage for intrinsic
 * state, if any.
 * @author dll
 * @version 1.0
 * @created 23-2月-2020 22:03:12
 */
public class ConcreteFlyweight extends Flyweight {

	/**
	 * 
	 * @param intrinsicState
	 */
	public ConcreteFlyweight(Object intrinsicState){
		super(intrinsicState);
	}
	/**
	 * 
	 * @param extrinsicState
	 */
	public void Operation(Object extrinsicState){
		System.out.println("具体享元类，内部状态："+(String)intrinsicState+" 外部状态："+(String)extrinsicState);
	}
}//end ConcreteFlyweight