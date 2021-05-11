package Echec;

import Echiquier.Coords;
import Echiquier.Plateau;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public interface IPiece {

    boolean isPieceInCoords(Coords coords);

    boolean peutAllerEn(Coords coords, Plateau pl);

    boolean craintEchec();

    boolean coupLegal(Coords coords, Plateau pl);

    void setPos(Coords coords);

    boolean menace(Coords coords);

    String toString();
}
