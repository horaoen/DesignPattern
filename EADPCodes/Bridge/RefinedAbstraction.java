package Bridge;


/**
 * This class extends the interface defined by Abstraction.
 * @author dll
 * @version 1.0
 * @created 23-2月-2020 11:36:35
 */
public class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(){
	}
	@Override
	public void Operation() {
		System.out.println("扩展抽象化(Refined Abstraction)角色被访问" );
		super.getImplementor().OperationImp();
	}
}//end RefinedAbstraction