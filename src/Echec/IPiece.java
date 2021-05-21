package Echec;

import utilitaire.Coords;
import Echiquier.Plateau;
import piece.Couleur;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public interface IPiece {

    boolean isPieceInCoords(Coords coords);

    boolean peutAllerEn(Coords coords, Plateau pl);

    boolean craintEchec();

    void setPos(Coords coords);

    Coords getCoords();

    Couleur getCouleur();

    String toString();
}
