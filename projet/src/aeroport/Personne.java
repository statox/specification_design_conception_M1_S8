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
	public Personne(String nom, String prenom) throws InvariantBroken {
		super();		
		this.nom = nom;
		this.prenom = prenom;
		this.qualifications = new Vector<TypeAvion>();
		
		if (!invariant())
		{
			throw new InvariantBroken("Personne -" + this);
		}
	}
	
	/* invariant: 
	 * In this class the name and firstname can not by empty or null
	 * return 	true if the invariant is broken
	 * 			false otherwise
	 */
	public boolean invariant()
	{
		return !(this.nom.equals(null) || this.nom.isEmpty() || this.prenom.equals(null) || this.prenom.isEmpty());
	}
	
	public Boolean peutVoler(TypeAvion t) {
		return qualifications.contains(t);
	}
	
	public Boolean addQualification(TypeAvion type) throws EquipageException, InvariantBroken {
		
		if (qualifications.size()==2)
			throw new InvariantBroken("Personne: impossible dajouter une qualification. " + this + " a deja 2 qualifications");
		
		if (!qualifications.contains(type) && qualifications.size()<2)
		{
			type.addQualifie(this);
			return qualifications.add(type);
		}
		
		return false;
	}
	
	
	public boolean delQualification(TypeAvion type, boolean fromType) throws EquipageException {
		//TODO: what is the fromType??
		
		if (!qualifications.contains(type))
			throw new EquipageException("Personne: impossible de supprimer la qualification car " + this + " nest pas qualifie");
		
		return qualifications.remove(type);
	}
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
	
	
	
	
	
	
}
