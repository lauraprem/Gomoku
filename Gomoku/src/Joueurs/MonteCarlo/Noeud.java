package Joueurs.MonteCarlo;

import GestionPlateau.Coup;

/**
 * Représente une association d'un <b>Coup</b> à une <b>moyenne statistique</b>
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class Noeud {
    // ATTRIBUTS
    /**
     *
     */
    private int nbVictoire;

    /**
     *
     */
    private int nbSimulation;

    /**
     *
     */
    private Coup coup;

    // CONSTRUCTEUR
    /**
     *
     * @param _coup
     */
    public Noeud(Coup _coup) {

    }

    // ACCESSEUR
    /**
     *
     * @return
     */
    public Coup getCoup() {
        return coup;
    }
    
    // MUTATEURS
    /**
     * 
     * @param nbVictoire 
     */
    public void setNbVictoire(int nbVictoire) {
        this.nbVictoire = nbVictoire;
    }

    /**
     * 
     * @param nbSimulation 
     */
    public void setNbSimulation(int nbSimulation) {
        this.nbSimulation = nbSimulation;
    }

    /**
     * 
     * @param coup 
     */
    public void setCoup(Coup coup) {
        this.coup = coup;
    }
    
    
    // METHODES
    /**
     *
     * @return
     */
    public double getMoyenne() {
        return 0;
    }
    
    /**
     * 
     */
    public void ajouterVictoire(){
        nbVictoire++;
    }
    
    /**
     * 
     */
    public void ajouterDefaite(){
        nbVictoire--;
    }
}
