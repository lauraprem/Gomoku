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

    public Position(int _x, int _y) {
        super(_x, _y);
    }

    @Override
    public String toString() {
        return "Position{" + x + "," + y + "}";
    }

    @Override
    public Object clone() {
        Object o = null;
        o = super.clone();
        return o;
    }

}
