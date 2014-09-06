package Joueurs.MonteCarlo;

import GestionPlateau.Coup;

/**
 * Représente une association d'un <b>Coup</b> à une <b>moyenne statistique</b>
 *
 * @author Laura Prémillieu && Corinne
 */
public class Noeud {
    // ATTRIBUTS
    /**
     * Nombre de victoires
     */
    private double nbVictoire;

    /**
     * Nombre de simulations qui seront effectuées
     */
    private int nbSimulation;

    /**
     *
     * @see Coup
     */
    private Coup coup;

    // CONSTRUCTEUR
    /**
     * <b>Constructeur</b> permettant de créer un Noeud avec un Coup
     *
     * @param _coup
     * @see Coup
     */
    public Noeud(Coup _coup) {
        coup = _coup;
        nbVictoire = 0;
        nbSimulation = 0;
    }

    // ACCESSEUR
    /**
     * <b>Accesseur</b> permettant de recuperer le Coup du Noeud
     *
     * @return le Coup du Noeud
     * @see Coup
     */
    public Coup getCoup() {
        return coup;
    }

    // MUTATEURS
    /**
     * <b>Mutateur</b> permettant de modifier le nombre de simulations
     *
     * @param nbSimulation nombre de simulations qui sera effectuées
     */
    public void setNbSimulation(int nbSimulation) {
        this.nbSimulation = nbSimulation;
    }

    /**
     * <b>Mutateur</b> permettant de modifier le Coup du Noeud
     *
     * @param coup le nouveau Coup du Noeud
     * @see Coup
     */
    public void setCoup(Coup coup) {
        this.coup = coup;
    }

    // METHODES
    /**
     * <b>Méthode</b> permettant de récupérer la moyenne statistique du Coup du
     * Noeud
     *
     * @return moyenne statistique du Coup
     * @see Coup
     */
    public double getMoyenne() {
        if (nbSimulation != 0) {
            return ((double) nbVictoire / (double) nbSimulation);
        }

        return 0;
    }

    /**
     * <b>Méthode</b> permettant d'augmenter de 1 le nombre de victoire en cas
     *  de victoire
     */
    public void ajouterVictoire() {
        nbVictoire++;
    }

    /**
     * <b>Méthode</b> permettant de diminuer de 1 le nombre de victoire en cas
     *  de défaite
     */
    public void ajouterDefaite() {
        nbVictoire--;
    }

    /**
     * <b>Méthode</b> permettant d'augmenter de 0.5 le nombre de victoire en cas
     * d'égalité
     */
    public void ajouterEgalite() {
        nbVictoire = nbVictoire + 0.5;
    }
}
