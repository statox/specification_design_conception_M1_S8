package mediatheque;

public class Video extends Document {
	
	private static int duree = 2*7;
	private static double tarif = 1.5;
	private String mentionLegale;
	private int dureeFilm;
	private static int nbEmpruntsTotal = 0;
	
	/* ctor */
	public Video(String code, String titre, String auteur, String annee,
			Genre genre, Localisation localisation, int dureeFilm, String mentionLegale) {
		
		super(code, titre, auteur, annee, genre, localisation);
		this.dureeFilm = dureeFilm;
		this.mentionLegale = mentionLegale;

	}

	/* accessors */
	public static int getNbEmpruntsTotal() {
		return nbEmpruntsTotal;
	}

	/* prompt */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Video [mentionLegale=" + mentionLegale + ", dureeFilm="
				+ dureeFilm + "]";
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
