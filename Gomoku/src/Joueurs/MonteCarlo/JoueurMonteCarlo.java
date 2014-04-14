package Joueurs.MonteCarlo;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import Joueurs.Joueur;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Représente un <b>Coup joué</b>
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JoueurMonteCarlo extends Joueur {
    // ATTRIBUTS   
    /**
     * nombre de parties qui seront simulées
     */
    private int nbSimulation;

    // CONSTRUCTEUR
    /**
     * <b>Constructeur</b> permettant de créer Joueur de Monte Carlo à l'aide de
     * l'id du Joueur, du nombre de simulations qui sera effectuées et ........
     *
     * @param _id numero du joueur de Monte Carlo
     * @param _nbSimulation nombre de simulations qui seront effectuées
     * @param _factory ............
     */
    public JoueurMonteCarlo(int _id, int _nbSimulation) {
        super(_id);
        nbSimulation = _nbSimulation;
    }

    // METHODE
    /**
     * <b>Méthode</b> permettant de générer le Coup le plus pertinant que l'on
     * aura obtenue en simulant des parties entre 2 Joueurs aléatoires à partir
     * de la configuration obtenue après avoir joué le Coup
     *
     * @param etatJeu L'état du Jeu juste avant que le Joueur de Monte Carlo
     * joue
     * @return le Coup le plus pertinant
     * @see Coup
     */
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Noeud meilleurCoup = null;
        ArrayList<Point> positionsPossibles = etatJeu.etatId(0);

        Iterator<Point> it = positionsPossibles.iterator();
        while (it.hasNext()) {  // Parcours les Cases vides (possibles)
            Coup cCourant = new Coup(id, (Point) it.next());
            Noeud nCourant = new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            //ArrayList<Coup> sit = etatJeu.getSituation(); // copie de l'historique

            // Simuler nbSim parties à partir de sit et ajouter
            // les résultats à nCourant à la fin de chaque
            // simulation entre deux joueurs aléatoires
            if (meilleurCoup == null || meilleurCoup.getMoyenne() < nCourant.getMoyenne()) {
                meilleurCoup = nCourant;
            }
            etatJeu.annuler();
        }

        if (meilleurCoup != null) {
            return meilleurCoup.getCoup();
        } else {
            return null;
        }
    }
}
