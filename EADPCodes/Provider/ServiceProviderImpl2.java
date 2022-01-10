package Provider;


/**
 * @author dll
 * @version 1.0
 * @created 01-4月-2020 10:40:44
 */
public class ServiceProviderImpl2 implements IServiceProvider {

	//静态代码块，注册服务提供者即将自己保存到内存中，客户程序调用Class.forName完成注册Provider.ServiceProviderImpl2
	static {  
        ServiceManager2.registerProvider("Provider.ServiceProviderImpl", new ServiceProviderImpl2());  //org.postgresql.Driver
    }
	public IService getConnection(String url, String username, String password){
		return new ServiceImpl(url, username, password);
	}
}//end ServiceProviderImpl2