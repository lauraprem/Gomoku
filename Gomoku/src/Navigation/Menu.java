package Navigation;

import GestionPlateau.Plateau;
import GestionPlateau.PlateauGomoku;
import JeuDePlateau.JeuGomoku.JeuDeGomoku;
import Joueurs.JoueurAleatoire;
import Joueurs.JoueurHumain;
import Joueurs.MonteCarlo.JoueurMonteCarlo;
import java.util.Scanner;

/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class Menu
{

    private int j1;
    private int j2;
    private int p;
    JeuDeGomoku leJeu;
    boolean jouer;

    public Menu()
    {
        jouer = true;
        leJeu = new JeuDeGomoku();
    }

    public void run()
    {
        //Initialisation de la partie 
        System.out.println("Bonjour ! \n Bienvenue dans le grand jeu du gomoku \n\n !");
        System.out.println("Voulez-vous commencer une nouvelle partie ou reprendre un jeu en cours ?");
        System.out.println("\n 1) nouveau jeu \n 2) reprendre jeu");
        Scanner sc = new Scanner(System.in);
        int j;
        j = sc.nextInt();
        
        System.out.println(j);
        while(j != 1 && j!= 2)
        {
            System.out.println("Veuillez entrer un choix valide : ");
            System.out.println("\n 1) nouveau jeu \n 2) reprendre jeu");
            j = sc.nextInt();
        }
        switch(j)
        {case 1 : nouvellePartie();
        case 2 : reprendrePartie();
        }
        System.out.println(leJeu.getPlateau().toString());
        leJeu.jouerPartie();

    }

    private void nouvellePartie()
    {
        nouveauxJoueur();
        nouveauPlateau();

    }

    private void nouveauxJoueur()
    {
        Scanner sc = new Scanner(System.in);
        int j;

        // JOUEUR 1
        System.out.println("Veuillez choisir le premier joueur : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
        j = sc.nextInt();
        while (j != 1 && j != 2 && j != 3)
        {
            System.out.println("Veuillez entrer un choix valide : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
            j = sc.nextInt();
        }
        System.out.println(j);
        switch (j)
        {
            case 1:
                leJeu.setJoueur(true, new JoueurHumain(1));
            case 2:
                leJeu.setJoueur(true, new JoueurAleatoire(1));
            case 3:
                leJeu.setJoueur(true, new JoueurMonteCarlo(1, 100));
        }

        // JOUEUR 2
        System.out.println("Veuillez choisir le second joueur : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
        j = sc.nextInt();
        while (j != 1 && j != 2 && j != 3)
        {
            System.out.println("Veuillez entrer un choix valide : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
            j = sc.nextInt();
        }
        switch (j)
        {
            case 1:
                leJeu.setJoueur(false, new JoueurHumain(1));
            case 2:
                leJeu.setJoueur(false, new JoueurAleatoire(1));
            case 3:
                leJeu.setJoueur(false, new JoueurMonteCarlo(1, 100));
        }
    }

    private void nouveauPlateau()
    {
        Scanner sc = new Scanner(System.in);
        int p;
        System.out.println("Veuillez choisir un type de plateau : ");
        System.out.println("\n 1) Plateau standard 9x9 \n 2) Plateau personalisé");
        p = sc.nextInt();
        while (p != 1 && p != 2)
        {
            System.out.println("Veuillez entrer un choix valide : \n 1) Plateau standard 9x9 \n 2) Plateau personalisé");
            p = sc.nextInt();
        }
        System.out.println(p);
       // switch (p)
        //{
          //  case 1:
                plateauStandard();
            //case 2:
               // plateauPerso();
       // }
    }

    private void plateauPerso()
    {       
        Scanner sc = new Scanner(System.in);
        PlateauGomoku p = new PlateauGomoku(0,0);
        
        System.out.println("Veuillez choisir la longeur du plateau");
        p.setLongueur(sc.nextInt());
        while (p.getLongueur() <= 0)
        {
            System.out.println("Veuillez choisir une longeur de plateau plus grande que zéro");
            p.setLongueur(sc.nextInt());
        }
        
        System.out.println("Veuillez choisir la largeur du plateau");
        p.setLargeur(sc.nextInt());
        while (p.getLargeur() <= 0)
        {
            System.out.println("Veuillez choisir une largeur de plateau plus grande que zéro");
            p.setLargeur(sc.nextInt());
        }
        
        leJeu.setPlateau(p);
    }

    private void plateauStandard()
    {
        PlateauGomoku p = new PlateauGomoku();
        leJeu.setPlateau(p);
    }
    
    private void reprendrePartie(){}
}
