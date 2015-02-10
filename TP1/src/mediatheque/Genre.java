package mediatheque;

public class Genre {
	
	private String nom;
	private int nbEmprunts;
	
	/* ctor */
	public Genre(String nom) {
		super();
		this.nom = nom;
		this.nbEmprunts = 0;
	}

	/* accessors and mutators */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbEmprunts() {
		return nbEmprunts;
	}

	/* prompt */
	@Override
	public String toString() {
		return "Genre [" + nom + "  emprunts: " + nbEmprunts + "]";
	}
	
	public void emprunter()
	{
		nbEmprunts++;
		System.out.println("Nouvel emprunt: " + this.nom + "\temprunt numero:" + nbEmprunts + "\n");
	}
	
	public void afficherStatistiques()
	{
		System.out.println(this.toString());
	}

}
