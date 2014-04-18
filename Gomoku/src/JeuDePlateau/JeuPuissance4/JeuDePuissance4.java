package JeuDePlateau.JeuPuissance4;

import GestionPlateau.Coup;
import Joueurs.Joueur;

/**
 * représente une partie de Puissance4
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JeuDePuissance4 extends JeuDePlateau.JeuGomoku.JeuDeGomoku {

    @Override
    public boolean coupValide(Coup coup) {

        return coup.getPosition().y < plateau.getLargeur();
    }
}
