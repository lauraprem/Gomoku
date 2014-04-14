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
}
