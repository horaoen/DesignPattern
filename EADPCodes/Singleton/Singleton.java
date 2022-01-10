package Singleton;

public class Singleton {

	private static Singleton instance;

	protected Singleton(){	}//ͬ�ࡢͬ��

	public static Singleton Instance(){
		if( instance == null )
		     instance = new Singleton();	
		return instance;
	}
	public static void main(String[] args){
		Singleton s1=Singleton.Instance();
		Singleton s2=Singleton.Instance();
		System.out.println(s1);//@1b84c92
		System.out.println(s2);//@1b84c92  ֻ��һ������:s1��s2��ͬһ����
		Singleton s3= new Singleton();
		Singleton s4= new Singleton();
		System.out.println(s3);//@1c7c054
		System.out.println(s4);//@12204a1  s3��s4�ǲ�ͬһ����
	}
}