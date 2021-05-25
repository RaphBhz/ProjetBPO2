package piece;

import echec.IPiece;
import echiquier.Couleur;
import echiquier.FabriquePiece;
import echiquier.Plateau;
import echiquier.TypesPieces;
import joueur.Joueur;
import org.junit.jupiter.api.Test;
import utilitaire.Coords;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LE GAL Florian
 * @date 25/05/2021
 */
class RoiTest {

    @Test
    void peutAllerEn() {
        Plateau pl = new Plateau(new Joueur(Couleur.BLANC), new Joueur(Couleur.NOIR));
        IPiece roi = FabriquePiece.createPiece(Couleur.BLANC, TypesPieces.ROI, new Coords(1,1));

        if (roi == null)
            fail();

        assertTrue(roi.peutAllerEn(new Coords(1,2), pl));
        assertFalse(roi.peutAllerEn(new Coords(3,1), pl));
    }

    @Test
    void craintEchec() {
        IPiece roi = FabriquePiece.createPiece(Couleur.BLANC, TypesPieces.ROI, new Coords(1,1));
        if (roi == null)
            fail();
        assertTrue(roi.craintEchec());
    }

    @Test
    void testToString() {
        IPiece roi = FabriquePiece.createPiece(Couleur.BLANC, TypesPieces.ROI, new Coords(1,1));
        IPiece roi2 = FabriquePiece.createPiece(Couleur.NOIR, TypesPieces.ROI, new Coords(2,2));
        if (roi == null || roi2 == null)
            fail();
        assertEquals(roi.toString(), "R");
        assertNotEquals(roi2.toString(), "R");
        assertEquals(roi2.toString(), "r");

    }
}