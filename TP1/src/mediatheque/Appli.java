package mediatheque;

public class Appli {

	public static void main(String[] args) {
		
//		partie1();
		partie2();

	}
	
	public static void partie1()
	{
		Genre genre1 = new Genre("Science Fiction");
		
		for (int i=0; i<10; ++i)
		{
			genre1.emprunter();
		}
		
		System.out.println(genre1);
		
		genre1.afficherStatistiques();
	}
	
	public static void partie2()
	{
		/* Audio - The soft parade */
		Genre psychedelicRock = new Genre("psychedelic rock");
		Localisation locDoors = new Localisation("1", "audio");
		Audio softParade = new Audio("1A", "The soft parade", "The Doors", "1969", psychedelicRock, locDoors, "Best cd ever");
		softParade.setEmpruntable(true);
		
		/* Video - A Clockwork Orange */
		Genre drama = new Genre ("drama");
		Localisation locClockwork = new Localisation("1", "video");
		Video clockwork = new Video("1V", "A ClockWork Orange", "Stanley Kubrick", "1971", drama, locClockwork, 136, "moins 12 ans");
		clockwork.setEmpruntable(true);

		/* Livre - The picture of Dorian Gray */
		Genre fantastique = new Genre("Fantastique");
		Localisation locDorian = new Localisation("1", "livres");
		Livre dorianGray = new Livre("1L", "The picture of Dorian Gray", "Oscar Wilde", "1891", fantastique, locDorian, 132);
		dorianGray.setEmpruntable(true);
		
		softParade.emprunter();
		softParade.afficherStatDocument();
		System.out.println(softParade);
		
		clockwork.emprunter();
		clockwork.restituer();
		clockwork.emprunter();
		clockwork.afficherStatDocument();
		
		dorianGray.emprunter();
		dorianGray.afficherStatDocument();
	}

}
