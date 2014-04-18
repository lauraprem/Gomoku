/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPlateau;

import java.awt.Point;

/**
 *
 * @author Corinne
 */
public class Position extends Point implements Cloneable {

    /**
     * <b>Constructeur<\b> construit une position
     * @param _x paramètre x
     * @param _y paramètre y
     */
    public Position(int _x, int _y) {
        super(_x, _y);
    }

    /**
     * <b>Méthode<\b> Permet d'afficher une position
     * @return une chaine pour afficher une position
     */
    @Override
    public String toString() {
        return "Position{" + x + "," + y + "}";
    }
    

    /**
     *<b>Méthode<\b> Clone la position 
     * @return un clone de la position
     */
    @Override
    public Object clone() {
        Object o = null;
        o = super.clone();
        return o;
    }

}
