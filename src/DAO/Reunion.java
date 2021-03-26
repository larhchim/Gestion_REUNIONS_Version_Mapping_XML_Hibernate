package DAO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Reunion {
	
	private Long idReunion;
	private String titre;
	private Date dateReunion;
	
	private Set personnes = new HashSet();
	
	public Set getPersonnes() {
		
	return personnes;
	
	}
	
	public void setPersonnes(Set personnes) {
		
	this.personnes = personnes;
	
	}

	public Reunion(){
		
	}
	
	
	public Reunion(String titre, Date dateReunion) {
	this.titre = titre;
	this.dateReunion = dateReunion;
	}


	public Long getIdReunion() {
		return idReunion;
	}


	public void setIdReunion(Long idReunion) {
		this.idReunion = idReunion;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public Date getDateReunion() {
		return dateReunion;
	}


	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}



}