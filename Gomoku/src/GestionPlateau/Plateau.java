/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPlateau;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Corinne
 */
public class Plateau {

    //1 joueur 1, 2 joueur 2
    // ATTRIBUTS
    private int longueur;
    private int largeur;
    private int[][] etatPlateau;
    private ArrayList<Coup> historique;

    // CONSTRUCTEURS
    public Plateau() {
    }

    public Plateau(int _longueur, int _largeur) {
        longueur = _longueur;
        largeur = _largeur;

        etatPlateau = new int[longueur][largeur];
        initialiser();
    }

    // MUTTATEURS
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setEtatPlateau(int[][] etatPlateau) {
        this.etatPlateau = etatPlateau;
    }

    // ACCESSEURS
    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int[][] getEtatPlateau() {
        return etatPlateau;
    }

    public ArrayList<Point> etatId(int id) {
        ArrayList<Point> listPosition = null;
        Point p;

        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (etatPlateau[i][j] == id) {
                    p = new Point(i, j);
                    listPosition.add(p);
                }
            }
        }
        return listPosition;
    }

    // METHODES
    public void initialiser() {
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                etatPlateau[i][j] = 0;
            }
        }
    }

    public void jouer(Coup coup) {
        if (coup != null && coup.getPosition().x < longueur && coup.getPosition().y < largeur)// && coup.getId())
        {
            etatPlateau[coup.getPosition().x][coup.getPosition().y] = coup.getId();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                sb.append(etatPlateau[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        String fullString = sb.toString();

        return fullString;
    }
}
