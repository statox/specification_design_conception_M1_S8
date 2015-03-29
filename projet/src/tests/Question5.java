package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import aeroport.Avion;
import aeroport.Copilote;
import aeroport.Equipage;
import aeroport.EquipageException;
import aeroport.InvariantBroken;
import aeroport.PNC;
import aeroport.Pilote;
import aeroport.TypeAvion;
import aeroport.Vol;

public class Question5 {

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
    
    /* verifie qu'un vol ne peut pas voler directement apres sa creation */
    @Test
    public void testStateAfterConstructor() throws Exception {
        System.out.println("vol - peutVoler = false après le constructeur");
        assertFalse(v.peutVoler());
    }
    
    /* verifie que les methodes d'ajout et de suppression de membres ne lèvent pas d'exception dans une situation normale */
    @Test
    public void AddRemove() throws Exception {
        System.out.println("vol - methodes add* et delMember en situation normale");
        v.addPilote(p);
        v.addCopilote(cp);
        v.addPNC(pncs[0]);
        v.delMember(pncs[0]);
        assertFalse(v.peutVoler());
    }
    
    /* verifie que la methode d'ajout dun pilote leve une exception si le pilote a deja ete ajoute */
	@Test (expected = EquipageException.class)
	public void addPilote_piloteAlreadySet() throws EquipageException, InvariantBroken {
		System.out.println("vol - methode addPilote en situation derreur");
		v.addPilote(p);
		v.addPilote(new Pilote("Herve", "Dumont"));
	}
    
	/* verifie qu'une fois lequipage au complet mais au minimum la methode peut voler renvoie vrai */
    @Test
    public void MinNumber() throws Exception {
        System.out.println("Vol - peutVoler = true avec un equipage complet");
        v.addPilote(p);
        v.addCopilote(cp);
        v.addPNC(pncs[0]);
        v.addPNC(pncs[1]);
        assertTrue(v.peutVoler());
    }
    
    /* verifie quun equipage au complet et au maximum passe bien les methodes peutVoler() et equipageAuComplet() a vrai */
    @Test
    public void MaxNumber() throws Exception {
        System.out.println("vol - Test 4: methodes peutVoler et equipageAuComplet");
        v.addPilote(p);
        v.addCopilote(cp);
        v.addPNC(pncs[0]);
        v.addPNC(pncs[1]);
        v.addPNC(pncs[2]);
        assertTrue(v.peutVoler());
        assertTrue(v.equipageAuComplet());
    }
    
    /* verifie le bon fonctionnement de la methode contains() */
    @Test
	public void contains() throws Exception {
    	System.out.println("vol - Test 5: methode contains");
        v.addPilote(p);
        v.addCopilote(cp);
        v.addPNC(pncs[0]);
        v.addPNC(pncs[1]);
        v.addPNC(pncs[2]);
        
		assertTrue("Pilote present dans lequipage", e.contains(p));
		assertTrue("Copilote present dans lequipage", e.contains(cp));
		assertTrue("PNC present dans lequipage", e.contains(pncs[2]));
		assertFalse("Pilote non present dans lequipage", e.contains(new Pilote("Dumont", "Herve")));
		assertFalse("Copilote non present dans lequipage", e.contains(new Copilote("Dumont", "Herve")));
		assertFalse("PNC non present dans lequipage", e.contains(new PNC("Dumont", "Herve")));
		assertFalse("Recherche dun membre null", e.contains(null));
	}

}
