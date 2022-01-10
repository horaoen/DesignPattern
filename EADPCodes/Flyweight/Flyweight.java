package Flyweight;


/**
 * This class declares an interface through which flyweights can receive and act
 * on extrinsic state.
 * @author dll
 * @version 1.0
 * @created 23-2��-2020 22:03:27
 */
public abstract class Flyweight {

	//�ڲ�״̬
	protected Object intrinsicState;//ʳ�õĲ;�����Ȩ����ѧУ
	
	public Flyweight(Object intrinsicState) {
		this.intrinsicState = intrinsicState;
	}

	/**
	 * �ⲿ״̬ͨ��ע��ķ�ʽ���빲������
	 * @param extrinsicState
	 */
	public abstract void Operation(Object extrinsicState);//�;�ʹ��Ȩ����ʦ��
}//end Flyweight