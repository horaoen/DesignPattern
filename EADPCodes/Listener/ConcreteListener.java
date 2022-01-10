package Listener;

public class ConcreteListener implements Listener {

	private String listenerState;
	
	public void Update(Event event){
		EventSource eventSource = event.GetEventSource();
		listenerState = eventSource.GetEventState();
		System.out.println("����������������Ӧ: " +listenerState);
	}
}