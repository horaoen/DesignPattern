package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DefaultConnectionFactory implements ConnectionFactory {


  public DefaultConnectionFactory() {
  }

  public Connection getConnection() {
    ConnectionProperty cp = ConnectionProperty.getInstance();
    Connection conn = null;
    try {
		Class.forName( cp.getDriverClassName() );//没有注册驱动CLass.forName的常量; DriverManager.getConnection的常量
		conn = DriverManager.getConnection( cp.getUrl() ,
		                                      cp.getUser(),
		                                      cp.getPassword() );
	} catch (ClassNotFoundException e) {
		//System.out.println("未能正常创建数据库连接，请检查驱动及配置文件！\n");
		//e.printStackTrace();
	} catch (SQLException e) {
		//System.out.println("未能正常访问数据，请检查驱动及配置文件！\n");
		//e.printStackTrace();
	}finally{
		if(conn==null){
			System.out.println("创建数据库连接失败，请检查驱动及配置文件！\n");
			System.out.println("请按任意键继续");
			Scanner input = new Scanner(System.in);
			String str = input.next();
			System.exit(0);
		}
	}
    return conn;
  }
}