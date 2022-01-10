package Provider;
//ConnectionProviderImpl
public class ServiceProviderImpl implements IServiceProvider {
	//静态代码块，注册服务提供者即将自己保存到内存中，客户程序调用Class.forName完成注册Provider.ServiceProviderImpl
	static {  
        ServiceManager.registerProvider("Provider.ServiceProviderImpl", new ServiceProviderImpl());  //com.mysql.jdbc.Driver
    }
	//返回标准接口IService
	public IService getConnection(String url, String username, String password){
		return new ServiceImpl(url, username, password);
	}
}