package Echec;

import Echiquier.Coords;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public interface IPiece {

    boolean isPieceInCoords(Coords coords);

    boolean peutAllerEn(Coords coords);

    boolean craintEchec();

    boolean coupLegal(Coords coords);

    void setPos(Coords coords);

    String toString();
}
