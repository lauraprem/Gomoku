package Joueurs;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import GestionPlateau.Position;
import java.util.ArrayList;

/**
 * reprensente un joueur qui choisit ses coups de manière aléatoire. Hérite d'un
 * joueur
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JoueurAleatoire extends Joueur {

    /**
     * <b>constructeur</b> permet de chosir l'identifiant du joueur
     *
     * @param _id identifiant du joueur
     */
    public JoueurAleatoire(int _id) {
        super(_id);
    }

    /**
     * <b>methode</b> permet au joueur de choisir son coup
     *
     * @param etatJeu le plateau du jeu
     * @return le coup choisi par joueur
     */
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        ArrayList<Position> pos = etatJeu.etatId(0);
        Position p  = pos.get(Utilitaire.monRamdom(0,pos.size() -1 ));
        Coup res = new Coup(this.id,p);
        return res;
    }

}
