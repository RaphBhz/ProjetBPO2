package echiquier;

import org.junit.jupiter.api.Test;
import utilitaire.Coords;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {



    @Test
    void isCaseOccupee() {
        Coords coords = new Coords(1,5);
        Plateau pl = FabriquePlateau.createPlateau("1");
        assertTrue(pl.isCaseOccupee(coords));
    }

    @Test
    void testToString() {
        Plateau pl = FabriquePlateau.createPlateau("1");

        StringBuilder expected = new StringBuilder();
        expected.append("    a   b   c   d   e   f   g   h\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("8 \\| [t\\s] \\| [t\\s] \\| [t\\s] \\| r \\| [t\\s] \\| [t\\s] \\| [t\\s] \\| [t\\s] \\| 8\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("7 \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| 7\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("6 \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| 6\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("5 \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| 5\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("4 \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| 4\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("3 \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| 3\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("2 \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| [tT\\s] \\| 2\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("1 \\| [T\\s] \\| [T\\s] \\| [T\\s] \\| [T\\s] \\| R \\| [T\\s] \\| [T\\s] \\| [T\\s] \\| 1\n");
        expected.append("   --- --- --- --- --- --- --- ---\n");
        expected.append("    a   b   c   d   e   f   g   h\n");

        assertTrue(Pattern.matches(expected.toString(), pl.toString()));
    }

    @Test
    void gagnantExistant() {
        Plateau pl = FabriquePlateau.createPlateau("1");
        assertFalse(pl.gagnantExistant());
    }

    @Test
    void getOneCoupPossible() {
        Plateau pl = FabriquePlateau.createPlateau("1");
        assertNotNull(pl.getOneCoupPossible(Couleur.BLANC));
        assertNull(pl.getOneCoupPossible(Couleur.NOIR));

    }
}