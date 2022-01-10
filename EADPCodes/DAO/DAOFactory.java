package DAO;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DAOFactory {

	private static IDAO iDao = null;//DAOģʽ�������
	private static ICityDAO iCityDAO = null;
	private static IRiverDAO iRiverDAO = null;
	private static ILakeDAO iLakeDAO = null;
	
	private static DAOFactory instance = new DAOFactory();//����ģʽ

	private static Properties pro;//��̬�����ܸ�ֵΪnull
	
	private ConnectionFactory connectionFactory = null;
	
	public ConnectionFactory getConnectionFactory(){
		if(connectionFactory == null){
			connectionFactory =	new DefaultConnectionFactory();
		}
		return connectionFactory;
	}

	private DAOFactory(){//˽�еĹ��췽��
		InputStream inputStream=null;
		try {
			pro = new Properties();
			inputStream = DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			pro.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}finally{
			try{
				if (inputStream != null) inputStream.close();
				}catch (Exception e){}
		}
	}

	public static DAOFactory getInstance(){//ȫ�ַ��ʵ�
		return instance;
	}

	public IDAO getIDAO(String Key){//"IDao"==DAOImpl
		try {
			String className=(String) pro.get(Key);
			iDao = (IDAO) Class.forName(className).newInstance();//����ע�����ݿ������Ĵ���
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return iDao;
	}
	
	public ICityDAO getICityDAO(String Key){
		try {
			String className=(String) pro.get(Key);
			iCityDAO = (ICityDAO) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return iCityDAO;
	}
	public IRiverDAO getIRiverDAO(String Key){
		try {
			String className=(String) pro.get(Key);
			iRiverDAO = (IRiverDAO) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return iRiverDAO;
	}
	public ILakeDAO getILakeDAO(String Key){
		try {
			String className=(String) pro.get(Key);
			iLakeDAO = (ILakeDAO) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return iLakeDAO;
	}
}//end DAOFactory