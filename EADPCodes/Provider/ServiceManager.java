package Provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//ServiceManager�������������̬��Ա���ע�Ტ����ע���ı�׼�ӿ�IService
public class ServiceManager {

	private static String classname;
	
	public ServiceManager (){}
	//ConcurrentHashMap���̰߳�ȫ�������
    private static final Map<String, ServiceProviderImpl> providers = new ConcurrentHashMap<String, ServiceProviderImpl>();  
  
    public static void registerProvider(String classname, ServiceProviderImpl p) {  
        providers.put(classname, p); //key--classname;value--Object( new ServiceProviderImpl()) ---putע��
		setClassname(classname);
    }  
	public static void setClassname(String cn){
		classname = cn;
	}
    public static IService getConnection(String url, String username, String password) {  
  
        ServiceProviderImpl p = providers.get(classname); //get������� classname
  
        if (p == null) {  
            throw new IllegalArgumentException(  
                    "No provider registered with name: " + classname);  
        }  
  
        return p.getConnection(url, username, password);  
    }  
}