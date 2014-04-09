
package Joueurs;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public abstract class Joueur 
{
protected int id;

public Joueur(int _id)
{
    this.id=_id;
}

public int getId()
{
    return this.id;
}

public abstract Coup genererCoup(Plateau etatJeu);

}
