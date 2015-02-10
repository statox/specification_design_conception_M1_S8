package mediatheque;

public class Localisation {
	
	private String rayon;
	private String salle;
	
	/* ctor */
	public Localisation(String rayon, String salle) {
		super();
		this.rayon = rayon;
		this.salle = salle;
	}

	/* accessors */
	public String getRayon() {
		return rayon;
	}

	public String getSalle() {
		return salle;
	}

	/* prompt */
	@Override
	public String toString() {
		return "Localisation [rayon=" + rayon + ", salle=" + salle + "]";
	}
	
	
	
	

}
