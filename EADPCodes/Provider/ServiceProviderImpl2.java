package Provider;


/**
 * @author dll
 * @version 1.0
 * @created 01-4��-2020 10:40:44
 */
public class ServiceProviderImpl2 implements IServiceProvider {

	//��̬����飬ע������ṩ�߼����Լ����浽�ڴ��У��ͻ��������Class.forName���ע��Provider.ServiceProviderImpl2
	static {  
        ServiceManager2.registerProvider("Provider.ServiceProviderImpl", new ServiceProviderImpl2());  //org.postgresql.Driver
    }
	public IService getConnection(String url, String username, String password){
		return new ServiceImpl(url, username, password);
	}
}//end ServiceProviderImpl2