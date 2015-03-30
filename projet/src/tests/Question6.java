package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

public class Question6 {
	
    Pilote p;
    Copilote cp;
    PNC pncs[];
    Equipage e;
    TypeAvion ta;
    Avion a;
    Vol v;
    
    @Before
    public void setUp() throws Exception {
        ta = new TypeAvion("A320", 2, 3);
        a = new Avion(ta, "13562");
        v = new Vol("AF437", "Orly", "Londres", "11/11/2011", a);
        pncs = new PNC[3];
        
        e = new Equipage(v);
        v.setEquipage(e);            
        
        p = new Pilote("Corinne", "Lancel");
        p.addQualification(ta);
        
        cp = new Copilote("Amy", "Bosch");
        cp.addQualification(ta);
        
        pncs[0] = new PNC("Maureen", "Gates");
        pncs[0].addQualification(ta);
        
        pncs[1] = new PNC("Richard", "Tata");
        pncs[1].addQualification(ta);
        
        pncs[2] = new PNC("Ben", "Gamma");
        pncs[2].addQualification(ta);
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
    
    /* test peutVoler avec un equipage pas assez nombreux */
    @Test
    public void peutVoler_equipageSousEffectif() throws Exception {
        System.out.println("Vol - peutVoler = false pour un equipage de 1 personne");
    	v.addPilote(p);
        assertFalse(v.peutVoler());
    }
    
    /* test l'invariant sur les nb de PNC dans un type davion */
    @Test
    public void typeAvion_Invariant() throws Exception {
    	System.out.println("TypeAvion - invariant sur nbPNCmin et nbPNCmax");
    	assertTrue(ta.invariant());
    	
    	ta.setNbPNCmax(1);
    	assertFalse(ta.invariant());
    	
    	ta.setNbPNCmax(-1);
    	assertFalse(ta.invariant());
    	
    	ta.setNbPNCmax(5);
    	ta.setNbPNCmin(-1);
    	assertFalse(ta.invariant());
    }	
    
    /* test l'allocation du pilote */
    @Test
    public void vol_addPilote() throws Exception {
    	System.out.println("Vol.addPilote => e.getPilote");
    	v.addPilote(p);
    	assertEquals(p, e.getPilote());
    }
    
    /* test l'allocation du copilote */
    @Test
    public void vol_addCopilote() throws Exception {
    	System.out.println("Vol.addCopilote => e.getCopilote");
    	v.addCopilote(cp);
    	assertEquals(cp, e.getCopilote());
    }
    
    /* test l'allocation du PNC */
    @Test
    public void vol_addPNC() throws Exception {
    	System.out.println("Vol.addPNC => e.getPNC");
    	e.setPnc(new Vector<PNC>());
    	v.addPNC(pncs[1]);
    	int index = e.getPnc().indexOf(pncs[1]);
    	assertEquals(pncs[1], e.getPnc().elementAt(index) );
    }
}
