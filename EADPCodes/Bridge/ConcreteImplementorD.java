package Bridge;


/**
 * @author dll
 * @version 1.0
 * @created 29-2��-2020 15:27:40
 */
public class ConcreteImplementorD extends Implementor {

	public ConcreteImplementorD(){

	}

	public void OperationImp(){
		System.out.println("����ʵ�ֻ�(Concrete Implementor)��ɫ������" );
		System.out.println("OperationImpD: MSSQLServerConnection MS SQL Server DataBase");
	}
}//end ConcreteImplementorD