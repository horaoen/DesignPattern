package Bridge;


/**
 * This class extends the interface defined by Abstraction.
 * @author dll
 * @version 1.0
 * @created 23-2��-2020 11:36:35
 */
public class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(){
	}
	@Override
	public void Operation() {
		System.out.println("��չ����(Refined Abstraction)��ɫ������" );
		super.getImplementor().OperationImp();
	}
}//end RefinedAbstraction