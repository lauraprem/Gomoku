package JeuDePlateau.JeuPuissance4;

import GestionPlateau.Coup;
import GestionPlateau.PlateauPuissance4;
import Joueurs.Joueur;
import Joueurs.JoueurAleatoire;
import Joueurs.JoueurHumain;

/**
 * représente une partie de Puissance4
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JeuDePuissance4 extends JeuDePlateau.JeuGomoku.JeuDeGomoku {

    JeuDePuissance4(boolean b, Joueur j1, Joueur j2, int i, int i0, int i1)
    {
        super(b,j1,j2,i,i0,i1);
       }

    JeuDePuissance4(Joueur j1, Joueur j2, int i, PlateauPuissance4 p)
    {
       super(j1,j2,i,p);  }

    
    
    @Override
    public boolean coupValide(Coup coup) {

        return (coup.getPosition().y>0 && coup.getPosition().y <= plateau.getLargeur());
    }
}
