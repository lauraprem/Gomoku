/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tests;

import GestionPlateau.Coup;
import GestionPlateau.Plateau;
import GestionPlateau.PlateauGomoku;
import GestionPlateau.Position;
import JeuDePlateau.JeuGomoku.JeuDeGomoku;
import JeuDePlateau.JeuGomoku.JeuDeGomokuFactory;
import Joueurs.Joueur;
import java.util.ArrayList;

/**
 *
 * @author leclerc
 */
public class Main
{
     public static void main(String[] args) {
         Plateau p = new PlateauGomoku();
         System.out.println(p.toString());
         
         
         System.out.println("Premier Coup\n");
         Coup c = new Coup(1, new Position(8,9));
         p.jouer(c);
         System.out.println(p.toString());
         
         System.out.println("Second Coup\n");
         c = new Coup(2, new Position(1,1));
         p.jouer(c);
         System.out.println(p.toString());
         
         System.out.println("Début de la partie humain VS aléatoire");
         JeuDeGomokuFactory f = new JeuDeGomokuFactory();
         JeuDeGomoku j = f.CreerPartieHumainVSAleatoire(null);
         
         Joueur monj = j.jouerPartie();
         System.out.println("Le gagnant est le " +monj.toString());
         
         /*ArrayList<Coup> historique = new ArrayList();
         historique.add(new Coup(1,new Point(1, 1)));
         historique.add(new Coup(2,new Point(5, 3)));
         historique.add(new Coup(1,new Point(4, 7)));
         historique.add(new Coup(2,new Point(8, 8)));*/
         
         System.out.println("Fin de la partie \n\n");
         System.out.println("Début de la partie reprise \n");
         JeuDeGomoku j2 = f.CreerPartieHumainVSAleatoire(j.getPlateau().getHistorique());
         monj = j2.jouerPartie();
         System.out.println("Le gagnant est le " +monj.toString());
          System.out.println("Fin de la partie \n\n");
     }
}
