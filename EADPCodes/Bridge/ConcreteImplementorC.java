package Bridge;


/**
 * @author dll
 * @version 1.0
 * @created 23-2月-2020 12:41:50
 */
public class ConcreteImplementorC extends Implementor {

	public ConcreteImplementorC(){

	}
	public void OperationImp(){
		System.out.println("具体实现化(Concrete Implementor)角色被访问" );
		System.out.println("OperationImpC: SQLiteConnection SpatialSQLite DataBase");
	}
}//end ConcreteImplementorC