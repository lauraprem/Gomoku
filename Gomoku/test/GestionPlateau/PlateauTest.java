/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPlateau;

import java.awt.Point;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Corinne
 */
public class PlateauTest {

    public PlateauTest() {
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
     * Test of initialiser method, of class Plateau.
     */
    @Test
    public void testInitialiser_0args() {
        System.out.println("initialiser");
        Plateau instance = new Plateau(9, 11);
        instance.initialiser();

        int result = 0;
        for (int i = 0; i < instance.longueur; i++) {
            for (int j = 0; j < instance.largeur; j++) {
                if (instance.getEtatPlateau()[i][j] != 0) {
                    result++;
                }
            }
        }
        if (result != 0) {
            fail("The test case is a prototype.");
        } else {
        }

    }

    /**
     * Test of initialiser method, of class Plateau.
     */
    @Test
    public void testInitialiser_ArrayList() {
      /*  System.out.println("initialiser");
        ArrayList<Coup> coupsPrecedents = null;
        Plateau instance = null;
        instance.initialiser(coupsPrecedents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of jouer method, of class Plateau.
     */
    @Test
    public void testJouer() {
       /* System.out.println("jouer");
        Coup coup = null;
        Plateau instance = null;
        boolean expResult = false;
        boolean result = instance.jouer(coup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of annuler method, of class Plateau.
     */
    @Test
    public void testAnnuler() {
       /* System.out.println("annuler");
        Plateau instance = null;
        Coup expResult = null;
        Coup result = instance.annuler();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
}
