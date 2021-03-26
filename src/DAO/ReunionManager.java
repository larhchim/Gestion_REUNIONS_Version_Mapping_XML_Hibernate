package DAO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

public class ReunionManager {
	
		
	public void addReunion(Reunion r){
		
	Session session=FactoryReunion.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	session.save(r);
	session.getTransaction().commit();
	
	}
	
	public List listReunions() {
		Session session=FactoryReunion.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List result = session.createQuery("from Reunion").list();
		session.getTransaction().commit();
		return result;
		}
	
	
	
	public static void main(String[] args) {
		
	ReunionManager dao = new ReunionManager();
	dao.addReunion(new Reunion("R1", new Date()));
	dao.addReunion(new Reunion("R2", new Date()));
	dao.addReunion(new Reunion("R3", new Date()));
	
	/*List listR=dao.listReunions();
	Iterator lesR=listR.iterator();
	while(lesR.hasNext()){
	Reunion r=(Reunion)lesR.next();
	System.out.println(r.getIdReunion()+"--"+r.getTitre()+"--"+r.getDateReunion());

	}
	FactoryReunion.getSessionFactory().close();*/
	
	}

}