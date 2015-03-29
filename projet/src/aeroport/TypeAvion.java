package aeroport;

import java.util.Vector;

public class TypeAvion {
	private String nom;
	private int nbPNCmin;
	private int nbPNCmax;
	private Vector<Personne> qualifies;
	
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
		this.qualifies = new Vector<Personne>();
	}
	
	public void addQualifie(Personne m) throws EquipageException {
		if (qualifies.contains(m))
			throw new EquipageException("TypeAvion: impossible dajouter " + m + ". Membre deja qualifie");
		
		qualifies.add(m);
	}
	
	public void delQualifie(Personne m) throws EquipageException {
		if (!qualifies.contains(m))
			throw new EquipageException("TypeAvion: impossible de supprimer " + m + ". Membre non qualifie");
		
		qualifies.remove(m);
	}
	
	public void purgeQualifie(Personne m) throws EquipageException {
		if (qualifies.size() == 0)
			throw new EquipageException("TypeAvion: impossible de purger les qualifies. la liste est deja vide");
		
		qualifies.clear();
	}
}
