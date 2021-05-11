package Echiquier;

import org.junit.jupiter.api.Test;

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
    public void isNotLegal() {
        Coords c1 = new Coords(6,1);
        Coords c2 = new Coords(4,2);
        Coords c3 = new Coords(9,1);
        Coords c4 = new Coords(4,9);
        Coords c5 = new Coords(4,0);
        Coords c6 = new Coords(0,2);
        assertFalse(c1.isNotLegal()); //Legal
        assertFalse(c2.isNotLegal()); //Legal
        assertTrue(c3.isNotLegal());  //Pas legal car ligne > 8
        assertTrue(c4.isNotLegal());  //Pas legal car colonne > 8
        assertTrue(c5.isNotLegal());  //Pas legal car colonne < 1
        assertTrue(c6.isNotLegal());  //Pas legal car ligne < 1
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