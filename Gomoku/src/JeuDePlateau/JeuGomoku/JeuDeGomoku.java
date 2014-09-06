package JeuDePlateau.JeuGomoku;

import GestionPlateau.Coup;
import GestionPlateau.PlateauGomoku;
import JeuDePlateau.JeuDePlateau;
import Joueurs.Joueur;
import Joueurs.JoueurHumain;

/**
 * représente une partie de Gomoku
 *
 * @author Laura Prémillieu && Corinne
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
     * Jeu de Gomoku par défaut : les deux joueurs sont humains, le plateau
     * mesure 9x9 cases et il faut quatre pions pour gagner
     */
    public JeuDeGomoku()
    {
        this.lesJoueurs = new Joueur[2];
        this.lesJoueurs[0] = new JoueurHumain(1);
        this.lesJoueurs[1] = new JoueurHumain(2);
        this.joueurCourant = this.lesJoueurs[0];
        this.plateau = new PlateauGomoku();
        this.nbPionGagne = 4;
    }

    /**
     * <b>Methode<\b> Permet de retrouver un joueur avec son ID
     *
     * @param id du joueur
     * @return le joueur
     */
    public Joueur getLesJoueur(int id)
    {
        if (lesJoueurs[0].getId() == id)
        {
            return lesJoueurs[0];
        } else if (lesJoueurs[1].getId() == id)
        {
            return lesJoueurs[1];
        } else
        {
            return null;
        }
    }

    @Override
    public boolean coupValide(Coup coup)
    {
        {
            /*if (coup == null)
             return false;*/
            return ((coup.getPosition().x > 0 && coup.getPosition().x <= plateau.getLongueur())
                    && (coup.getPosition().y > 0 && coup.getPosition().x <= plateau.getLargeur())
                    && plateau.getCase(coup.getPosition().x - 1, coup.getPosition().y - 1) == 0);
        }
    }

    /**
     * <b>Méthode</b> permet de savoir si la partie est terminée
     *
     * @return 1 si le joueur courant a gagné, 0 si nul, -1 si partie pas
     * terminée
     */
    @Override
    public int partieTerminee(Coup c)
    {
        if (((PlateauGomoku) (plateau)).CheckGagneId(nbPionGagne, joueurCourant.getId(), c.getPosition()))
        {
            return 1;
        } else if (c == null || plateau.etatId(0).isEmpty())
        {
            return 0;
        } else
        {
            return -1;
        }
    }

    /**
     * <b>Méthode</b> Permet de savoir si l'un des joueurs a gagné ou s'il y a
     * nul
     *
     * @return identifiant du gagnant, -1 si aucun gagnant mais partie en cous,
     * 0 si nul
     */
    public int joueurGagnant()
    {
        int g = ((PlateauGomoku) plateau).CheckPlateau(nbPionGagne);
        if (g != -1)
        {
            return g;
        } else if (plateau.etatId(0).isEmpty())
        {
            return 0;
        }
        return -1;

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
        int id = joueurGagnant();
        if (id == 0)
        {
            return null;
        } else if (id != 0 && id != -1)
        {
            return getLesJoueur(id);
        }

        System.out.println(plateau.toString());
        System.out.println("Au tour du joueur d'ID : " + joueurCourant.getId() + "\n");
        Coup c = joueurCourant.genererCoup(plateau);
        while (!(coupValide(c)))
        {
            if (joueurCourant instanceof JoueurHumain)
            {
                System.out.println("Cette case est déjà occupée, veuillez rejouer : \n");
            }
            c = joueurCourant.genererCoup(plateau);
        }
        plateau.jouer(c);
        System.out.println(plateau.toString());

        while (partieTerminee(c) == -1)
        {
            joueurSuivant();
            System.out.println("Au tour du joueur d'ID : " + joueurCourant.getId() + "\n");
            c = joueurCourant.genererCoup(plateau);
            if (c == null)
            {
                return null;
            }
            while (!(coupValide(c)))
            {
                if (joueurCourant instanceof JoueurHumain)
                {
                    System.out.println("Cette case est déjà occupée, veuillez rejouer : \n");
                }
                c = joueurCourant.genererCoup(plateau);
            }
            plateau.jouer(c);
            System.out.println(plateau.toString());
        }

        if (partieTerminee(c) == 1)
        {
            return joueurCourant;
        } else
        {
            return null;
        }
    }

    /**
     * <b>Méthode</b> permettant de faire jouer les joueurs à tour de role
     * jusqu'a ce que l'un d'eux gagne sans affichage
     *
     * @return le joueur gagnant
     */
    @Override
    public Joueur jouerPartieSansAffichage()
    {

        int id = joueurGagnant();
        if (id == 0)
        {
            return null;
        } else if (id != 0 && id != -1)
        {
            return getLesJoueur(id);
        }

        Coup c = joueurCourant.genererCoup(plateau);
        while (!(coupValide(c)))
        {
            c = joueurCourant.genererCoup(plateau);
        }
        plateau.jouer(c);

        while (partieTerminee(c) == -1)
        {
            joueurSuivant();
            c = joueurCourant.genererCoup(plateau);
            if (c == null)
            {
                return null;
            }
            while (!(coupValide(c)))
            {
                c = joueurCourant.genererCoup(plateau);
            }
            plateau.jouer(c);
        }
        if (partieTerminee(c) == 1)
        {
            return joueurCourant;
        } else
        {
            return null;
        }

    }
}
