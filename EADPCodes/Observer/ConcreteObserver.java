package Observer;

public class ConcreteObserver extends Observer {

	private String observerState;
	private ConcreteSubject subject;

	public ConcreteObserver(ConcreteSubject subject){
		this.subject = subject;
	}

	public void Update(){
		observerState = subject.subjectState;
		System.out.println("����۲���������Ӧ: " +observerState);
	}
}