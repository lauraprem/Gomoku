/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JeuDePlateau.JeuPuissance4;

import GestionPlateau.Coup;
import GestionPlateau.PlateauPuissance4;
import JeuDePlateau.JeuDePlateau;
import JeuDePlateau.JeuDePlateauFactory;
import Joueurs.Joueur;
import Joueurs.JoueurAleatoire;
import Joueurs.JoueurHumain;
import Joueurs.MonteCarlo.JoueurMonteCarlo;
import java.util.ArrayList;

/**
 *
 * @author leclerc
 */
public class JeuDePuissance4Factory implements JeuDePlateauFactory 
{
    /**
     *  <b>Méthode<\b> Permet de créer une partie de Puissance4 personnalisée
     * 
     * @param j1 le premier joueur : 1 = humain; 2 = aléatoire; 3 = Monte Carlo
     * @param j2 le second joueur : 1 = humain; 2 = aléatoire; 3 = Monte Carlo
     * @param plateau le plateau : 1 = standard; 2 = personnalisé
     * @param largeur la largeur du plateau si perso 
     * @param longueur la longueur du plateau si perso
     * @param m le nombre de pions pour gagner
     * @return 
     */
    public JeuDePuissance4 CreerPartieMenu( int j1, int j2, int plateau, int largeur, int longueur, int m)
    {
        Joueur joueur1;
        Joueur joueur2;
        PlateauPuissance4 p;
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
                joueur1 = new JoueurMonteCarlo(1, 1000, new JeuDePuissance4Factory());
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
                joueur2 = new JoueurMonteCarlo(2, 1000, new JeuDePuissance4Factory());
                break;
            default:
                joueur2 = new JoueurHumain(2);
        }

        switch (plateau)
        {
            case 1:
                p = new PlateauPuissance4();
                n = 4;
                break;
            case 2:
                p = new PlateauPuissance4(longueur, largeur);
                n = m;
                break;
            default:
                p = new PlateauPuissance4();
                n = 4;
        }

        JeuDePuissance4 j = new JeuDePuissance4(true, joueur1, joueur2, p.getLongueur(), p.getLargeur(), n);
        return j;
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation)
    { if (situation == null)
        {
            Joueur j1 = new JoueurHumain(1);
            Joueur j2 = new JoueurHumain(2);
            JeuDePuissance4 j = new JeuDePuissance4(true, j1, j2, 9, 9, 4);
            return j;
        } else
        {
            JeuDePuissance4 j = new JeuDePuissance4(2 == situation.get(situation.size() - 1).getId(),
                    new JoueurHumain(situation.get(0).getId()),
                    new JoueurHumain(situation.get(1).getId()),
                    9, 9, 4);
            j.getPlateau().initialiser(situation);
            return j;
        }  }

    @Override
    public JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation)
    {if (situation == null)
        {
            Joueur j1 = new JoueurHumain(1);
            Joueur j2 = new JoueurAleatoire(2);
            JeuDePuissance4 j = new JeuDePuissance4(true, j1, j2, 9, 9, 4);
            return j;
        } else
        {
            PlateauPuissance4 p = new PlateauPuissance4();
            p.setHistorique(situation);
            JeuDePuissance4 j = new JeuDePuissance4(new JoueurHumain(situation.get(0).getId()),
                    new JoueurAleatoire(situation.get(1).getId()), 4, p);
            return j;
        }  }

    @Override
    public JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation)
    { if (situation.size() < 2)
        {
            Joueur j1 = new JoueurAleatoire(1);
            Joueur j2 = new JoueurAleatoire(2);
            JeuDePuissance4 j = new JeuDePuissance4(true, j1, j2, 9, 9, 4);
            return j;
        }

        JeuDePuissance4 j = new JeuDePuissance4(2 == situation.get(situation.size() - 1).getId(),
                new JoueurAleatoire(situation.get(0).getId()), new JoueurAleatoire(situation.get(1).getId()), 9, 9, 4);
        j.getPlateau().initialiser(situation);
        return j;}
}
