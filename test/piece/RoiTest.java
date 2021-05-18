package piece;

import Echiquier.Coords;
import Echiquier.Plateau;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoiTest {

    @Test
    void peutAllerEn() {
    }

    @Test
    void craintEchec() {
    }

    @Test
    void coupLegal() {
    }

    @Test
    void menace() {
    }

    @Test
    void testToString() {
    }

    @Test
    void canMove() {
        Plateau pl = new Plateau();
        Roi roi = new Roi(new Coords(5,5), Couleur.BLANC);
        assertTrue(roi.canMove(pl));
        Tour tour1 = new Tour(new Coords(5,8), Couleur.BLANC);
        Tour tour2 = new Tour(new Coords(5,7), Couleur.BLANC);
        Tour tour3 = new Tour(new Coords(5,9), Couleur.BLANC);
//        assertFalse(roi.canMove(pl)); // --- BUG
    }
}