//package HibernateTemplate;
package TemplateMethod;

public class HibernateTemplateApp {

	public HibernateTemplate m_HibernateTemplate;
	public HibernateTemplateApp(){
		m_HibernateTemplate=new HibernateTemplate();
	}
	
	public void HibernateTemplateCRUD() {
		User u = new User("root", "password");
		int id=25;
		m_HibernateTemplate.addTemplateMethod(u);
		
		User u1=m_HibernateTemplate.queTemplateMethod(id-1);
		
		u1.setName("uname");
		u1.setPass("upwd");
		m_HibernateTemplate.updTemplateMethod(id-1,u1);
		
		m_HibernateTemplate.delTemplateMethod(id+1);
	}
}//end HibernateTemplateApp