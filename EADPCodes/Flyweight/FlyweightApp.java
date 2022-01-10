package Flyweight;


/**
 * @author dll
 * @version 1.0
 * @created 23-2月-2020 22:16:26
 */
public class FlyweightApp {

	private static final String dbNames[] = {"MySQL","PG","Oracle","db4o","MongoDB"};
	private static final String actives[] = {"已连接","已断开","连接中..."};	

	public static void main(String[] args) {
		System.out.println("享元模式的连接池");
		for (int i = 0; i < 10; i++) {
            String dbname = dbNames[(int) (Math.random() * dbNames.length)];
			String active = actives[(int) (Math.random() * actives.length)];
            Flyweight flyweight = (Flyweight) FlyweightFactory.GetFlyweight((Object)dbname);//key内部因素
            flyweight.Operation((Object)active);//外部因素
        }
		FlyweightFactory.FlyweightSize();
		
		System.out.println("\n非享元模式的连接");
		UnsharedConcreteFlyweight unflyweight1 = new UnsharedConcreteFlyweight((Object)"DB2");
		unflyweight1.Operation((Object)"已连接");
		System.out.println(unflyweight1);
		UnsharedConcreteFlyweight unflyweight2 = new UnsharedConcreteFlyweight((Object)"DB2");
		unflyweight2.Operation((Object)"已连接");
		System.out.println(unflyweight2);
		
		System.out.println("\n\nJDK Flyweight \n");
		Integer int1 = 1000;
		Integer int2 = 1000;
		String str1="1234";
		String str2="123"+"4";
		
		System.out.println(int1==int2);//int 128--127 常量池
		System.out.println("int1= "+int1);
		System.out.println("int2= "+int2);
		System.out.println(str1==str2);//String对象，<128 常量池
		System.out.println("str1= "+str1);
		System.out.println("str2= "+str2);
	}
}//end FlyweightApp