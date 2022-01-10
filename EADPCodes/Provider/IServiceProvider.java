package Provider;
//ConnectionProvider
public interface IServiceProvider {
	public IService getConnection(String url, String username, String password);
}