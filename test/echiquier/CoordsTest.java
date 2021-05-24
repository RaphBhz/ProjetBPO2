package echiquier;

import org.junit.jupiter.api.Test;
import utilitaire.Coords;

import static org.junit.jupiter.api.Assertions.*;

class CoordsTest {

    @Test
    public void getColonne() {
        Coords c1 = new Coords(1,1);
        Coords c2 = new Coords(1,3);
        assertEquals(1,c1.getColonne());
        assertEquals(3,c2.getColonne());
    }

    @Test
    public void getLigne() {
        Coords c1 = new Coords(2,1);
        Coords c2 = new Coords(5,2);
        assertEquals(2,c1.getLigne());
        assertEquals(5,c2.getLigne());
    }

    @Test
    public void testIsNotOnBoard() {
        Coords c1 = new Coords(6,1);
        Coords c2 = new Coords(4,2);
        Coords c3 = new Coords(9,1);
        Coords c4 = new Coords(4,9);
        Coords c5 = new Coords(4,0);
        Coords c6 = new Coords(0,2);
        assertTrue(c1.isOnBoard()); //Legal
        assertTrue(c2.isOnBoard()); //Legal
        assertFalse(c3.isOnBoard());  //Pas legal car ligne > 8
        assertFalse(c4.isOnBoard());  //Pas legal car colonne > 8
        assertFalse(c5.isOnBoard());  //Pas legal car colonne < 1
        assertFalse(c6.isOnBoard());  //Pas legal car ligne < 1
    }

    @Test
    public void testEquals(){
        Coords c1 = new Coords(1,1);
        Coords c2 = new Coords(1,1);
        Coords c3 = new Coords(2,1);
        Coords c4 = new Coords(1,2);
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
        assertFalse(c1.equals(c4));
        assertFalse(c3.equals(c4));
    }
}