/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPlateau;

/**
 *
 * @author Corinne
 */
public class PlateauPuissance4 extends PlateauGomoku {

    public PlateauPuissance4(int longueur, int largeur)
    {super(longueur,largeur); }

    public PlateauPuissance4()
    {super(); }

    @Override
    public boolean jouer(Coup coup) {
        if (coup != null) {
            Position p = PremCaseVideColonne(coup.getPosition().y-1);
            if (p != null) {
                Coup coupAJouer = new Coup(coup.getId(), p);

                etatPlateau[coupAJouer.getPosition().x][coupAJouer.getPosition().y ] = coupAJouer.getId();

                //Enregistrement Coup dans historique
                historique.add(coupAJouer);
            }
        }
        return false;
    }

    public Position PremCaseVideColonne(int colonne) {
        int i = 0;
        while (i < this.largeur) {
            if (this.etatPlateau[i][colonne] != 0 && (i - 1) > 0) {
                return new Position(i, colonne);
            }
            i++;
        }
        return null;
    }
}
