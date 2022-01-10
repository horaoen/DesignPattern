package Flyweight;


/**
 * Not all Flyweight subclasses need to be shared. The Flyweight interface enables
 * sharing; it doesn't enforce it.
 * @author dll
 * @version 1.0
 * @created 23-2��-2020 22:04:01
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
		System.out.println("������ľ�����Ԫ�࣬�ڲ�״̬��"+(String)intrinsicState+" �ⲿ״̬��"+(String)extrinsicState);
	}
}//end UnsharedConcreteFlyweight