package Provider;
//ConnectionImpl
public class ServiceImpl implements IService {
	String url;
	String username;
	String password;
	
	public ServiceImpl(String url, String un, String pw){
		this.url=url;
		this.username=un;
		this.password=pw;
	}

	public boolean Connection(){
		System.out.println("Test Connection : URL="+url+" UserName="+username+" PassWord="+password); 
		if(url.equals("jdbc:mysql://192.168.56.116:8080") && username.equals("root")&&password.equals("password"))
			return true;
		else if(url.equals("jdbc:postgresql://192.168.56.116:8080") && username.equals("root")&&password.equals("password"))
			return true;
		else
			return false;
	}
}