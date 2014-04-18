package JeuDePlateau;

import GestionPlateau.Coup;

import java.util.ArrayList;

/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public interface JeuDePlateauFactory
{

   /**
     * <b>Méthode<\b> Permettra de créer une partie avec deux joueurs
     * humains à partir d'une situation donnée
     *
     * @param situation situation du jeu que l'on veut utiliser
     * @return le jeu de Gomoku
     */
    JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation);

    /**
     * <b>Méthode<\b> Permettra de créer une partie de Gomoku avec un joueur
     * humain et un joueur aléatoire à partir d'une situation donnée
     *
     * @param situation situation du jeu que l'on veut utiliser
     * @return le jeu de Gomoku
     */
    JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation);

    /**
     * <b>Méthode<\b> Permettra de créer une partie de Gomoku avec deux joueurs
     * aléatoire à partir d'une situation donnée
     *
     * @param situation situation du jeu que l'on veut utiliser
     * @return le jeu de Gomoku
     */
    JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation);

}
