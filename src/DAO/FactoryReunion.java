
package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class FactoryReunion{

	private static SessionFactory sessionFactory = null;
	static
	{
	try
	{
	//sessionFactory = new Configuration().configure().buildSessionFactory();
	sessionFactory = new Configuration().configure("Reunion.cfg.xml").buildSessionFactory();
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