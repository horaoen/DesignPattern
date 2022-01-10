package Flyweight;


/**
 * This class declares an interface through which flyweights can receive and act
 * on extrinsic state.
 * @author dll
 * @version 1.0
 * @created 23-2月-2020 22:03:27
 */
public abstract class Flyweight {

	//内部状态
	protected Object intrinsicState;//食堂的餐具所有权属于学校
	
	public Flyweight(Object intrinsicState) {
		this.intrinsicState = intrinsicState;
	}

	/**
	 * 外部状态通过注入的方式传入共享类中
	 * @param extrinsicState
	 */
	public abstract void Operation(Object extrinsicState);//餐具使用权属于师生
}//end Flyweight