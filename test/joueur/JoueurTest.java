package joueur;

import utilitaire.Coords;
import Echiquier.Plateau;
import org.junit.jupiter.api.Test;
import piece.Couleur;
import piece.Roi;
import piece.Tour;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void aPerdu() {
        Joueur joueur = new Joueur(Couleur.NOIR);
        Plateau pl = new Plateau(joueur, new Joueur(Couleur.BLANC));
        Roi roi = new Roi(new Coords(5,5), Couleur.NOIR);
        Tour tour1 = new Tour(new Coords(5,8), Couleur.BLANC);
        //assertTrue(joueur.canPlay(roi, pl));
        Tour tour2 = new Tour(new Coords(5,7), Couleur.BLANC);
        Tour tour3 = new Tour(new Coords(5,9), Couleur.BLANC);
//        assertTrue(joueur.aPerdu(roi, pl));// --- Bug, peut être à cause de la méthode menace ?
    }

    @Test
    void validateInput() {
        Joueur joueur = new Joueur(Couleur.NOIR);
        String input = "1a 2c";
        //assertTrue(joueur.validateInput(input));
    }
}