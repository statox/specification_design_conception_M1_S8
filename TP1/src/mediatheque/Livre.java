package mediatheque;

public class Livre extends Document {

	private static int duree = 6*7;
	private static double tarif = 0.5;
	private int nombrePage;
	private static int nbEmpruntsTotal = 0;
	
	public Livre(String code, String titre, String auteur, String annee,
			Genre genre, Localisation localisation, int nombrePages) {
		
		super(code, titre, auteur, annee, genre, localisation);
		this.nombrePage = nombrePages;
	}

	public static int getNbEmpruntsTotal() {
		return nbEmpruntsTotal;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Livre [nombrePage=" + nombrePage + "]";
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
