package mediatheque;

public class Document {

	private String code;
	private String titre;
	private String auteur;
	private String annee;
	private Genre genre;
	private Boolean empruntable;
	private Boolean emprunte;
	private int nbEmprunts;
	private Localisation localisation;
	
	/* ctor */
	public Document(String code, String titre, String auteur, String annee,
			Genre genre, Localisation localisation) {
		super();
		this.code = code;
		this.titre = titre;
		this.auteur = auteur;
		this.annee = annee;
		this.genre = genre;
		this.localisation = localisation;
		this.nbEmprunts = 0;
		this.emprunte = false;
		this.empruntable = false;
	}

	/* accessors and mutators */
	public String getCode() {
		return code;
	}

	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getAnnee() {
		return annee;
	}

	public Genre getGenre() {
		return genre;
	}

	public Boolean isEmpruntable() {
		return empruntable;
	}

	public Boolean isEmprunte() {
		return emprunte;
	}

	public int getNbEmprunts() {
		return nbEmprunts;
	}

	public Localisation getLocalisation() {
		return localisation;
	}
	
	public void setEmpruntable(Boolean empruntable) {
		this.empruntable = empruntable;
	}

	public void setEmprunte(Boolean emprunte) {
		this.emprunte = emprunte;
	}

	public void setNbEmprunts(int nbEmprunts) {
		this.nbEmprunts = nbEmprunts;
	}

	/* prompt */
	@Override
	public String toString() {
		return titre + " auteur=" + auteur + " annee=" + annee 
				+ "\ncode=" + code 
				+ "\n" + genre
				+ "\nempruntable " + empruntable + ", emprunte " + emprunte
				+ "\nnbEmprunts " + nbEmprunts + ""
				+ "\nlocalisation="	+ localisation + "\n";
	}



	public void emprunter()
	{
		if (isEmprunte()==false && isEmpruntable()==true)
		{
			setEmprunte(true);			
			++nbEmprunts;
			this.genre.emprunter();
			System.out.println("Emprunt numero " + this.nbEmprunts + " de " + this.titre + "\n");
		}else
		{
			System.out.println("Le document n'est pas empruntable ou a déjà été emprunté" + "\n");
		}

	}
	
	public void restituer()
	{
		if (isEmprunte()==false || isEmpruntable()==false)
		{
			//TODO: throw an exception
			System.out.println("Le document n'est pas marqué comme emprunté. Erreur." + "\n");
		}else
		{
			setEmprunte(false);
			System.out.println("Retour de " + this.titre + "\n");
		}
	}

	
	public void afficherStatDocument()
	{
		System.out.println(this);
	}
	
}
