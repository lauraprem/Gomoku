/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JeuGomoku;

import GestionPlateau.Coup;
import GestionPlateau.PlateauGomoku;
import Joueurs.Joueur;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leclerc
 */
public class JeuDeGomokuTest {
    
    public JeuDeGomokuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setJoueur method, of class JeuDeGomoku.
     */
    @Test
    public void testSetJoueur() {
        System.out.println("setJoueur");
        boolean ordre = false;
        Joueur joueur = null;
        JeuDeGomoku instance = null;
        instance.setJoueur(ordre, joueur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlateau method, of class JeuDeGomoku.
     */
    @Test
    public void testSetPlateau() {
        System.out.println("setPlateau");
        PlateauGomoku plateau = null;
        JeuDeGomoku instance = null;
        instance.setPlateau(plateau);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of partieTerminee method, of class JeuDeGomoku.
     */
    @Test
    public void testPartieTerminee() {
        System.out.println("partieTerminee");
        JeuDeGomoku instance = null;
        boolean expResult = false;
        boolean result = instance.partieTerminee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of coupValide method, of class JeuDeGomoku.
     */
    @Test
    public void testCoupValide() {
        System.out.println("coupValide");
        Coup coup = null;
        JeuDeGomoku instance = null;
        boolean expResult = false;
        boolean result = instance.coupValide(coup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
