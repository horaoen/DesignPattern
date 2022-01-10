package ChainOfResponsibility;

/**
 * This class defines an interface for handling requests and optionally implements
 * the successor link.
 * @author dll
 * @version 1.0
 * @created 25-2��-2020 9:20:15
 */
public abstract class Handler {

	protected Handler successor=null;//next���ã�pointerָ����ã��γ���

	/**
	 * 
	 * @param successor
	 */
	public void setSuccessor(Handler successor){
		this.successor = successor;
	}
    public Handler getSuccessor(){ 
        return successor; 
    } 
	/**
	 * 
	 * @param request
	 */
	public abstract void HandleRequest(int request);
}//end Handler