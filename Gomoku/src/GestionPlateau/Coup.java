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
public class Coup {
    // ATTRIBUTS
    private Point position;
    private int id;
    
    // CONSTRUCTEURS
    public Coup(int _id, Point _pos){
        id = _id;
        position = _pos;
    }
    
    // ACCESSEURS
    public Point getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }
    
    // MUTTATEURS
    public void setPosition(Point position) {
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // METHODES
    @Override
    public String toString() {
        return "Coup{" + "position=" + position + ", id=" + id + '}';
    }
}
