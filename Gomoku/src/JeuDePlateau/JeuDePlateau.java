package JeuDePlateau;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import Joueurs.Joueur;
import java.util.ArrayList;

/**
 * représente une partie d'un jeu de plateau quelconque
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public abstract class JeuDePlateau 
{
    //ATTRIBUTS
    /**
     * <b> attribut </b>
     * les deux joueurs
     */
    protected Joueur[] lesJoueurs;

    /**
     * <b> attribut </b>
     * le joueur qui doit jouer
     */
    protected Joueur joueurCourant;

    /**
     * <b> attribut </b>
     * plateau pour jouer
     */
    protected Plateau plateau;

    /**
     * <b>Mutateur</b> permet de modifier un joueur
     *
     * @param ordre permet de savoir quel joueur on veut modifier (vrai = j1;
     * faux = j2)
     * @param joueur le nouveau joueur
     */
    public void setJoueur(boolean ordre, Joueur joueur)
    {
        if (ordre)
        {
            lesJoueurs[0] = joueur;
        } else
        {
            lesJoueurs[1] = joueur;
        }
    }

    /**
     * <b>Mutateur</b> permet de modifier le plateau
     *
     * @param plateau le nouveau plateau
     */
    public void setPlateau(Plateau plateau)
    {
        this.plateau = plateau;
    }
    
    public Plateau getPlateau()
    {
        return this.plateau;
    }

    /**
     * <b>Méthode</b> permet de modifier le joueur courant pour changer de tour
     */
    protected void joueurSuivant()
    {
        if (joueurCourant.getId() == lesJoueurs[0].getId())
        {
            joueurCourant = lesJoueurs[1];
        } else
        {
            joueurCourant = lesJoueurs[0];
        }
    }

 
    
    /**
     * <b>Méthode</b> permet de savoir si le joueur courant a gagné
     *
     * @return vrai s'il a gagné et faux sinon
     */
    public abstract int partieTerminee();

    /**
     * permet de savoir si un coup est authorisé (s'il est dans les bornes du
     * plateau et sur une case vide)
     *
     * @param coup le coup que l'on veut tester
     * @return vrai si le coup est valide
     */
    public abstract boolean coupValide(Coup coup);


    /**
     * <b>Méthode</b> permettant de faire jouer les joueurs à tour de role
     * jusqu'a ce que l'un d'eux gagne
     *
     * @return le joueur gagnant
     */
    public abstract Joueur jouerPartie();
}
