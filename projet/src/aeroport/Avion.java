package aeroport;


public class Avion {
	private TypeAvion type;
	private String reference;

	/* getters setters */
	public TypeAvion getType() {
		return type;
	}

	public void setType(TypeAvion type) {
		this.type = type;
	}

	public String getReference() {
		return reference;
	}

	public void setRef(String ref) {
		this.reference = ref;
	}

	/* constructor(s) */
	public Avion(TypeAvion type, String ref) {
		super();
		this.type = type;
		this.reference = ref;
	}
	
}
