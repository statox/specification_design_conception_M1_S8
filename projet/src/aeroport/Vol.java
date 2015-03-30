package aeroport;

public class Vol {
	private String numero;
	private String site;
	private String destination;
	private String date;
	private Avion avion;
    private Equipage equipage;

	/* getters setters */
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
    public Equipage getEquipage() {
		return equipage;
	}
	public void setEquipage(Equipage equipage) {
		this.equipage = equipage;
	}
	
	/* constructor(s) */
	public Vol(String numero, String site, String destination, String dep,
			Avion avion) {
		super();
		this.numero = numero;
		this.site = site;
		this.destination = destination;
		this.date = dep;
		this.avion = avion;
	}
	public Vol(String numero, String dep) {
		super();
		this.numero = numero;
		this.date = dep;
	}

    public void addPilote(Pilote p) throws EquipageException {
    	equipage.addPilote(p);
    }
    
    public void addCopilote(Copilote c) throws EquipageException {
        equipage.addCopilote(c);
    }
    
    public void addPNC(PNC p) throws EquipageException {
        equipage.addPNC(p);
    }
    
    public void delMember (Personne p) throws EquipageException {
    	equipage.delMember(p);
    }
    
    public boolean equipageAuComplet() {
    	if (equipage.getPilote() == null
    			|| equipage.getCopilote() == null 
    			|| equipage.getPnc().size() < avion.getType().getNbPNCmin())
    		return false;
    	
    	return true;
    }
	
    public boolean peutVoler() {
    	if (!equipageAuComplet()) return false;
    	if (numero == null) return false;
    	if (site == null) return false;
    	if (destination == null) return false;
    	if (date == null) return false;
    	if (avion == null) return false;
    	
    	return true;
    }
}
