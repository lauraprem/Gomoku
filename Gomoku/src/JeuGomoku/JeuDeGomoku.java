
package JeuGomoku;

import GestionPlateau.Coup;
import GestionPlateau.PlateauGomoku;
import Joueurs.Joueur;

/**
 *représente une partie de Gomoku
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JeuDeGomoku {
    
    //ATTRIBUTS
    /**
     * <b> attribut </b>
     * les deux joueurs 
     */
    private Joueur[] lesJoueurs;
    /**
     * <b> attribut </b>
     * le joueur qui doit jouer
     */
    private Joueur joueurCourant;
    /**
     * <b> attribut </b>
     * plateau pouer jouer
     */
    private PlateauGomoku plateau; 
    /**
     * <b> attribut </b>
     * le nombre de pions nécessaire à aligner pour gagner la partie
     */
    private int nbPionGagne;
    
    
    //CONSTRUCTEUR
    /**
     * <b>Constructeur</b> permet de créer un jeu pour lequel on choisi les joueurs,
     * la taille du plateau et le nombre de pions à aligner pour gagner
     * @param joueur1 permet de savoir quel joueur commence à jouer (vrai = joueur 1, faux = joueur 2)
     * @param j1 le joueur j1
     * @param j2 le joueur j2
     * @param longueur la longeur du plateau 
     * @param largeur la latrgeur du plateau 
     * @param n nombre de pions à aligner pour gagner
     */
    public JeuDeGomoku(boolean joueur1, Joueur j1, Joueur j2, int longueur, int largeur, int n)
    {
        lesJoueurs[0] = j1;
        lesJoueurs[1] = j2;
        if(joueur1) joueurCourant = j2;
        else joueurCourant = j1;
        plateau = new PlateauGomoku(longueur, largeur);
        nbPionGagne = n;
    }
    
    /**
     * <b>Mutateur</b> permet de modifier un joueur
     * @param ordre permet de savoir quel joueur on veut modifier (vrai = 1; faux = 0)
     * @param joueur le nouveau joueur 
     */
   public void setJoueur(boolean ordre, Joueur joueur)
    {
        if(ordre)lesJoueurs[1]=joueur;
        else lesJoueurs[0]=joueur;
    }
    
   /**
    * <b>Mutateur</b> permet de modifier le plateau
    * @param plateau le nouveau plateau
    */
    public void setPlateau(PlateauGomoku plateau)
    {
        this.plateau = plateau;
    }
    
    /**
     * <b>Méthode</b> permet de modifier le joueur courant pour changer de tour
     */
    private void joueurSuivant()
    {
        if (joueurCourant.getId() == lesJoueurs[0].getId())
            joueurCourant= lesJoueurs[1];
        else joueurCourant = lesJoueurs[0];
    }
    
    /**
     * <b>Méthode</b> permet de savoir si le joueur courant a gagné
     * @return vrai s'il a gagné et faux sinon
     */
    public boolean partieTerminee()
    {return plateau.CkeckGagneId(nbPionGagne, joueurCourant.getId());}
    
    /**
     * permet de savoir si un coup est authorisé (s'il est dans les bornes du plateau 
     * et sur une case vide)
     * @param coup le coup que l'on veut tester
     * @return vrai si le coup est valide
     */
    public boolean coupValide(Coup coup)
    {
        return ((coup.getPosition().x >= 0 && coup.getPosition().x < plateau.getLongueur()) 
             && (coup.getPosition().y >= 0 && coup.getPosition().x < plateau.getLargeur())
             && plateau.getCase(coup.getPosition().x,coup.getPosition().y) == 0 );
    }
}
