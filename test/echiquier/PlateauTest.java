package echiquier;

import org.junit.jupiter.api.Test;
import utilitaire.Coords;
import utilitaire.PaireCoords;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {



    @Test
    void isCaseOccupee() {
        Coords coords = new Coords(8,1);
        Plateau pl = FabriquePlateau.createPlateau("1");
        assertTrue(pl.isCaseOccupee(coords));
    }

    @Test
    void play() {
    }

    @Test
    void canPiecePlayCoords() {
        Plateau pl = FabriquePlateau.createPlateau("1");
        PaireCoords paireCoords1 = new PaireCoords(new Coords(1,5), new Coords(1,6));
        //assertTrue(pl.canPiecePlayCoords(paireCoords1));
        PaireCoords paireCoords2 = new PaireCoords(new Coords(1,5), new Coords(5,6));
        //assertFalse(pl.canPiecePlayCoords(paireCoords2));
    }

    @Test
    void testToString() {
        StringBuilder expected = new StringBuilder();
        expected.append("    a   b   c   d   e   f   g   h\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("8 |   |   |   | r |   |   |   |   | 8\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("7 |   |   |   |   |   |   |   |   | 7\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("6 |   |   |   |   |   |   |   |   | 6\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("5 |   |   |   |   |   |   |   |   | 5\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("4 |   |   |   |   |   |   |   |   | 4\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("3 |   |   |   |   |   |   |   |   | 3\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("2 |   |   |   |   |   |   |   |   | 2\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("1 | T |   |   |   | R |   |   |   | 1\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("    a   b   c   d   e   f   g   h\n");
        Plateau pl = FabriquePlateau.createPlateau("1");
        assertEquals(expected, pl);
    }

    @Test
    void gagnantExistant() {
        Plateau pl = FabriquePlateau.createPlateau("1");
        assertFalse(pl.gagnantExistant());
    }
}