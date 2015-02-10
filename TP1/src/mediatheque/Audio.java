package mediatheque;

public class Audio extends Document {

	private static int duree = 4*7;
	private static double tarif = 1.0;
	private String classification;
	private static int nbEmpruntsTotal = 0;
	
	/* ctor */
	public Audio(String code, String titre, String auteur, String annee,
			Genre genre, Localisation localisation, String classification) {
		super(code, titre, auteur, annee, genre, localisation);
		this.classification = classification;
		
	}

	/* accessors */
	public String getClassification() {
		return classification;
	}

	public static int getNbEmpruntsTotal() {
		return nbEmpruntsTotal;
	}

	/* prompt */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Audio [classification=" + classification + "]";
	}
	
	public void emprunter()
	{
		if (isEmprunte()==false && isEmpruntable()==true)
		{
			setEmprunte(true);			
			setNbEmprunts(getNbEmprunts()+1);
			nbEmpruntsTotal++;
			this.getGenre().emprunter();
			System.out.println("Emprunt numero " + this.getNbEmprunts() + " de " + this.getTitre());
		}else
		{
			System.out.println("Le document n'est pas empruntable ou a déjà été emprunté");
		}
	}	
}
