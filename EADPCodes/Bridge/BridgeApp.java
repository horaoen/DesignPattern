package Bridge;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author dll
 * @version 1.0
 * @created 23-2��-2020 12:09:03
 */
public class BridgeApp {

	public static void main(String[] args){
		System.out.println("������ʵ�ַ��룬�����Ž�ģʽ");
		main0(args);
		System.out.println("\nû�г���ֱ��ʵ�ָ�������");
		main1(args);
		try{
			System.out.println("\n������ʵ�ַ��룬�����Ž�ģʽ��Class.forName����Ӧ��");
			main2(args);
		}catch(Exception e){}
		try{
			System.out.println("\nClass.forName����Ӧ��,�������ļ���ȡʵ�����������������չ��");
			main3(args);
		}catch(Exception e){}
	}
	//������ʵ�ַ��룬�����Ž�ģʽ
	public static void main0(String[] args) {
		Abstraction abstraction = new RefinedAbstraction();

		//���õ�һ��ʵ��������MySQL
		abstraction.setImplementor(new ConcreteImplementorA());
		abstraction.Operation();

		//���õڶ���ʵ����PG
		abstraction.setImplementor(new ConcreteImplementorB());
		abstraction.Operation();
		
		//���õ�����ʵ����SQLite
		abstraction.setImplementor(new ConcreteImplementorC());
		abstraction.Operation();
	}
	//û�г���ֱ��ʵ�ָ�������
	public static void main1(String[] args) {

		//���õ�һ��ʵ��������MySQL
		Implementor implA= new ConcreteImplementorA();
		implA.OperationImp();

		//���õڶ���ʵ����PG
		Implementor implB= new ConcreteImplementorB();
		implB.OperationImp();

		//���õ�����ʵ����SQLite
		Implementor implC= new ConcreteImplementorC();
		implC.OperationImp();

	}
	//������ʵ�ַ��룬�����Ž�ģʽ��Class.forName����Ӧ��
	public static void main2(String[] args) throws Exception {
		Abstraction abstraction = new RefinedAbstraction();

		//���õ�����ʵ����SQLite
		//abstraction.setImplementor(new ConcreteImplementorC());//����Java����Class.forName����ʵ�ִ�������
		abstraction.setImplementor((Implementor)Class.forName("Bridge.ConcreteImplementorC").newInstance());
		abstraction.Operation();
	}
	//������ʵ�ַ��룬�����Ž�ģʽ��Class.forName����Ӧ��
	public static void main3(String[] args) throws Exception {
		Abstraction abstraction = new RefinedAbstraction();

		
		//���õ��ĸ�ʵ����MS SQL Server
		abstraction.setImplementor((Implementor)Class.forName(getConcreteImplementorDName()).newInstance());
		abstraction.Operation();
	}
	public static String getConcreteImplementorDName() {
		String basePath = "resources/bridge.properties";
		String cname = "";
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(new File(basePath)));
            Properties prop = new Properties();
            prop.load(in);
            cname = prop.getProperty("bridge");
        } catch (FileNotFoundException e) {
            System.out.println("properties�ļ�·����д�������飡");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return cname;
    }

}//end BridgeApp