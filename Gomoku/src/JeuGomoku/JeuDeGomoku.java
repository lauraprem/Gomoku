
package JeuGomoku;

import GestionPlateau.Coup;
import GestionPlateau.PlateauGomoku;
import Joueurs.Joueur;

/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JeuDeGomoku {
    
    private Joueur[] lesJoueurs;
    private Joueur joueurCourant;
    private PlateauGomoku plateau; 
    private int nbPionGagne;
    
    /*si le boolean est à vrai, c'est au joueur de l'indice 1 qui commence sinon c'est le joueur de l'indice 0*/
    public JeuDeGomoku(boolean joueur1, Joueur j1, Joueur j2, int longueur, int largeur, int n)
    {
        lesJoueurs[0] = j1;
        lesJoueurs[1] = j2;
        if(joueur1) joueurCourant = j2;
        else joueurCourant = j1;
        plateau = new PlateauGomoku(longueur, largeur);
        nbPionGagne = n;
    }
    
    /*vrai pour 1 faux pour 0*/
    public void setJoueur(boolean ordre, Joueur joueur)
    {
        if(ordre)lesJoueurs[1]=joueur;
        else lesJoueurs[0]=joueur;
    }
    
    public void setPlateau(PlateauGomoku plateau)
    {
        this.plateau = plateau;
    }
    
    private void joueurSuivant()
    {
        if (joueurCourant.getId() == lesJoueurs[0].getId())
            joueurCourant= lesJoueurs[1];
        else joueurCourant = lesJoueurs[0];
    }
    
    public boolean partieTerminee()
    {return plateau.CkeckGagneId(nbPionGagne, joueurCourant.getId());}
    
    public boolean coupValide(Coup coup)
    {
        return ((coup.getPosition().x >= 0 && coup.getPosition().x < plateau.getLongueur()) 
             && (coup.getPosition().y >= 0 && coup.getPosition().x < plateau.getLargeur())
             && plateau.getCase(coup.getPosition().x,coup.getPosition().y) == 0 );
    }
}
