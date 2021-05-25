package joueur;

import echec.IJoueur;
import echec.IPiece;
import echiquier.Plateau;
import org.junit.jupiter.api.Test;
import piece.Couleur;
import piece.Roi;
import utilitaire.Coords;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LE GAL Florian
 * @date 25/05/2021
 */
class IATest {

    @Test
    void play() {
        Coords coordsOrigine = new Coords(3,3);
        IJoueur ia = new IA(Couleur.NOIR);
        Plateau pl = new Plateau(ia, new Joueur(Couleur.BLANC));
        IPiece roi = new Roi(coordsOrigine, Couleur.NOIR);

        ia.play(pl);

        assertFalse(roi.getCoords().equals(coordsOrigine));
    }
}