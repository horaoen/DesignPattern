package Observer;

import java.util.List;
import java.util.ArrayList;

public abstract class Subject {

	protected List<Observer> observers=new ArrayList<Observer>();  

	public void Attach(Observer observer){
		observers.add(observer);
	}
	public void Detach(Observer observer){
		observers.remove(observer);
	}
	public void Notify(){
		for( Observer o : observers ) 
			o.Update();
	}
}