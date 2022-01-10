package Bridge;


/**
 * This class implements the Implementor interface and defines its concrete
 * implementation.
 * @author dll
 * @version 1.0
 * @created 23-2月-2020 11:35:26
 */
public class ConcreteImplementorA extends Implementor {

	public ConcreteImplementorA(){

	}
	public void OperationImp(){
		System.out.println("具体实现化(Concrete Implementor)角色被访问" );
		System.out.println("OperationImpA: MySQLConnection MySQL DataBase");
	}
}//end ConcreteImplementorA