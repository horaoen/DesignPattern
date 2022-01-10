package Factory;


/**
 * @author dll
 * @version 1.0
 * @created 28-2��-2020 18:37:39
 */
public class FactoryApp {


	/**
	 * �ͻ�������ʵ����������ӿڱ��
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		ConcreteProduct cp = new ConcreteProduct();//����ڴ����롢�����������������
		cp.Operation();
		
		Factory factory = new Factory();//Factory�������롢�����ȱʼǱ����Ե�������
		Product p = factory.createProduct();//�����ӿڶ���
		p.Operation();//���ýӿ�ʵ����ķ���
	}
}//end FactoryApp