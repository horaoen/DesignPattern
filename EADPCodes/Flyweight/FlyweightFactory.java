package Flyweight;

import java.util.Map;
import java.util.HashMap;

/**
 * This class (a) creates and manages flyweight objects, and (b) ensures that
 * flyweights are shared properly.
 * @author dll
 * @version 1.0
 * @created 23-2月-2020 22:03:44
 */
public class FlyweightFactory {

	private static final Map<String, Flyweight> flyweights = new HashMap<>();//key不同，Java集合类

	public static Flyweight GetFlyweight(Object key){
		Flyweight flyweight = (Flyweight) flyweights.get((String)key);//从Map获取享元类
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight((String)key);//调用共享的具体享元子类创建
            System.out.println(" 创建新连接: " + (String)key);
            flyweights.put((String)key, flyweight);//存放享元类到Map
        }
		else{
			System.out.println(" 使用连接池: " + (String)key);//使用池中的共享类
		}
		System.out.println(flyweight);
		return 	flyweight;
	}
	
	public static void FlyweightSize(){
		System.out.println("享元模式的连接池: "+flyweights.size());//连接池大大小即创建多少个类对象
	}
}//end FlyweightFactory