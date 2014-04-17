package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GestionPlateau.*;
import JeuDePlateau.JeuDePlateau;
import JeuDePlateau.JeuDePlateauFactory;
import JeuDePlateau.JeuGomoku.JeuDeGomokuFactory;
import Joueurs.*;
import Joueurs.MonteCarlo.JoueurMonteCarlo;
import java.util.ArrayList;

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

        // Pour tester
        ArrayList<Coup> sit = new ArrayList<Coup>();
        sit.add(new Coup(2, new Position(0, 2)));
        sit.add(new Coup(2, new Position(1, 2)));
        sit.add(new Coup(2, new Position(2, 5)));
        sit.add(new Coup(2, new Position(5, 2)));
        sit.add(new Coup(1, new Position(3, 4)));
        sit.add(new Coup(1, new Position(3, 5)));
        sit.add(new Coup(1, new Position(3, 6)));
//        sit.add(new Coup(1, new Position(3, 7)));

        p.initialiser(sit);

        JeuDePlateauFactory factory = new JeuDeGomokuFactory();

        JoueurMonteCarlo jmc = new JoueurMonteCarlo(1, 100, factory);

        System.out.println(p.toString());

        System.out.println(jmc.genererCoup(p).toString());
    }

}
