package Bridge;


/**
 * @author dll
 * @version 1.0
 * @created 29-2月-2020 15:27:40
 */
public class ConcreteImplementorD extends Implementor {

	public ConcreteImplementorD(){

	}

	public void OperationImp(){
		System.out.println("具体实现化(Concrete Implementor)角色被访问" );
		System.out.println("OperationImpD: MSSQLServerConnection MS SQL Server DataBase");
	}
}//end ConcreteImplementorD