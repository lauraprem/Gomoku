package Joueurs;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import java.awt.Point;
import java.util.Scanner;
/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JoueurHumain extends Joueur{

    public JoueurHumain(int _id) {
        super(_id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) 
    {
        int largeur;
        int longueur;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Veuillez saisir la coodonée de la largeur (entre 1 et "+etatJeu.getLargeur()+") : \n");
        largeur = sc.nextInt();
        while (largeur > etatJeu.getLargeur() || largeur < 1 )
        {System.out.println("La largeur doit être comprise entre 1 et " + etatJeu.getLargeur() + " : \n");
        largeur = sc.nextInt();
        }
        
        System.out.println("Veuillez saisir la coodonée de la longueur (entre 1 et "+etatJeu.getLongueur() +") : \n");
        longueur = sc.nextInt();
        while (longueur > etatJeu.getLongueur() || longueur < 1 )
        {System.out.println("La longueur doit être comprise entre 1 et " + etatJeu.getLongueur()+ " : \n");
        longueur = sc.nextInt();
        }
        
        Coup res = new Coup(this.id,new Point(longueur-1,largeur-1));
        return res;
    }
    
}
