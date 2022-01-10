package Bridge;


/**
 * This class implements the Implementor interface and defines its concrete
 * implementation.
 * @author dll
 * @version 1.0
 * @created 23-2��-2020 11:35:38
 */
public class ConcreteImplementorB extends Implementor {

	public ConcreteImplementorB(){

	}
	public void OperationImp(){
		System.out.println("����ʵ�ֻ�(Concrete Implementor)��ɫ������" );
		System.out.println("OperationImpB: PGConnection PostgreSQL/PostGIS DataBase");
	}
}//end ConcreteImplementorB