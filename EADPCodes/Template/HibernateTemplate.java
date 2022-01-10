//package HibernateTemplate;
package TemplateMethod;

import org.hibernate.Session;

public class HibernateTemplate extends HibernateAbstract {

	public HibernateTemplate(){}
	
	public void addOpr(User u){
		session.save(u);
	}

	public void delOpr(int id){
		User u = (User) session.get(User.class, id); 
		if(u!=null)
			session.delete(u);
		else
			System.out.println("Id="+id+" Is Not Exist!");
	}

	public void updOpr(int id, User u){
		User user = (User) session.get(User.class, id); 
		if(user!=null)
			session.update(u);	//Bug???
		else
			System.out.println("Id="+id+" Is Not Exist!");
	}

	public User queOpr(int id){
		User u = new User();
		u = (User) session.get(User.class, id); 
		if(null==u){
			System.out.println("Id="+id+" Is Not Exist!");
			return null;
		}
		return u;
	}
}//end HibernateTemplate