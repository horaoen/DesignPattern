package Listener;

public class EventSource{
	private Listener listener;

	public String eventState="事件和监听器已经绑定!";

	void SetEventState(String state){
		eventState=state;
	}
	String GetEventState(){
		return this.eventState;
	}
	public void Notify(){
		System.out.println("事件正在发生中...");
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
