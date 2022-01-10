package ChainOfResponsibility;


/**
 * This class (a) handles requests it is responsible for, (b) can access its
 * successor, and (c) if it can handle the request, does so, else it forwards it
 * to its successor.
 * @author dll
 * @version 1.0
 * @created 25-2月-2020 10:27:34
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
            System.out.println("ConcreteHandler3 负责处理 " + request + " 请求！");       
        }
		else{
            if(getSuccessor() != null) {
                getSuccessor().HandleRequest(request);             
            }
            else{
                System.out.println("没有形成正确的责任链，或者请求代码非1或2或3，处理"+ request + " 请求失败！请检查handler1是否为链首？");
            }
        } 
	}
}//end ConcreteHandler3