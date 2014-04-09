
package Joueurs;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import java.awt.Point;
/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JoueurAleatoire extends Joueur{

    public JoueurAleatoire(int _id) {
        super(_id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        
        Coup res = new Coup( 
                new Point(Utilitaire.monRamdom(0,etatJeu.getLongueur()-1 ), 
                          Utilitaire.monRamdom(0,etatJeu.getLargeur()-1 )) );
        return res;
    }
    
}
