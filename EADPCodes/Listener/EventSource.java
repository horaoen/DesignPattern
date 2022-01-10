package Listener;

public class EventSource{
	private Listener listener;

	public String eventState="�¼��ͼ������Ѿ���!";

	void SetEventState(String state){
		eventState=state;
	}
	String GetEventState(){
		return this.eventState;
	}
	public void Notify(){
		System.out.println("�¼����ڷ�����...");
		if(listener!=null){
			Event event = new Event();
			event.SetEventSource(this);
			listener.Update(event);
		}
	}
 

	public void Attach(Listener listener){
		this.listener=listener;
	}
}
