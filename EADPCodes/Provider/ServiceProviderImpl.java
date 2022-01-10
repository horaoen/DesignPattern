package Provider;
//ConnectionProviderImpl
public class ServiceProviderImpl implements IServiceProvider {
	//��̬����飬ע������ṩ�߼����Լ����浽�ڴ��У��ͻ��������Class.forName���ע��Provider.ServiceProviderImpl
	static {  
        ServiceManager.registerProvider("Provider.ServiceProviderImpl", new ServiceProviderImpl());  //com.mysql.jdbc.Driver
    }
	//���ر�׼�ӿ�IService
	public IService getConnection(String url, String username, String password){
		return new ServiceImpl(url, username, password);
	}
}