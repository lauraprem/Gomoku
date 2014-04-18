package JeuDePlateau.JeuGomoku;

import GestionPlateau.Coup;
import GestionPlateau.PlateauGomoku;
import JeuDePlateau.*;
import Joueurs.Joueur;
import Joueurs.JoueurAleatoire;
import Joueurs.JoueurHumain;
import Joueurs.MonteCarlo.JoueurMonteCarlo;
import java.util.ArrayList;

/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JeuDeGomokuFactory implements JeuDePlateauFactory
{

    /**
     * <b>Méthode<\b> Permet de créer une partie de Gomoku avec deux joueurs
     * humains à partir d'une situation donnée
     *
     * @param situation situation du jeu que l'on veut utiliser
     * @return le jeu de Gomoku
     */
    @Override
    public JeuDeGomoku CreerPartieHumainVSHumain(ArrayList<Coup> situation)
    {
        if (situation == null)
        {
            Joueur j1 = new JoueurHumain(1);
            Joueur j2 = new JoueurHumain(2);
            JeuDeGomoku j = new JeuDeGomoku(true, j1, j2, 9, 9, 4);
            return j;
        } else
        {
            JeuDeGomoku j = new JeuDeGomoku(2 == situation.get(situation.size() - 1).getId(),
                    new JoueurHumain(situation.get(0).getId()),
                    new JoueurHumain(situation.get(1).getId()),
                    9, 9, 4);
            j.getPlateau().initialiser(situation);
            return j;
        }
    }

    /**
     * <b>Méthode<\b> Permet de créer une partie de Gomoku avec un joueur humain
     * et un joueur aléatoire à partir d'une situation donnée
     *
     * @param situation situation du jeu que l'on veut utiliser
     * @return le jeu de Gomoku
     */
    @Override
    public JeuDeGomoku CreerPartieHumainVSAleatoire(ArrayList<Coup> situation)
    {
        if (situation == null)
        {
            Joueur j1 = new JoueurHumain(1);
            Joueur j2 = new JoueurAleatoire(2);
            JeuDeGomoku j = new JeuDeGomoku(true, j1, j2, 9, 9, 4);
            return j;
        } else
        {
            PlateauGomoku p = new PlateauGomoku();
            p.setHistorique(situation);
            JeuDeGomoku j = new JeuDeGomoku(new JoueurHumain(situation.get(0).getId()),
                    new JoueurAleatoire(situation.get(1).getId()), 4, p);
            return j;
        }
    }

    /**
     * <b>Méthode<\b> Permet de créer une partie de Gomoku avec deux joueurs
     * aléatoire à partir d'une situation donnée
     *
     * @param situation situation du jeu que l'on veut utiliser
     * @return le jeu de Gomoku
     */
    @Override
    public JeuDeGomoku CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation)
    {
        if (situation.size() < 2)
        {
            Joueur j1 = new JoueurAleatoire(1);
            Joueur j2 = new JoueurAleatoire(2);
            JeuDeGomoku j = new JeuDeGomoku(true, j1, j2, 9, 9, 4);
            return j;
        }

        JeuDeGomoku j = new JeuDeGomoku(2 == situation.get(situation.size() - 1).getId(),
                new JoueurAleatoire(situation.get(0).getId()), new JoueurAleatoire(situation.get(1).getId()), 9, 9, 4);
        j.getPlateau().initialiser(situation);
        return j;

    }

//    @Override
//    public JeuDePlateau CreerPartieAleatoireVSMonteCarlo(ArrayList<Coup> situation)
//    {        JeuDeGomoku j = new JeuDeGomoku(2 == situation.get(situation.size() - 1).getId(),
//                new JoueurAleatoire(1), new JoueurMonteCarlo(2), 9, 9, 4);
//        j.getPlateau().initialiser(situation);
//        return j;   }
//
//    @Override
//    public JeuDePlateau CreerPartieHumainVSMonteCarlo(ArrayList<Coup> situation)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public JeuDePlateau CreerPartieMonteCarloVSMonteCarlo(ArrayList<Coup> situation)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    /**
     *  <b>Méthode<\b> Permet de créer une partie de Gomoku personnalisée
     * 
     * @param j1 le premier joueur : 1 = humain; 2 = aléatoire; 3 = Monte Carlo
     * @param j2 le second joueur : 1 = humain; 2 = aléatoire; 3 = Monte Carlo
     * @param plateau le plateau : 1 = standard; 2 = personnalisé
     * @param largeur la largeur du plateau si perso 
     * @param longueur la longueur du plateau si perso
     * @param m le nombre de pions pour gagner
     * @return 
     */
    public JeuDeGomoku CreerPartieMenu( int j1, int j2, int plateau, int largeur, int longueur, int m)
    {
        Joueur joueur1;
        Joueur joueur2;
        PlateauGomoku p;
        int n;
        
        switch (j1)
        {
            case 1:
                joueur1 = new JoueurHumain(1);
                break;
            case 2:
                joueur1 = new JoueurAleatoire(1);
                break;
            case 3:
                joueur1 = new JoueurMonteCarlo(1, 100, new JeuDeGomokuFactory());
                break;
            default:
                joueur1 = new JoueurHumain(1);
        }
        switch (j2)
        {
            case 1:
                joueur2 = new JoueurHumain(2);
                break;
            case 2:
                joueur2 = new JoueurAleatoire(2);
                break;
            case 3:
                joueur2 = new JoueurMonteCarlo(2, 100, new JeuDeGomokuFactory());
                break;
            default:
                joueur2 = new JoueurHumain(2);
        }

        switch (plateau)
        {
            case 1:
                p = new PlateauGomoku();
                n = 4;
                break;
            case 2:
                p = new PlateauGomoku(longueur, largeur);
                n = m;
                break;
            default:
                p = new PlateauGomoku();
                n = 4;
        }

        JeuDeGomoku j = new JeuDeGomoku(true, joueur1, joueur2, p.getLongueur(), p.getLargeur(), n);
        return j;
    }
}
