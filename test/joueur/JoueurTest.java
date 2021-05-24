package joueur;

import echiquier.FabriquePlateau;
import utilitaire.Coords;
import echiquier.Plateau;
import org.junit.jupiter.api.Test;
import piece.Couleur;
import utilitaire.PaireCoords;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void play() {
        Joueur joueur = new Joueur(Couleur.NOIR);
        Plateau pl = FabriquePlateau.createPlateau("1");
        PaireCoords pc = new PaireCoords(new Coords(1,2), new Coords(2,3));
        assertEquals(pc, joueur.play(pl)); // SCANNER
    }
}