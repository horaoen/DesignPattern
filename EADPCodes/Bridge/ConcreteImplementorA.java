package Bridge;


/**
 * This class implements the Implementor interface and defines its concrete
 * implementation.
 * @author dll
 * @version 1.0
 * @created 23-2��-2020 11:35:26
 */
public class ConcreteImplementorA extends Implementor {

	public ConcreteImplementorA(){

	}
	public void OperationImp(){
		System.out.println("����ʵ�ֻ�(Concrete Implementor)��ɫ������" );
		System.out.println("OperationImpA: MySQLConnection MySQL DataBase");
	}
}//end ConcreteImplementorA