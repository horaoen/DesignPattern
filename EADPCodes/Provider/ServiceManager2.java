package Provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//ServiceManager服务管理器，静态成员完成注册并返回注册后的标准接口IService
public class ServiceManager2 {

	private static String classname;
	
	public ServiceManager2 (){}
	//ConcurrentHashMap多线程安全并发编程
    private static final Map<String, ServiceProviderImpl2> providers = new ConcurrentHashMap<String, ServiceProviderImpl2>();  
  
    public static void registerProvider(String classname, ServiceProviderImpl2 p) {  
        providers.put(classname, p);  
		setClassname(classname);
    }  
	public static void setClassname(String cn){
		classname = cn;
	}
    public static IService getConnection(String url, String username, String password) {  
  
        ServiceProviderImpl2 p = providers.get(classname);  
  
        if (p == null) {  
            throw new IllegalArgumentException(  
                    "No provider registered with name:" + classname);  
        }  
  
        return p.getConnection(url, username, password);  
    }  
}