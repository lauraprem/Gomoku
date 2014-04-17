package JeuDePlateau.JeuGomoku;

import GestionPlateau.Coup;
import GestionPlateau.PlateauGomoku;
import JeuDePlateau.JeuDePlateau;
import Joueurs.Joueur;
import Joueurs.JoueurHumain;

/**
 * représente une partie de Gomoku
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JeuDeGomoku extends JeuDePlateau 
{

    //ATTRIBUTS
    /**
     * <b> attribut </b>
     * le nombre de pions nécessaire à aligner pour gagner la partie
     */
    private int nbPionGagne;

    //CONSTRUCTEUR
    /**
     * <b>Constructeur</b> permet de créer un nouveau jeu pour lequel on choisi
     * les joueurs, la taille du plateau et le nombre de pions à aligner pour
     * gagner
     *
     * @param joueur1 permet de savoir quel joueur commence à jouer (vrai =
     * joueur 1, faux = joueur 2)
     * @param j1 le joueur j1
     * @param j2 le joueur j2
     * @param longueur la longeur du plateau
     * @param largeur la latrgeur du plateau
     * @param n nombre de pions à aligner pour gagner
     */
    public JeuDeGomoku(boolean joueur1, Joueur j1, Joueur j2, int longueur, int largeur, int n)
    {
        if (joueur1)
        {
            joueurCourant = j1;
        } else
        {
            joueurCourant = j2;
        }
        plateau = new PlateauGomoku(longueur, largeur);
        this.lesJoueurs = new Joueur[2];
        lesJoueurs[0] = j1;
        lesJoueurs[1] = j2;
        nbPionGagne = n;
    }

    /**
     * <b>Constructeur</b> permet de reprendre un jeu que l'on avait interrompu
     *
     * @param j1 le joueur j1
     * @param j2 le joueur j2
     * @param n nombre de pions à aligner pour gagner
     * @param p plateau de Gomoku que l'on souhaite utiliser
     */
    public JeuDeGomoku(Joueur j1, Joueur j2, int n, PlateauGomoku p)
    {
        this(p.getDernierId() == j2.getId(), j1, j2, p.getLongueur(), p.getLargeur(), n);
        plateau.initialiser(p.getHistorique());
    }
    
    /**
     * Jeu de Gomoku par défaut : les deux joueurs sont humains, 
     * le plateau mesure 9x9 cases et il faut quatre pions pour gagner
     */
    public JeuDeGomoku()
    {
        this.lesJoueurs = new Joueur[2];
        this.lesJoueurs[0]= new JoueurHumain(1);
        this.lesJoueurs[1]=new JoueurHumain(2);
        this.joueurCourant = this.lesJoueurs[0];
        this.plateau = new PlateauGomoku();
        this.nbPionGagne = 4;
    }

    @Override
    public boolean coupValide(Coup coup)
    {
        {
            return ((coup.getPosition().x > 0 && coup.getPosition().x <= plateau.getLongueur())
                    && (coup.getPosition().y > 0 && coup.getPosition().x <= plateau.getLargeur())
                    && plateau.getCase(coup.getPosition().x -1, coup.getPosition().y-1) == 0);
        }
    }

    /**
     * <b>Méthode</b> permet de savoir si le joueur courant a gagné
     *
     * @return vrai s'il a gagné et faux sinon
     */
    @Override
    public boolean partieTerminee()
    {
        return ((PlateauGomoku) (plateau)).CkeckGagneId(nbPionGagne, joueurCourant.getId());
    }

    /**
     * <b>Méthode</b> permettant de faire jouer les joueurs à tour de role
     * jusqu'a ce que l'un d'eux gagne
     *
     * @return le joueur gagnant
     */
    @Override
    public Joueur jouerPartie()
    {
//        System.out.println(plateau.toString());
//        System.out.println("Au tour du joueur d'ID : " + joueurCourant.getId() + "\n" );
        Coup c = joueurCourant.genererCoup(plateau);
        while (!(coupValide(c)))
        {
            c = joueurCourant.genererCoup(plateau);
        }
        plateau.jouer(c);
      //  System.out.println(plateau.toString());
        while (!(partieTerminee()))
        {
            joueurSuivant();
//            System.out.println("Au tour du joueur d'ID : " + joueurCourant.getId() + "\n" );
            c = joueurCourant.genererCoup(plateau);
           /* while (!(coupValide(c)))
            {
                c = joueurCourant.genererCoup(plateau);
            }*/
            plateau.jouer(c);
//            System.out.println(plateau.toString());
        }
        return joueurCourant;
    }

}
