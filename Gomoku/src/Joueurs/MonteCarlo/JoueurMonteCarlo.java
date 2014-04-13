package Joueurs.MonteCarlo;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import Joueurs.Joueur;

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
        return null;
    }
}
