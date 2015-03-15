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
	
	/* constructor(s) */
	public Equipage(Vol v) {
		super();
		this.vol = v;
		this.pnc = new Vector<PNC>();
	}
	
	
	/* question 2 */
	public Boolean contains (Personne membre) {
		return (pnc.contains(membre) || pilote==membre || copilote==membre );
	}
	
	
	@Override
	public String toString() {
		String s = "vol " + vol
				+ "\n pilote " + pilote + "\tcopilote " + copilote 
				+ "\n PNC: \n";
		for (PNC p : pnc) {
			s += p.toString() + "\n";
		}

		return s;
	}
	
	
	

}
