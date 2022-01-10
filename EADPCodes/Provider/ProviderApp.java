package Provider;

public class ProviderApp {
	public static void main(String[] args){
		mainMySQL(args);
		mainPostgreSQL(args);
	}

	public static void mainMySQL(String[] args){
		try{
			Class.forName("Provider.ServiceProviderImpl"); //"com.mysql.jdbc.Driver" 
		}catch(Exception e){
			e.printStackTrace(); 
		}
		//IService===Connection  ServiceManager===DriverManager
        IService is = ServiceManager.getConnection("jdbc:mysql://192.168.56.116:8080", "root", "password");//DriverManager  
		//starement\preparestarement
		//ResultSet
		if(is.Connection())
			System.out.println("Connection OK");
		else
			System.out.println("Connection Failed");
	}
	public static void mainPostgreSQL(String[] args){
		try{
			Class.forName("Provider.ServiceProviderImpl2"); //"org.postgresql.Driver" 
		}catch(Exception e){
			e.printStackTrace(); 
		}
        IService is = ServiceManager.getConnection("jdbc:postgresql://192.168.56.116:8080", "root", "password");//DriverManager  
		if(is.Connection())
			System.out.println("Connection OK");
		else
			System.out.println("Connection Failed");
	}
}