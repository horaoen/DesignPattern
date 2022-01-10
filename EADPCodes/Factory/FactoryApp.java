package Factory;


/**
 * @author dll
 * @version 1.0
 * @created 28-2月-2020 18:37:39
 */
public class FactoryApp {


	/**
	 * 客户程序与实现类解耦，面向接口编程
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		ConcreteProduct cp = new ConcreteProduct();//相对于从联想、戴尔生产工厂买电脑
		cp.Operation();
		
		Factory factory = new Factory();//Factory销售联想、戴尔等笔记本电脑的销售商
		Product p = factory.createProduct();//创建接口对象
		p.Operation();//调用接口实现类的方法
	}
}//end FactoryApp