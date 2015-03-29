package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import aeroport.Avion;
import aeroport.Copilote;
import aeroport.Equipage;
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
    public void testStateAfterConstructor() throws Exception {
        System.out.println("Vol - peutVoler = false pour un equipage de 1 personne");
    	v.addPilote(p);
        assertFalse(v.peutVoler());
    }
	

}
