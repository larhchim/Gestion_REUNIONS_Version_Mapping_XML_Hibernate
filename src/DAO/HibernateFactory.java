
package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class HibernateFactory{

	private static SessionFactory sessionFactory = null;
	static
	{
	try
	{
	//sessionFactory = new Configuration().configure().buildSessionFactory();
	sessionFactory = new Configuration().configure("personne.cfg.xml").buildSessionFactory();
	}
	catch (HibernateException ex)
	{
	System.err.println("Initial SessionFactory creation failed." + ex);
	}
	}
	
	
	public static SessionFactory getSessionFactory()
	{
	return sessionFactory;
	}
	
	
}