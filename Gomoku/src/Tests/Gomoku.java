package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GestionPlateau.*;
import JeuGomoku.*;
import Joueurs.*;

/**
 *
 * @author Corinne
 */
public class Gomoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Plateau p = new Plateau(9, 9);
        System.out.println(p.toString());
    }

}
