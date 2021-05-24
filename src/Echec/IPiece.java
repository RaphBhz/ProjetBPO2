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

    /**
     * Détermine si la pièce peut se déplacer sur les nouvelles coordonnées. Attention, on vérifie seulement que les
     * coordonnées sont correctes et qu'elle peut se déplacer selon sa logique
     * @param newCoords Les nouvelles coordonnées de la tour
     * @param pl Le plateau sur lequel la pièce se situe
     * @return true si la pièce peut se déplacer aux nouvelles coordonnées et false dans le cas contraire
     */
    boolean peutAllerEn(Coords newCoords, Plateau pl);

    boolean coupLegal(Coords newCoords);

    boolean craintEchec();

    void setPos(Coords coords);

    Coords getCoords();

    Couleur getCouleur();

    String toString();
}
