package Observer;

public class ConcreteSubject extends Subject {

	public String subjectState="Ŀ��͹۲����Ѿ���!";

	public ConcreteSubject(){
	}
	void SetSubjectState(String state){
		subjectState=state;
	}
	@Override
	public void Notify(){
		System.out.println("����Ŀ�귢���ı�...");
		super.Notify();
	}
}