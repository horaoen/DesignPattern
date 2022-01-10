package Observer;

public class ObserverApp {

	public static void main(String[] args) {      
		Subject subject=new ConcreteSubject();
        Observer obs=new ConcreteObserver((ConcreteSubject)subject);
        subject.Attach(obs);
		subject.Notify();
		((ConcreteSubject)subject).SetSubjectState(" æ”º“∏Ù¿Î÷–!");
        subject.Notify();
   }
}