package Joueurs;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import GestionPlateau.Position;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * reprensente un joueur humain qui joue au clavier. Hérite d'un joueur
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JoueurHumain extends Joueur
{

    /**
     * <b>constructeur</b> permet de chosir l'identifiant du joueur
     *
     * @param _id identifiant du joueur
     */
    public JoueurHumain(int _id)
    {
        super(_id);
    }

    /**
     * <b>methode</b> permet au joueur de choisir son coup
     *
     * @param etatJeu le plateau du jeu
     * @return le coup choisi par joueur
     */
    @Override
    public Coup genererCoup(Plateau etatJeu)
    {

        int largeur;
        int longueur;
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            try
            {
                System.out.println("Veuillez saisir la coodonée de la largeur (entre 1 et " + etatJeu.getLargeur() + ") : \n");
                largeur = sc.nextInt();
                while (largeur > etatJeu.getLargeur() || largeur < 1)
                {
                    System.out.println("La largeur doit être comprise entre 1 et " + etatJeu.getLargeur() + " : \n");
                    largeur = sc.nextInt();
                }

                System.out.println("Veuillez saisir la coodonée de la longueur (entre 1 et " + etatJeu.getLongueur() + ") : \n");
                longueur = sc.nextInt();
                while (longueur > etatJeu.getLongueur() || longueur < 1)
                {
                    System.out.println("La longueur doit être comprise entre 1 et " + etatJeu.getLongueur() + " : \n");
                    longueur = sc.nextInt();
                }

                Coup res = new Coup(this.id, new Position(longueur, largeur));
                return res;
            } catch (InputMismatchException e)
            {
                System.out.println("Veuillez saisir un chiffre \n");
                sc = new Scanner(System.in);
            }
        }
    }
}
