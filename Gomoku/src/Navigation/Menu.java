package Navigation;

import JeuDePlateau.JeuGomoku.JeuDeGomoku;
import JeuDePlateau.JeuGomoku.JeuDeGomokuFactory;
import Joueurs.Joueur;
import java.util.InputMismatchException;
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
    private int n;
    private int largeur;
    private int longueur;
    private JeuDeGomoku leJeu;
    private boolean jouer = true;
    private JeuDeGomokuFactory f;

    public Menu()
    {

        jouer = true;
        leJeu = new JeuDeGomoku();
        f = new JeuDeGomokuFactory();
    }

    public void run()
    {

        //Initialisation de la partie 
        System.out.println("Bonjour ! \n Bienvenue dans le grand jeu du gomoku !! \n\n ");
        System.out.println("Voulez-vous commencer une nouvelle partie ou reprendre un jeu en cours ?");
        Scanner sc = new Scanner(System.in);
        Joueur joueur;
        while (jouer)
        {
            try
            {
                
                System.out.println("\n 1) nouveau jeu \n 2) reprendre jeu \n 3) quitter");

                int j;
                j = sc.nextInt();
                System.out.println("\n");

               
                while (j != 1 && j != 2 && j!=3)
                {
                    System.out.println("Veuillez entrer un choix valide : ");
                    System.out.println("\n 1) nouveau jeu \n 2) reprendre jeu \n 3) quitter");
                    j = sc.nextInt();
                    System.out.println("\n");
                }
                switch (j)
                {
                    case 1:
                        nouvellePartie();
                        break;
                    case 2:
                        reprendrePartie();
                        break;
                    case 3 :
                        jouer = false; break; 
                }
                if (!jouer)
                    break;
                leJeu = f.CreerPartieMenu(j1, j2, p, largeur, longueur, n);
               joueur = leJeu.jouerPartie();
               if (joueur == null)
                    System.out.println("Partie terminée !! Match nul. \n\n");
               else
                    System.out.println("Partie terminée !! le joueur " + joueur.getId() + " a gagné !!! \n\n");
            } catch (InputMismatchException e)
            {
                System.out.println("Veuillez saisir un chiffre \n");
                sc = new Scanner(System.in);
            }
        }
    }

    private void nouvellePartie()
    {
        nouveauxJoueur();
        nouveauPlateau();

    }

    private void nouveauxJoueur()
    {
        Scanner sc = new Scanner(System.in);

        // JOUEUR 1
        System.out.println("Veuillez choisir le premier joueur : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
        j1 = sc.nextInt();
        System.out.println("\n");
        while (j1 != 1 && j1 != 2 && j1 != 3)
        {
            System.out.println("Veuillez entrer un choix valide : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
            j1 = sc.nextInt();
            System.out.println("\n");
        }

        // JOUEUR 2
        System.out.println("Veuillez choisir le second joueur : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
        j2 = sc.nextInt();
        System.out.println("\n");
        while (j2 != 1 && j2 != 2 && j2 != 3)
        {
            System.out.println("Veuillez entrer un choix valide : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
            j2 = sc.nextInt();
            System.out.println("\n");
        }

    }

    private void nouveauPlateau()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez choisir un type de plateau : \n 1) Plateau standard 9x9 \n 2) Plateau personalisé");
        p = sc.nextInt();
        System.out.println("\n");
        while (p != 1 && p != 2)
        {
            System.out.println("Veuillez entrer un choix valide : \n 1) Plateau standard 9x9 \n 2) Plateau personalisé");
            p = sc.nextInt();
            System.out.println("\n");
        }

        switch (p)
        {
            case 2:
                plateauPerso();
                break;
            default:
                plateauStandard();
        }
    }

    private void plateauPerso()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez choisir la longeur du plateau");
        longueur = sc.nextInt();
        System.out.println("\n");
        while (longueur <= 0)
        {
            System.out.println("Veuillez choisir une longeur de plateau plus grande que zéro");
            longueur = sc.nextInt();
            System.out.println("\n");
        }

        System.out.println("Veuillez choisir la largeur du plateau");
        largeur = sc.nextInt();
        System.out.println("\n");
        while (largeur <= 0)
        {
            System.out.println("Veuillez choisir une largeur de plateau plus grande que zéro");
            largeur = sc.nextInt();
            System.out.println("\n");
        }

        System.out.println("Veuillez choisir le nombre de pions necessaire pour gagner");
        n = sc.nextInt();
        System.out.println("\n");
        while (n <= 0)
        {
            System.out.println("Veuillez choisir un nombre de pions plus grand que zéro");
            n = sc.nextInt();
            System.out.println("\n");
        }

    }

    private void plateauStandard()
    {
        p = 1;
        n = 4;
    }

    private void reprendrePartie()
    {

    }
}
