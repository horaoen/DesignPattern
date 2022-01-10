package SingletonApp;

import Singleton.Singleton;
/**
 * @author dll
 * @version 1.0
 * @created 28-2月-2020 18:09:13
 */
public class SingletonApp {

	public static void main(String[] args){
		Singleton s1=Singleton.Instance();
		Singleton s2=Singleton.Instance();
		System.out.println(s1);//@1b84c92
		System.out.println(s2);//@1b84c92  只有一个对象:s1和s2是同一对象
		//Singleton s3= new Singleton();
		//Singleton s4= new Singleton();
		//System.out.println(s3);//@1c7c054
		//System.out.println(s4);//@12204a1  s3和s4是不同一对象
	}
}//end SingletonApp