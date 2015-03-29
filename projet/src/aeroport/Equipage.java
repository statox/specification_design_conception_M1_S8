package aeroport;

import java.util.Vector;

public class Equipage {
	private Boolean auMin;
	private Boolean auMax;
	private Vector<PNC> pnc;
	private Pilote pilote;
	private Copilote copilote;
	private Vol vol;
	
	/* getters setters */
	public Boolean getAuMin() {
		return auMin;
	}
	public void setAuMin(Boolean auMin) {
		this.auMin = auMin;
	}
	public Boolean getAuMax() {
		return auMax;
	}
	public void setAuMax(Boolean auMax) {
		this.auMax = auMax;
	}
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	public Vector<PNC> getPnc() {
		return pnc;
	}
	public void setPnc(Vector<PNC> pnc) {
		this.pnc = pnc;
	}
	public Pilote getPilote() {
		return pilote;
	}
	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}
	public Copilote getCopilote() {
		return copilote;
	}
	public void setCopilote(Copilote copilote) {
		this.copilote = copilote;
	}

	
	public void addPilote(Pilote p) throws EquipageException
	{
		if (this.pilote != null)
		{
			throw new EquipageException("pilote dejà existant");
		}else if (p == null) {
			throw new EquipageException("le pilote que vous voulez ajouter est NULL");
		}
		setPilote(p);
		
	}
	
	public void addCopilote(Copilote c) throws EquipageException
	{
		if (this.copilote != null)
		{
			throw new EquipageException("copilote dejà existant");
		}
		
		setCopilote(c);
	}	
	
	public void addPNC(PNC p) throws EquipageException
	{
		if (this.contains(p))
		{
			throw new EquipageException("PNC deja present dans lequipage");
		}
		else if (this.getAuMax())
		{
			throw new EquipageException("Plus de place dans lequipage");
		}
		this.pnc.add(p);
	}
	
	public void delMember (Personne p) throws EquipageException {
    	if (!contains(p))
    		throw new EquipageException("impossible de suppimer " + p + " ne fait pas parti de lequipage");
    	
    	if (pilote.equals(p)) {
    		setPilote(null);
    		return;
    	} else if (copilote.equals(p)) {
    		setCopilote(null);
    		return;
    	} else {
    		pnc.remove(p);
    		return;
    	}
    }
	
	/* constructor(s) */
	public Equipage(Vol v) {
		super();
		this.vol = v;
		this.pnc = new Vector<PNC>();
		this.auMin = false;
		this.auMax = false;
	}
	
	
	/* question 2 */
	public Boolean contains (Personne membre) {
		if (membre == null) return false;
		
		return (pnc.contains(membre) || pilote.equals(membre) || copilote.equals(membre) );
	}

			
	
	@Override
	public String toString() {
		String base = vol.getAvion().getReference() + " " + vol.getNumero() + " " + vol.getDestination() + " " + vol.getDate() + " " + vol.getAvion().getType().getNom() + " " + vol.getSite() + " ";
		
		String s = "Equipage: " + base + "\n";
		if (pilote != null) s += "pilote\t\t" + pilote + "\n";
		if (copilote != null) s += "copilote\t" + copilote + "\n";
		if (pnc != null) s += "PNCs\t\t" + pnc + "\n";
	
		return s;
	}
}
