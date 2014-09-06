package GestionPlateau;

/**
 * Représente un <b>Coup joué</b>
 *
 * @author Laura Prémillieu && Corinne
 */
public class Coup implements Cloneable {
    // ATTRIBUTS

    /**
     * <b> attribut </b>
     * correspond à l'id du joueur qui joue le Coup
     */
    private int id;

    /**
     * <b> attribut </b>
     * Position du Coup dans le plateau (x et y)
     */
    private Position position;

    // CONSTRUCTEUR
    /**
     * <b>Constructeur</b> permettant de créer un Coup avec une position et un
     * id donnée
     *
     * @param _id represente le numero du joueur qui joue le Coup
     * @param _pos represente la localisation dans le plateau (x et y)
     * @see Point (java.awt.Point)
     */
    public Coup(int _id, Position _pos) {
        id = _id;
        position = _pos;
    }

    // ACCESSEURS
    /**
     * <b>Accesseur</b> permettant de recuperer l'id du joueur
     *
     * @return id du joueur
     */
    public int getId() {
        return id;
    }

    /**
     * <b>Accesseur</b> permettant de recuperer la position du Coup
     *
     * @return position (x et y)
     */
    public Position getPosition() {
        return position;
    }

    // MUTATEURS
    /**
     * <b>Mutateur</b> permettant de modifier l'id du joueur du Coup
     *
     * @param id nouvel id du joueur
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <b>Mutateur</b> permettant de modifier la position du Coup
     *
     * @param position nouvelle position du Coup
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    // METHODES
    /**
     * <b>Méthode</b> permettant l'affichage d'un Coup
     *
     * @return Affichage du Coup
     */
    @Override
    public String toString() {
        return "Coup{" + "position=" + position + ", id=" + id + '}';
    }

    /**
     *<b>Méthode<\b> Clone le coup 
     * @return un clone du coup
     */
    @Override
    public Object clone() {
        Coup coup = null;
        try {
            coup = (Coup) super.clone();
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }

        // On clone l'attribut de type Patronyme qui n'est pas immuable.
        coup.position = (Position) position.clone();

        // on renvoie le clone
        return coup;
    }
}
