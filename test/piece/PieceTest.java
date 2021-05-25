package piece;

import echec.IPiece;
import echiquier.Couleur;
import org.junit.jupiter.api.Test;
import utilitaire.Coords;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LE GAL Florian
 * @date 25/05/2021
 */
class PieceTest {

    @Test
    void isPieceInCoords() {
        IPiece piece = new Roi(new Coords(1,1), Couleur.NOIR);
        assertTrue(piece.isPieceInCoords(new Coords(1,1)));
        assertFalse(piece.isPieceInCoords(new Coords(2,1)));
    }

    @Test
    void coupLegal() {
        IPiece piece = new Roi(new Coords(1,1), Couleur.NOIR);
        assertTrue(piece.coupLegal(new Coords(2,1)));
        assertFalse(piece.coupLegal(new Coords(1,1)));
        assertFalse(piece.coupLegal(new Coords(9,9)));
    }

    @Test
    void craintEchec() {
        IPiece piece = new Tour(new Coords(1,1), Couleur.NOIR);
        assertFalse(piece.craintEchec());

    }

    @Test
    void isBlack() {
        IPiece piece = new Tour(new Coords(1,1), Couleur.NOIR);
        IPiece piece2 = new Tour(new Coords(1,1), Couleur.BLANC);
        assertTrue(piece.isBlack());
        assertFalse(piece2.isBlack());
    }

    @Test
    void setPos() {
        IPiece piece = new Tour(new Coords(1,1), Couleur.NOIR);
        piece.setPos(new Coords(2,1));
        assertTrue(piece.getCoords().equals(new Coords(2,1)));
    }
}