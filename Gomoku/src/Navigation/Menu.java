package Navigation;

import JeuDePlateau.JeuGomoku.JeuDeGomoku;
import JeuDePlateau.JeuGomoku.JeuDeGomokuFactory;
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
    private boolean jouer;
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
        {case 1 : nouvellePartie(); break;
        case 2 : reprendrePartie();break;
        }
        leJeu= f.CreerPartieMenu(j1, j2, p,largeur,longueur,n);
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
   
        // JOUEUR 1
        System.out.println("Veuillez choisir le premier joueur : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
        j1 = sc.nextInt();
        while (j1 != 1 && j1 != 2 && j1 != 3)
        {
            System.out.println("Veuillez entrer un choix valide : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
            j1 = sc.nextInt();
        }
      

        // JOUEUR 2
        System.out.println("Veuillez choisir le second joueur : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
        j2 = sc.nextInt();
        while (j2 != 1 && j2 != 2 && j2 != 3)
        {
            System.out.println("Veuillez entrer un choix valide : \n 1) Joueur Humain \n 2) Joueur Aléatoire \n 3) Joueur Monte Carlo");
            j2 = sc.nextInt();
        }

    }

    private void nouveauPlateau()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez choisir un type de plateau : ");
        System.out.println("\n 1) Plateau standard 9x9 \n 2) Plateau personalisé");
        p = sc.nextInt();
        while (p != 1 && p != 2)
        {
            System.out.println("Veuillez entrer un choix valide : \n 1) Plateau standard 9x9 \n 2) Plateau personalisé");
            p = sc.nextInt();
        }
        
        switch(p)
        { case 2 : plateauPerso();break;
                default: plateauStandard();}
    }

    private void plateauPerso()
    {       
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Veuillez choisir la longeur du plateau");
        longueur = sc.nextInt();
        while (longueur <= 0)
        {
            System.out.println("Veuillez choisir une longeur de plateau plus grande que zéro");
            longueur = sc.nextInt();
        }
        
        System.out.println("Veuillez choisir la largeur du plateau");
        largeur = sc.nextInt();
        while (largeur <= 0)
        {
            System.out.println("Veuillez choisir une largeur de plateau plus grande que zéro");
            largeur = sc.nextInt();
        }
        
        System.out.println("Veuillez choisir le nombre de pions necessaire pour gagner");
        n = sc.nextInt();
        while (n <= 1)
        {
            System.out.println("Veuillez choisir une largeur de plateau plus grande que zéro");
            n = sc.nextInt();
        }
        
    }

    private void plateauStandard()
    {
         p = 1;
         n = 4;
    }
    
    private void reprendrePartie(){
    
    }
}
