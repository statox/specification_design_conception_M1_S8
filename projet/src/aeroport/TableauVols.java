package aeroport;

import java.util.Vector;

public class TableauVols {
	
	public static void main(String[] args) {
		question4();
	}
	
	public static void question4() {
		
		try {
		/* creation de la date */
		String dep1 = "11/10/06";
		String dep2 = "12/10/06";
		
		/* creation des types d avions */
		TypeAvion type1 = new TypeAvion("A320", 2, 3);
		TypeAvion type2 = new TypeAvion("B747", 3, 4);

		/* creation des avions */
		Avion avion1 = new Avion(type1, "13562");
        Avion avion2 = new Avion(type2, "32156");
	
		/* creation des personnes */
		Pilote pilote1 = new Pilote("Lancel", "Corinne");
		Pilote pilote2 = new Pilote("Vlisside", "Jacques"); 
		
		Copilote copilote1 = new Copilote("Bosch", "Amy");
		Copilote copilote2 = new Copilote("Dupont", "Jean-Louis");
		
		PNC pnc11 = new PNC("Gates", "Maureen");
		PNC pnc12 = new PNC("Tata", "Richard");
		PNC pnc13 = new PNC("Gamma", "Ben");
		Vector<PNC> pnc1 = new Vector<PNC>();
		pnc1.add(pnc11);
		pnc1.add(pnc12);
		pnc1.add(pnc13);
		
		PNC pnc21 = new PNC("Orval", "Segolene");
		PNC pnc22 = new PNC("Saadi", "Francois");
		PNC pnc23 = new PNC("Harper", "Nicolas");
        Vector<PNC> pnc2 = new Vector<PNC>();
		pnc2.add(pnc21);
		pnc2.add(pnc22);
		pnc2.add(pnc23);
		
		/* creation du vol */
		Vol vol1 = new Vol("AF347", "Orly", "Londres", dep1, avion1);
		Vol vol2 = new Vol("AF545", "Roissy", "New-York", dep2, avion2);
		
		/* creation de l equipage */
		Equipage equipage1 = new Equipage(vol1);
		equipage1.setPilote(pilote1);
		equipage1.setCopilote(copilote1);
		equipage1.setPnc(pnc1);
		equipage1.setAuMax(true);
		equipage1.setAuMin(false);
		
		Equipage equipage2 = new Equipage(vol2);
		equipage2.setPilote(pilote2);
		equipage2.setCopilote(copilote2);
		equipage2.setPnc(pnc2);
		equipage2.setAuMax(false);
		equipage2.setAuMin(true);

		System.out.println(equipage1);
		System.out.println(equipage2);
		} catch (InvariantBroken e) {
			System.out.println("Viol dun invaraint: " + e.getMessage());
		}/* catch (EquipageException e) {
			System.out.println("Erreur equipage: " + e.getMessage());
		}*/catch (Exception e){
			System.out.println("Autre exception: " + e.getMessage());
		}
		
		
		return;
				
	}
	
}
