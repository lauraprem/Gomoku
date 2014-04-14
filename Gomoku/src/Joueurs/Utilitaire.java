/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Joueurs;

import java.util.Random;
/**
 * classe donnant des outils utiles à la programmation
 * @author Laura Prémillieu && Corinne Fagno
 */
public class Utilitaire 
{
    /**
     * <b>méthode statique</b> permet de générer un nombre aléatoire entre deux bornes choisies
     * @param min borne minimum
     * @param max borne maximum
     * @return un entier aléatoire
     */
    public static int monRamdom(int min, int max)
    {
        Random r = new Random();
        return r.nextInt((max-min))+min;
    }
}

