package aeroport;

public class TypeAvion {
	private String nom;
	private int nbPNCmin;
	private int nbPNCmax;
	
	/* getters setters */
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbPNCmin() {
		return nbPNCmin;
	}
	public void setNbPNCmin(int nbPNCmin) {
		this.nbPNCmin = nbPNCmin;
	}
	public int getNbPNCmax() {
		return nbPNCmax;
	}
	public void setNbPNCmax(int nbPNCmax) {
		this.nbPNCmax = nbPNCmax;
	}
	
	/* constructor(s) */
	public TypeAvion(String nom) {
		super();
		this.nom = nom;
	}
	public TypeAvion(String nom, int min, int max) {
		super();
		this.nom = nom;
		this.nbPNCmin = min;
		this.nbPNCmax = max;
	}
	
	
	
	
}
