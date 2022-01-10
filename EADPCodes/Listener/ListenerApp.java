package Listener;

public class ListenerApp {

    public static void main(String[] args) {
		
		ConcreteListener concreteListener = new ConcreteListener();
        EventSource eventSource = new EventSource();
        eventSource.Attach(concreteListener);
        eventSource.Notify();
		eventSource.SetEventState(" æ”º“∏Ù¿Î÷–!");
		eventSource.Notify();
    }
}
