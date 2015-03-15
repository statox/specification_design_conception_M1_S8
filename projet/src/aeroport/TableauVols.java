package aeroport;

public class TableauVols {
	private String nom;

	/* getters setters */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/* constructor(s) */
	public TableauVols(String nom) {
		super();
		this.nom = nom;
	}
	
	public static void main(String[] args) {
		question4();
	}
	
	public static void question4() {

		/* creation de la date */
		String dep = "11/10/06";
		
		/* creation des types d avions */
		TypeAvion type1 = new TypeAvion("A320", 2, 3);
		//TypeAvion type2 = new TypeAvion("B747", 3, 4);

		/* creation des avions */
		Avion avion = new Avion(type1, "13562");
		
		/* creation des personnes */
		Pilote pilote = new Pilote("Lancel", "Corinne");
		Copilote copilote = new Copilote("Bosch", "Amy");
		PNC pnc1 = new PNC("Gates", "Maureen");
		PNC pnc2 = new PNC("Tata", "Richard");
		PNC pnc3 = new PNC("Gamma", "Ben");
	
		/* creation du vol */
		Vol vol = new Vol("AF347", "Orly", "Londres", dep, avion);
		
		/* creation de l equipage */
		Equipage equipage = new Equipage(vol);
		
		System.out.println(equipage);
		
		return;
				
	}
	
}
