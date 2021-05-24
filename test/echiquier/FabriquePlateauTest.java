package echiquier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabriquePlateauTest {

    @Test
    void createPlateau() {
        Plateau pl = FabriquePlateau.createPlateau("1");
        assertEquals(pl.toString(),FabriquePlateau.createPlateau("1").toString());
    }
}