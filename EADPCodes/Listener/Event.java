package Listener;

public class Event {

	EventSource eventSource;
	
	public void SetEventSource(EventSource eventSource){
		this.eventSource=eventSource;
	}
	public EventSource GetEventSource(){
		return this.eventSource;
	}
}