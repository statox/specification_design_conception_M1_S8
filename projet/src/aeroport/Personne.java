package aeroport;

import java.util.Vector;

import aeroport.TypeAvion;

public class Personne {
	private String nom;
	private String prenom;
	private Vector<TypeAvion> qualifications;
	
	/* getters setters */
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Vector<TypeAvion> getQualifications() {
		return qualifications;
	}
	public void setQualifications(Vector<TypeAvion> qualifications) {
		this.qualifications = qualifications;
	}
	
	/* constructor(s) */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Boolean peutVoler(TypeAvion t) {
		return qualifications.contains(t);
	}
	
	public Boolean addQualification(TypeAvion type) {
		//TODO: to implement exceptions calls
		
		if (!qualifications.contains(type) && qualifications.size()<2)
		{
			return qualifications.add(type);
		}
		
		return false;
	}
	
	
	public boolean delQualification(TypeAvion type, boolean fromType) {
		//TODO: To implement
		//TODO: what is the fromType??
		
		System.out.println("To implement");
		return false;
	}
	
	
	
	
	
	
}
