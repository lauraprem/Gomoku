/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tests;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import GestionPlateau.PlateauGomoku;
import JeuDePlateau.JeuGomoku.JeuDeGomoku;
import JeuDePlateau.JeuGomoku.JeuDeGomokuFactory;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author leclerc
 */
public class Main
{
     public static void main(String[] args) {
       /*  Plateau p = new PlateauGomoku();
         System.out.println(p.toString());
         
         Coup c = new Coup(1, new Point(8,9));
         p.jouer(c);
         System.out.println(p.toString());
         
         c = new Coup(2, new Point(1,1));
         p.jouer(c);
         System.out.println(p.toString());*/
         
         JeuDeGomokuFactory f = new JeuDeGomokuFactory();
         //JeuDeGomoku j = f.CreerPartieHumainVSAleatoire(null);
         
         //j.jouerPartie();
         ArrayList<Coup> historique = new ArrayList();
         historique.add(new Coup(1,new Point(1, 1)));
         historique.add(new Coup(2,new Point(5, 3)));
         historique.add(new Coup(1,new Point(4, 7)));
         historique.add(new Coup(2,new Point(8, 8)));
         JeuDeGomoku j2 = f.CreerPartieHumainVSAleatoire(historique);
         j2.jouerPartie();
     }
}
