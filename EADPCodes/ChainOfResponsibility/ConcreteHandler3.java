package ChainOfResponsibility;


/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2��-2020 10:27:34
 */
public class ConcreteHandler3 extends Handler {

	public ConcreteHandler3(){

	}
	/**
	 * 
	 * @param request
	 */
	public void HandleRequest(int request){
		if(request==3) {
            System.out.println("ConcreteHandler3 ������ " + request + " ����");       
        }
		else{
            if(getSuccessor() != null) {
                getSuccessor().HandleRequest(request);             
            }
            else{
                System.out.println("û���γ���ȷ����������������������1��2��3������"+ request + " ����ʧ�ܣ�����handler1�Ƿ�Ϊ���ף�");
            }
        } 
	}
}//end ConcreteHandler3