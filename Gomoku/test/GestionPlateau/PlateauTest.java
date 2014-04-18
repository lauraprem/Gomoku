package GestionPlateau;

import Joueurs.Utilitaire;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class PlateauTest {

    private Plateau instancePlateau;
    private ArrayList<Coup> coupsPrecedents;
    private Coup coup;

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
        int longueur = 9;
        int largeur = 11;

        instancePlateau = new Plateau(longueur, largeur);

        //Fabrication de coups précédent
        coupsPrecedents = new ArrayList<Coup>();
        for (int i = 0; i < 3; i++) {
            coupsPrecedents.add(new Coup(Utilitaire.monRamdom(1, 2), new Position((int) Utilitaire.monRamdom(-1, longueur), (int) Utilitaire.monRamdom(-1, largeur))));
        }

        //Fabrication de coup
        coup = new Coup(Utilitaire.monRamdom(1, 2), new Position((int) Utilitaire.monRamdom(0, longueur - 1), (int) Utilitaire.monRamdom(0, largeur - 1)));
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

        instancePlateau.initialiser();

        // comptage du nombre de cases differents de 0 dans le plateau
        int result = 0;
        for (int i = 0; i < instancePlateau.longueur; i++) {
            for (int j = 0; j < instancePlateau.largeur; j++) {
                if (instancePlateau.getEtatPlateau()[i][j] != 0) {
                    result++;
                }
            }
        }

        // Verification que toutes les cases sont a 0 et que l'historique est vide 
        if (result != 0 || !instancePlateau.getHistorique().isEmpty()) {
            fail("Une ou plusieurs cases ne sont pas initialisees a 0 \n"
                    + "ou \n"
                    + "L'historique n'est pas vide");
        }
    }

    @Test
    public void testInitialiser_ArrayList() {
        System.out.println("initialiser");

        instancePlateau.initialiser(coupsPrecedents);

        //Verification que l'historique contient les coups precedent
        if (!instancePlateau.historique.equals(coupsPrecedents)) {
            fail("L'historique n'est pas actualise !");
        }

        //Verification que les coups soient bien joues
        Iterator<Coup> it = coupsPrecedents.iterator();

        while (it.hasNext()) {
            Coup coup = (Coup) it.next();
            if ((coup.getPosition().x >= 0 && coup.getPosition().x < instancePlateau.longueur)
                    && (coup.getPosition().y >= 0 && coup.getPosition().y < instancePlateau.largeur)) {
                if (instancePlateau.etatPlateau[coup.getPosition().x][coup.getPosition().y] == 0) {
                    fail("La case " + coup.getPosition().x + ";" + coup.getPosition().y
                            + ": n'est pas actualise comme cas jouee par un joueur !");
                }
            }
        }
    }

    @Test
    public void testJouer() {
        System.out.println("jouer");

        boolean expResult = false;
        boolean result;

        //Replissage du tableau
        instancePlateau.initialiser(coupsPrecedents);

        // Generation d'un Coup
        Coup coup = new Coup(1, new Position((int) Utilitaire.monRamdom(0, 8), (int) Utilitaire.monRamdom(0, 10)));//historiq

        // Verification si on peut jouer le Coup
        if ((coup.getPosition().x >= 0 && coup.getPosition().x < instancePlateau.longueur)
                && (coup.getPosition().y >= 0 && coup.getPosition().y < instancePlateau.largeur)
                && instancePlateau.getCase(coup.getPosition().x, coup.getPosition().y) == 0) {
            expResult = true;
        }
        result = instancePlateau.jouer(coup);

        // Verification que le Coup soit joue si on peut jouer
        if (expResult == true && instancePlateau.getCase(coup.getPosition().x, coup.getPosition().y) == 0) {
            fail("Le coup n'a pas ete joue");
        }
        if (expResult == false && instancePlateau.getCase(coup.getPosition().x, coup.getPosition().y) != 0) {
            fail("Le coup ne devrait pas etre joue");
        }
        if (expResult == true && instancePlateau.getCase(coup.getPosition().x, coup.getPosition().y) != coup.getId()) {
            fail("L'id du joueur a mal ete renseigne");
        }
        if (expResult != result) {
            fail("Le coup a mal ete joue");
        }
    }

    /**
     * Test of annuler method, of class Plateau.
     */
    @Test
    public void testAnnuler() {
        System.out.println("annuler");

        // Joue un Coup
        instancePlateau.jouer(coup);

        // Annule le Coup joue precedement
        Coup result = instancePlateau.annuler();

        // Verification que le Coup soit
        if (!coup.equals(result)) {
            fail("Le Coup de retour n'est pas correct");
        }
        if (instancePlateau.getCase(coup.getPosition().x, coup.getPosition().y) != 0) {
            fail("Le Coup n'a pas ete annule");
        }
    }
}
