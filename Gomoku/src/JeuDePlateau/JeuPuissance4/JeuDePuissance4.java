package JeuDePlateau.JeuPuissance4;

import GestionPlateau.Coup;
import GestionPlateau.PlateauPuissance4;
import Joueurs.Joueur;

/**
 * représente une partie de Puissance4
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JeuDePuissance4 extends JeuDePlateau.JeuGomoku.JeuDeGomoku {

    JeuDePuissance4(boolean b, Joueur j1, Joueur j2, int longueur, int largeur, int n)
    {
        super(b,j1,j2,longueur,largeur,n);
        this.plateau = new PlateauPuissance4(longueur,largeur);
       }

    JeuDePuissance4(Joueur j1, Joueur j2, int i, PlateauPuissance4 p)
    {
       super(j1,j2,i,p); 
    this.plateau = new PlateauPuissance4();
    this.plateau.initialiser(p.getHistorique());
    }

    
    
    @Override
    public boolean coupValide(Coup coup) {

        return (coup.getPosition().y>0 && coup.getPosition().y <= plateau.getLargeur());
    }
}
