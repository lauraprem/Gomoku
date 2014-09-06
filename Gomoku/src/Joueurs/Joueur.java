
package Joueurs;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
/**
 * Classe abstraite représentant un joueur
 * @author Laura Prémillieu && Corinne
 */
public abstract class Joueur 
{
    /**
     * <b> attribut </b>
     * identifiant du joueur
     */
protected int id;

/**
 * <b> constructeur </b> permet de choisir l'identifiant du joueur
 * @param _id identifiant du joueur
 */
public Joueur(int _id)
{
    this.id=_id;
}

/**
 * <b> Accesseur </b> permettant de recuperer l'id du joueur
 * @return l'identifiant du joueur
 */
public int getId()
{
    return this.id;
}

/**
 * <b> Methode abstraite </b> permet au joueur de choisir un coup
 * @param etatJeu le plateau du jeu 
 * @return le coup choisi par joueur
 */
public abstract Coup genererCoup(Plateau etatJeu);

/**
 * Permet de mettre le joueur sous forme de chaine
 * @return la chaine représentant le joueur
 */
    @Override
    public String toString()
    {
        return "Joueur d'ID : " + id + "\n";
    }


}
