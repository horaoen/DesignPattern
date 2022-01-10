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
 * @created 23-2月-2020 12:09:03
 */
public class BridgeApp {

	public static void main(String[] args){
		System.out.println("抽象与实现分离，基础桥接模式");
		main0(args);
		System.out.println("\n没有抽象，直接实现各种连接");
		main1(args);
		try{
			System.out.println("\n抽象与实现分离，基础桥接模式，Class.forName方法应用");
			main2(args);
		}catch(Exception e){}
		try{
			System.out.println("\nClass.forName方法应用,从配置文件读取实现类名，体现灵活扩展性");
			main3(args);
		}catch(Exception e){}
	}
	//抽象与实现分离，基础桥接模式
	public static void main0(String[] args) {
		Abstraction abstraction = new RefinedAbstraction();

		//调用第一个实现类连接MySQL
		abstraction.setImplementor(new ConcreteImplementorA());
		abstraction.Operation();

		//调用第二个实现类PG
		abstraction.setImplementor(new ConcreteImplementorB());
		abstraction.Operation();
		
		//调用第三个实现类SQLite
		abstraction.setImplementor(new ConcreteImplementorC());
		abstraction.Operation();
	}
	//没有抽象，直接实现各种连接
	public static void main1(String[] args) {

		//调用第一个实现类连接MySQL
		Implementor implA= new ConcreteImplementorA();
		implA.OperationImp();

		//调用第二个实现类PG
		Implementor implB= new ConcreteImplementorB();
		implB.OperationImp();

		//调用第三个实现类SQLite
		Implementor implC= new ConcreteImplementorC();
		implC.OperationImp();

	}
	//抽象与实现分离，基础桥接模式，Class.forName方法应用
	public static void main2(String[] args) throws Exception {
		Abstraction abstraction = new RefinedAbstraction();

		//调用第三个实现类SQLite
		//abstraction.setImplementor(new ConcreteImplementorC());//采用Java反射Class.forName方法实现创建对象
		abstraction.setImplementor((Implementor)Class.forName("Bridge.ConcreteImplementorC").newInstance());
		abstraction.Operation();
	}
	//抽象与实现分离，基础桥接模式，Class.forName方法应用
	public static void main3(String[] args) throws Exception {
		Abstraction abstraction = new RefinedAbstraction();

		
		//调用第四个实现类MS SQL Server
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
            System.out.println("properties文件路径书写有误，请检查！");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return cname;
    }

}//end BridgeApp