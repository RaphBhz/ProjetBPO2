package Echiquier;

import org.junit.jupiter.api.Test;
import utilitaire.Coords;
import utilitaire.PaireCoords;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void getPieceAtCoords() {
        Coords coords = new Coords(8,1);
        Plateau pl = FabriquePlateau.createPlateau("1");
        assertEquals(pl.getPieceAtCoords(coords).toString(), "t");
    }

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
        assertTrue(pl.canPiecePlayCoords(paireCoords1));
        PaireCoords paireCoords2 = new PaireCoords(new Coords(1,5), new Coords(5,6));
        assertFalse(pl.canPiecePlayCoords(paireCoords2));
    }

    @Test
    void gagnantExistant() {
        Plateau pl = FabriquePlateau.createPlateau("1");
        assertFalse(pl.gagnantExistant());
    }

}