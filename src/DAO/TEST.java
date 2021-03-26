package DAO;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TEST {

	public static void main(String[] args) {
		
		BasicConfigurator.configure();

		Session session = HibernateFactory.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//Personne y = session.find(Personne.class, 1);
		ArrayList<Personne> az ;
		az=(ArrayList<Personne>) session.createQuery("FROM Personne WHERE id in (2,3,4,5) ").getResultList();
		System.out.println(az.toString());
		//session.save(y);
		//session.remove(y);

		
		tx.commit();

	}

}
