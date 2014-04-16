package JeuDePlateau.JeuGomoku;

import GestionPlateau.Coup;
import GestionPlateau.PlateauGomoku;
import JeuDePlateau.*;
import Joueurs.Joueur;
import Joueurs.JoueurAleatoire;
import Joueurs.JoueurHumain;
import Joueurs.MonteCarlo.JoueurMonteCarlo;
import java.util.ArrayList;

/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public class JeuDeGomokuFactory implements JeuDePlateauFactory
{

    @Override
    public JeuDeGomoku CreerPartieHumainVSHumain(ArrayList<Coup> situation)
    {
        JeuDeGomoku j = new JeuDeGomoku(2 == situation.get(situation.size() - 1).getId(),
                new JoueurHumain(1), new JoueurHumain(2), 9, 9, 4);
        j.getPlateau().initialiser(situation);
        return j;
    }

    @Override
    public JeuDeGomoku CreerPartieHumainVSAleatoire(ArrayList<Coup> situation)
    {
        if (situation == null)
        {
            Joueur j1 = new JoueurHumain(1);
            Joueur j2 = new JoueurAleatoire(2);
            JeuDeGomoku j = new JeuDeGomoku(true, j1, j2, 9, 9, 4);
            return j;
        }
        else
        {/*JeuDeGomoku j = new JeuDeGomoku(2 == situation.get(situation.size() - 1).getId(),
                new JoueurHumain(1), new JoueurAleatoire(2), 9, 9, 4);
        j.getPlateau().initialiser(situation);*/
            PlateauGomoku p = new PlateauGomoku();
            p.setHistorique(situation);
            JeuDeGomoku j = new JeuDeGomoku(new JoueurHumain(situation.get(0).getId()), 
                    new JoueurAleatoire(situation.get(1).getId()), 4, p);
        return j;
        }
    }

    @Override
    public JeuDeGomoku CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation)
    {
        JeuDeGomoku j = new JeuDeGomoku(2 == situation.get(situation.size() - 1).getId(),
                new JoueurAleatoire(1), new JoueurAleatoire(2), 9, 9, 4);
        j.getPlateau().initialiser(situation);
        return j;
    }

//    @Override
//    public JeuDePlateau CreerPartieAleatoireVSMonteCarlo(ArrayList<Coup> situation)
//    {        JeuDeGomoku j = new JeuDeGomoku(2 == situation.get(situation.size() - 1).getId(),
//                new JoueurAleatoire(1), new JoueurMonteCarlo(2), 9, 9, 4);
//        j.getPlateau().initialiser(situation);
//        return j;   }
//
//    @Override
//    public JeuDePlateau CreerPartieHumainVSMonteCarlo(ArrayList<Coup> situation)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public JeuDePlateau CreerPartieMonteCarloVSMonteCarlo(ArrayList<Coup> situation)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    

}
