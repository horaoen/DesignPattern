package Flyweight;

import java.util.Map;
import java.util.HashMap;

/**
 * This class (a) creates and manages flyweight objects, and (b) ensures that
 * flyweights are shared properly.
 * @author dll
 * @version 1.0
 * @created 23-2��-2020 22:03:44
 */
public class FlyweightFactory {

	private static final Map<String, Flyweight> flyweights = new HashMap<>();//key��ͬ��Java������

	public static Flyweight GetFlyweight(Object key){
		Flyweight flyweight = (Flyweight) flyweights.get((String)key);//��Map��ȡ��Ԫ��
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight((String)key);//���ù���ľ�����Ԫ���ഴ��
            System.out.println(" ����������: " + (String)key);
            flyweights.put((String)key, flyweight);//�����Ԫ�ൽMap
        }
		else{
			System.out.println(" ʹ�����ӳ�: " + (String)key);//ʹ�ó��еĹ�����
		}
		System.out.println(flyweight);
		return 	flyweight;
	}
	
	public static void FlyweightSize(){
		System.out.println("��Ԫģʽ�����ӳ�: "+flyweights.size());//���ӳش��С���������ٸ������
	}
}//end FlyweightFactory