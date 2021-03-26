package DAO;

import java.util.*;

import org.hibernate.Session;
public class Personne {
	
	private Long idPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	private int age;
	private Set<Reunion> reunions=new HashSet<Reunion>();
	
	public Long getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Reunion> getReunions() {
		return reunions;
	}
	public void setReunions(Set<Reunion> reunions) {
		this.reunions = reunions;
	}
	
	
	public void addPersonne(String nom, String prenom,int age) {

		Session session =HibernateFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Personne p = new Personne();
		p.setNomPersonne(nom);
		p.setPrenomPersonne(prenom);
		p.setAge(age);
		session.save(p);
		session.getTransaction().commit();
		
		}
	
	public void addReunionToPersonne(Long idPersonne, Long idReunion) {
		
		Session session =HibernateFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// Charger une personne
		Personne p = (Personne) session.load(Personne.class, idPersonne);
		// Charger une réunion
		Reunion r = (Reunion) session.load(Reunion.class, idReunion);
		// Ajouter la réunion r à la collection reunions de la personne p
		p.getReunions().add(r);
		session.getTransaction().commit();
		
		}
	
	public static Personne getPersonne(Long idPersonne) {
		
		Session session =HibernateFactory.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Personne p = (Personne)session.load(Personne.class,idPersonne);
		return p;
		
		}
	
	
	public static void main(String [] args) {
		
		Personne pers= new Personne();
		pers.addPersonne("LARHCHIM", "ismail", 21);
		pers.addPersonne("LARHCHIM", "said", 21);
		pers.addPersonne("LARHCHIM", "hamadi", 21);
		
		
		ReunionManager dao = new ReunionManager();
		dao.addReunion(new Reunion("R1", new Date()));
		dao.addReunion(new Reunion("R2", new Date()));
		dao.addReunion(new Reunion("R3", new Date()));
		
		
		pers.addReunionToPersonne(Long.valueOf(1), Long.valueOf(1));
		Personne p=Personne.getPersonne(new Long(1));
		System.out.println(p.getNomPersonne()+"--"+p.getPrenomPersonne()+"--"+p.getAge());
		System.out.println("Réunions auquelles a participé cette personne");
		Iterator reunions=p.getReunions().iterator();
		while(reunions.hasNext()){
		Reunion r=(Reunion)reunions.next();
		System.out.println(r.getTitre()+"--"+ r.getDateReunion());
		}
		

		
		
	
	}
	



}