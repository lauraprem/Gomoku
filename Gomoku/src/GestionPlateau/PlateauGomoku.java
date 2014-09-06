package GestionPlateau;

/**
 * représsente un plateau de gomoku, qui étend un plateau de manière plus
 * générale
 *
 * @author Laura Prémillieu && Corinne
 */
public class PlateauGomoku extends Plateau
{

    /**
     * <b>Constructeur</b> permettant de faire un plateau de taille 9,9
     */
    public PlateauGomoku()
    {
        super(9, 9);
    }

    /**
     * <b>Constructeur</b> permettant de faire un plateau de la taille que l'on
     * souhaite
     *
     * @param _longueur longueur du plateau
     * @param _largeur largeur du plateau
     */
    public PlateauGomoku(int _longueur, int _largeur)
    {
        super(_longueur, _largeur);
    }

    /**
     * <b>Méthode</b> permettant de vérifier si un coup est gagnant sur une
     * ligne en partant d'un point donné
     *
     * @param pos position du premier point pour tester une ligne gagnante
     * @param n nombre de pions necessaire à aligner pour gagner
     * @param id identifiant du joueur pour lequel on teste le coup
     * @return vrai si la ligne est gagnante et faux si elle ne l'est pas
     */
    public boolean CheckLigneId(Position pos, int n, int id)
    {
        int x = pos.x;
        int y = pos.y;
        int y_end = y + n;
        while (y <= largeur && y < y_end && etatPlateau[x - 1][y - 1] == id)
        {
            y++;
        }
        return y == y_end;
    }

    /**
     * <b>Méthode</b> permettant de vérifier si un coup est gagnant sur une
     * colone en partant d'un point donné
     *
     * @param pos position du premier point pour tester une colone gagnante
     * @param n nombre de pions necessaire à aligner pour gagner
     * @param id identifiant du joueur pour lequel on teste le coup
     * @return vrai si la colone est gagnante et faux si elle ne l'est pas
     */
    public boolean CheckColonneId(Position pos, int n, int id)
    {
        int x = pos.x;
        int y = pos.y;
        int x_end = x + n;
        while (x <= longueur && x < x_end && etatPlateau[x - 1][y - 1] == id)
        {
            x++;
        }
        return x == x_end;
    }


    /**
     * <b> Méthode<\b> Permet de vérifier si le joueur dont on passe l'id
     * a gagné grace à son dernier coup
     * @param n
     * @param id
     * @param p
     * @return 
     */
    public boolean CheckGagneId(int n, int id, Position p)
    {
        for (int i = 1; i <= longueur - n; i++)
        {
            if (CheckColonneId(new Position(i, p.y), n, id))
            {
                return true;
            }
        }

        for (int j = 1; j <= largeur - n; j++)
        {
            if (CheckLigneId(new Position(p.x, j), n, id))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * <b>Méthode</b> Permet de savoir si l'un des joueurs a gagné
     *
     * @param n nom nombre de pion à aligner pour gagner
     * @return identifiant du gagnant ou -1 si aucun gagnant
     */
    public int CheckPlateau(int n)
    {
        for (int i = 1; i <= longueur; i++)
        {
            for (int j = 1; j <= largeur; j++)
            {
                if (i <= longueur - n && CheckColonneId(new Position(i, j), n, 1))
                {
                    return 1;
                }
                if (i <= longueur - n && CheckColonneId(new Position(i, j), n, 2))
                {
                    return 2;
                }
                if (j <= largeur - n && CheckLigneId(new Position(i, j), n, 1))
                {
                    return 1;
                }
                if (j <= largeur - n && CheckLigneId(new Position(i, j), n, 2))
                {
                    return 2;
                }
            }
        }
        return -1;
    }
    
    
    
}
