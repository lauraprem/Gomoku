package Navigation;

import GestionPlateau.Coup;
import GestionPlateau.Position;
import JeuDePlateau.JeuGomoku.JeuDeGomoku;
import JeuDePlateau.JeuGomoku.JeuDeGomokuFactory;
import Joueurs.Joueur;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Laura Prémillieu && Corinne
 */
public class MenuGomoku
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

    /**
     * <b>Constructeur<\b> permet de faire un menu
     */
    public MenuGomoku()
    {

        jouer = true;
        leJeu = new JeuDeGomoku();
        f = new JeuDeGomokuFactory();
    }

    /**
     * Méthode principale du menu : demande au joueur quelle partie il veut 
     * jouer puis la lui fait jouer jusqu'a ce qu'il quitte
     */
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

  /**
   *  <b>Méthode<\b> créé une nouvelle partie
   */
    private void nouvellePartie()
    {
        nouveauxJoueur();
        nouveauPlateau();
          leJeu = f.CreerPartieMenu(j1, j2, p, largeur, longueur, n);

    }

    /**
     *  <b>Méthode<\b> demande au(x) joueurs leurs types
     */
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

    /**
     *  <b>Méthode<\b> demande le type de plateau
     */
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

    /**
     *  <b>Méthode<\b> demande les paramètres du plateau personnalisé
     */
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

    /**
     * prépare un plateau standard
     */
    private void plateauStandard()
    {
        p = 1;
        n = 4;
    }

    /**
     * reprend une partie
     */
    private void reprendrePartie()
    {
        ArrayList<Coup> sit = new ArrayList<>();
        sit.add(new Coup(2, new Position(0, 2)));
        sit.add(new Coup(1, new Position(3, 6)));
        sit.add(new Coup(2, new Position(1, 2)));
        sit.add(new Coup(1, new Position(3, 5)));
        sit.add(new Coup(2, new Position(2, 5)));
        sit.add(new Coup(1, new Position(3, 4)));
        sit.add(new Coup(2, new Position(5, 2)));
       nouveauxJoueur();
       leJeu = f.CreerPartieMenu(j1, j2, 1, largeur, longueur, 4);
       leJeu.getPlateau().initialiser(sit);
       int a=1;
    }
}
