//package HibernateTemplate;
package TemplateMethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author dll
 * @version 1.0
 * @created 23-5ÔÂ-2020 8:25:58
 */
public abstract class HibernateAbstract {

	private static Configuration config;
	private static SessionFactory factory;
	protected static Session session;
	private static Transaction transaction;
	
	public static Session getSession() {
		return session;
	}

	public static Transaction getTransaction() {
		return transaction;
	}
	public static void init(){
		config = new Configuration().configure();
		factory = config.buildSessionFactory();
		session =factory.openSession();
		transaction=session.beginTransaction();
	}
	public static void closeAll() {
		transaction.commit();
		session.close();
		factory.close();
	}	

	public final void addTemplateMethod(User u){
		init();	
		addOpr(u);
		closeAll();
	}
	public abstract void addOpr(User u);

	public final void delTemplateMethod(int id){
		init();
		delOpr(id);
		closeAll();
	}
	public abstract void delOpr(int id);
	
	public final void  updTemplateMethod(int id, User u){
		init();
		updOpr(id, u);
		closeAll();
	}
	public abstract void updOpr(int id, User u);

	public final User queTemplateMethod(int id){
		init();
		
		User u = new User();
		u=queOpr(id);
		
		closeAll();
		return u;
	}
	public abstract User queOpr(int id);
}//end JdbcAbstract