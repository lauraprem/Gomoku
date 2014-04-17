package Joueurs;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import GestionPlateau.Position;

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

        Coup res = new Coup(this.id,
                new Position(Utilitaire.monRamdom(1, etatJeu.getLongueur() ),
                        Utilitaire.monRamdom(1, etatJeu.getLargeur())));
        return res;
    }

}
