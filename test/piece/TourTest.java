package piece;

import echec.IPiece;
import echiquier.Plateau;
import joueur.Joueur;
import org.junit.jupiter.api.Test;
import utilitaire.Coords;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LE GAL Florian
 * @date 25/05/2021
 */
class TourTest {

    @Test
    void peutAllerEn() {
        Plateau pl = new Plateau(new Joueur(Couleur.BLANC), new Joueur(Couleur.NOIR));
        IPiece tour = PieceFactory.createPiece(Couleur.BLANC, TypesPieces.TOUR, new Coords(1,1));

        if (tour == null)
            fail();

        assertTrue(tour.peutAllerEn(new Coords(1,5), pl));
        assertFalse(tour.peutAllerEn(new Coords(3,2), pl));
    }

    @Test
    void testToString() {
        IPiece tour = PieceFactory.createPiece(Couleur.BLANC, TypesPieces.TOUR, new Coords(1,1));
        IPiece tour2 = PieceFactory.createPiece(Couleur.NOIR, TypesPieces.TOUR, new Coords(2,2));
        if (tour == null || tour2 == null)
            fail();
        assertEquals(tour.toString(), "T");
        assertNotEquals(tour2.toString(), "T");
        assertEquals(tour2.toString(), "t");

    }
}