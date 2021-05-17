package Echec;

import Echiquier.Coords;
import Echiquier.Plateau;
import piece.Couleur;
import piece.Piece;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public interface IPiece {

    boolean isPieceInCoords(Coords coords);

    boolean peutAllerEn(Coords coords, Plateau pl);

    boolean craintEchec();

    void setPos(Coords coords);

    Couleur getCouleur();

    boolean menace(Coords coords);

    String toString();

    void attack(Piece attacker, Piece attacked);

     void die(Plateau p, Piece dyingPiece, Coords dyingPieceCoords);
}
