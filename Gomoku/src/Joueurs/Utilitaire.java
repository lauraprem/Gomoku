/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Joueurs;

import java.util.Random;
/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class Utilitaire 
{
    public static int monRamdom(int min, int max)
    {
        Random r = new Random();
        return r.nextInt((max-min))+min;
    }
}

