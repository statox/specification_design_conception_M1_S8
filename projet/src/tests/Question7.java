package tests;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import aeroport.Avion;
import aeroport.Copilote;
import aeroport.Equipage;
import aeroport.EquipageException;
import aeroport.PNC;
import aeroport.Pilote;
import aeroport.TypeAvion;
import aeroport.Vol;

public class Question7 {

	Pilote p;
    Copilote cp;
    Vector<PNC> pncs;
    Equipage e;
    TypeAvion ta;
    Avion a;
    Vol v;
    
    
    @Before
    public void setUp() throws Exception {
        ta = new TypeAvion("A320", 2, 3);
        a = new Avion(ta, "13562");
        v = new Vol("AF437", "Orly", "Londres", "11/11/2011", a);
        pncs = new Vector<PNC>();
        
        e = new Equipage(v);
        v.setEquipage(e);            
        
        p = new Pilote("Corinne", "Lancel");
        p.addQualification(ta);
        
        cp = new Copilote("Amy", "Bosch");
        cp.addQualification(ta);
        
        pncs.add(new PNC("Maureen", "Gates"));
        pncs.get(0).addQualification(ta);
        
        pncs.add(new PNC("Richard", "Tata"));
        pncs.get(1).addQualification(ta);
        
        pncs.add(new PNC("Ben", "Gamma"));
        pncs.get(2).addQualification(ta);
        
        e.setPnc(pncs);
        e.addPilote(p);
        e.addCopilote(cp);
    }
    
    @After
    public void tearDown() throws Exception {
        p = null;
        cp = null;
        ta = null;
        a = null;
        v = null;
        pncs = null;
        e = null;
    }
    
    @Test (expected = EquipageException.class)
    public void affecterPNC_equipePleine() throws Exception {
    	e.setAuMax(true);
    	v.addPNC(new PNC("Herve", "Dumont"));
    }

}
