package JeuDePlateau;

import GestionPlateau.Coup;

import java.util.ArrayList;

/**
 *
 * @author Laura Prémillieu && Corinne Fagno
 */
public interface JeuDePlateauFactory
{

    JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation);

    JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation);

    JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation);

//    JeuDePlateau CreerPartieAleatoireVSMonteCarlo(ArrayList<Coup> situation);
//
//    JeuDePlateau CreerPartieHumainVSMonteCarlo(ArrayList<Coup> situation);
//
//    JeuDePlateau CreerPartieMonteCarloVSMonteCarlo(ArrayList<Coup> situation);
}
