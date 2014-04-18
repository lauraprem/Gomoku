package GestionPlateau;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Représente le <b>Plateau de jeu</b>
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class Plateau {
    // ATTRIBUTS   
    /**
     * Nombre de lignes du Plateau
     */
    protected int longueur;

    /**
     * Nombre de colonnes du Plateau
     */
    protected int largeur;

    /**
     * Etat du plateau
     */
    protected int[][] etatPlateau;

    /**
     * Historique des Coups joués par les joueurs
     *
     * @see Coup
     */
    protected ArrayList<Coup> historique;

    // CONSTRUCTEUR
    /**
     * <b>Constructeur</b> permettant de créer un Plateau avec des tailles
     * données
     *
     * @param _longueur Nombre de lignes du Plateau
     * @param _largeur Nombre de colonnes du Plateau
     */
    public Plateau(int _longueur, int _largeur) {
        longueur = _longueur;
        largeur = _largeur;

        etatPlateau = new int[longueur][largeur];
        initialiser();
    }

    // ACCESSEURS
    /**
     * <b>Accesseur</b> permettant de recuperer le nombre de lignes du Plateau
     *
     * @return nombre de lignes du Plateau
     */
    public int getLongueur() {
        return longueur;
    }

    /**
     * <b>Accesseur</b> permettant de recuperer le nombre de colonnes du Plateau
     *
     * @return nombre de colonnes du Plateau
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * <b>Accesseur</b> permettant de recuperer l'état du Plateau
     *
     * @return tableau 2D d'entier contenant l'état du jeu
     */
    public int[][] getEtatPlateau() {
        return etatPlateau;
    }

    /**
     * <b>Accesseur</b> permettant de recuperer l'état d'une case du Plateau
     *
     * @param x numéro de la ligne où se trouve la case
     * @param y numéro de la colonne où se trouve la case
     * @return 0 ou l'id du joueur qui a joué sur cette case
     */
    public int getCase(int x, int y) {
        return etatPlateau[x][y];
    }

    /**
     * <b>Accesseur</b> permettant de recuperer l'historique des Coups joués sur
     * le Plateau
     *
     * @return Tout les Coups joués sur le Plateau
     * @see Coup
     */
    public ArrayList<Coup> getHistorique() {
        return historique;
    }

    // MUTATEURS
    /**
     * <b>Mutateur</b> permettant de modifier le nombre de lignes du Plateau
     *
     * @param longueur nouveau nombre de lignes du Plateau
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    /**
     * <b>Mutateur</b> permettant de modifier le nombre de colonnes du Plateau
     *
     * @param largeur nouveau nombre de colonnes du Plateau
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     * <b>Mutateur</b> permettant de modifier l'état du Plateau
     *
     * @param etatPlateau tableau 2D d'entier contenant l'état du jeu
     */
    public void setEtatPlateau(int[][] etatPlateau) {
        this.etatPlateau = etatPlateau;
    }

    // METHODES
    /**
     * <b>Méthode</b> permettant de recuperer les coordonnées de toutes les
     * cases joué par un joueur donné
     *
     * @param id du joueur
     * @return liste de points qui représente les coordonnées des cases joué
     * @see Point
     */
    public ArrayList<Position> etatId(int id) {
        ArrayList<Position> listPosition = new ArrayList<Position>();
        Position p;

        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (etatPlateau[i][j] == id) {
                    p = new Position(i, j);
                    listPosition.add(p);
                }
            }
        }
        return listPosition;
    }

    /**
     * permet de récupérer une copi profonde de l'historique
     *
     * @return liste de coup équivalent à l'historique
     */
    public ArrayList<Coup> getSituation() {
        ArrayList<Coup> res = new ArrayList<Coup>();
        for (int i = 0; i < this.getHistorique().size(); i++) {
            Coup c = (Coup) this.getHistorique().get(i).clone();
            res.add(c);
        }

        return res;
    }

    /**
     * permet de connaitre l'identifiant du dernier joueur à avoir joué
     *
     * @return l'identifiant du dernier jouer avoir jouer, 0 si personne n'a
     * encore joué
     */
    public int getDernierId() {
        if (historique.isEmpty()) {
            return 0;
        }
        return historique.get(historique.size() - 1).getId();
    }

    /**
     * <b>Méthode</b> permettant d'initialiser l'état de toutes les cases du
     * Plateau à 0
     */
    public void initialiser() {
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                etatPlateau[i][j] = 0;
            }
        }
        historique = new ArrayList<Coup>();
    }

    /**
     * <b>Méthode</b> permettant d'initialiser l'état de toutes les cases du
     * Plateau à 0, sauf les cases évoquées dans l'historique qui auront un état
     * égal à l'id du joueur qui a joué sur ces cases
     *
     * @param coupsPrecedents Historique de Coups
     * @see Coup
     */
    public void initialiser(ArrayList<Coup> coupsPrecedents) {
        this.initialiser();

        historique = coupsPrecedents;

        Iterator<Coup> it = historique.iterator();

        while (it.hasNext()) {
            Coup coup = (Coup) it.next();
            if (coup.getPosition().x >= 0 && coup.getPosition().x < longueur
                    && coup.getPosition().y >= 0 && coup.getPosition().y < largeur) {
                etatPlateau[coup.getPosition().x][coup.getPosition().y] = coup.getId();
            }
        }
    }

    /**
     * <b>Méthode</b> permettant de modifier l'état de la case où le joueur a
     * joué. L'état de la case prendra la valeur de l'id
     *
     * @param coup le Coup que le joueur vient de jouer
     * @return 'true' si le Coup à bin été joué sinon 'false'
     * @see Coup
     */
    public boolean jouer(Coup coup) {
        if (coup != null
                && coup.getPosition().x <= longueur && coup.getPosition().x > 0
                && coup.getPosition().y <= largeur && coup.getPosition().y > 0
                && etatPlateau[coup.getPosition().x - 1][coup.getPosition().y - 1] == 0) {
            etatPlateau[coup.getPosition().x - 1][coup.getPosition().y - 1] = coup.getId();

            //Enregistrement Coup dans historique
            Coup coupCorrige = new Coup(coup.getId(),new Position(coup.getPosition().x - 1, coup.getPosition().y - 1));
            historique.add(coupCorrige);

            return true;
        }
        return false;
    }

    /**
     * <b>Méthode</b> permettant d'annuler le dernier Coup joué
     *
     * @return le Coup qui a été annulé
     * @see Coup
     */
    public Coup annuler() {
        if (historique.isEmpty() != true) {
            Coup coup = historique.get(historique.size() - 1);

            //Annulation du coup
            etatPlateau[coup.getPosition().x][coup.getPosition().y] = 0;

            //Suppression du coup de l'historique
            historique.remove(historique.size() - 1);

            return coup;
        }
        return null;
    }

    public void setHistorique(ArrayList<Coup> historique) {
        this.historique = historique;
    }

    /**
     * <b>Méthode</b> permettant l'affichage d'un Plateau
     *
     * @return Affichage du Plateau
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     ");
        for (int i = 1; i <= longueur; i++)
        {sb.append(i + "  "); }
        sb.append("\n\n");
        for (int i = 0; i < longueur; i++) {
            sb.append(i+1); sb.append("    ");
            for (int j = 0; j < largeur; j++) {
                
                sb.append(etatPlateau[i][j]);
                sb.append("  ");
            }
            sb.append("\n");
        }
        String fullString = sb.toString();

        return fullString;
    }
}
