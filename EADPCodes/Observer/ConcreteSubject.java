package Observer;

public class ConcreteSubject extends Subject {

	public String subjectState="目标和观察者已经绑定!";

	public ConcreteSubject(){
	}
	void SetSubjectState(String state){
		subjectState=state;
	}
	@Override
	public void Notify(){
		System.out.println("具体目标发生改变...");
		super.Notify();
	}
}