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
		Class.forName( cp.getDriverClassName() );//û��ע������CLass.forName�ĳ���; DriverManager.getConnection�ĳ���
		conn = DriverManager.getConnection( cp.getUrl() ,
		                                      cp.getUser(),
		                                      cp.getPassword() );
	} catch (ClassNotFoundException e) {
		//System.out.println("δ�������������ݿ����ӣ����������������ļ���\n");
		//e.printStackTrace();
	} catch (SQLException e) {
		//System.out.println("δ�������������ݣ����������������ļ���\n");
		//e.printStackTrace();
	}finally{
		if(conn==null){
			System.out.println("�������ݿ�����ʧ�ܣ����������������ļ���\n");
			System.out.println("�밴���������");
			Scanner input = new Scanner(System.in);
			String str = input.next();
			System.exit(0);
		}
	}
    return conn;
  }
}