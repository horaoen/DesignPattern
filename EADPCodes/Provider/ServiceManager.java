package Provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//ServiceManager服务管理器，静态成员完成注册并返回注册后的标准接口IService
public class ServiceManager {

	private static String classname;
	
	public ServiceManager (){}
	//ConcurrentHashMap多线程安全并发编程
    private static final Map<String, ServiceProviderImpl> providers = new ConcurrentHashMap<String, ServiceProviderImpl>();  
  
    public static void registerProvider(String classname, ServiceProviderImpl p) {  
        providers.put(classname, p); //key--classname;value--Object( new ServiceProviderImpl()) ---put注册
		setClassname(classname);
    }  
	public static void setClassname(String cn){
		classname = cn;
	}
    public static IService getConnection(String url, String username, String password) {  
  
        ServiceProviderImpl p = providers.get(classname); //get获得驱动 classname
  
        if (p == null) {  
            throw new IllegalArgumentException(  
                    "No provider registered with name: " + classname);  
        }  
  
        return p.getConnection(url, username, password);  
    }  
}