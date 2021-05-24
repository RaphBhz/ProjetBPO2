package Echec;

import utilitaire.Coords;
import Echiquier.Plateau;
import piece.Couleur;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public interface IPiece {

    /**
     * Détermine si une pièce est aux coordonnées données
     * @param coords Les coordonnées à vérifier
     * @return true si la case aux coordonnées données possède une pièce, false dans le cas contraire
     */
    boolean isPieceInCoords(Coords coords);

    /**
     * Détermine si la pièce peut se déplacer sur les nouvelles coordonnées. Attention, on vérifie seulement que les
     * coordonnées sont correctes et qu'elle peut se déplacer selon sa logique
     * @param newCoords Les nouvelles coordonnées de la tour
     * @param pl Le plateau sur lequel la pièce se situe
     * @return true si la pièce peut se déplacer aux nouvelles coordonnées et false dans le cas contraire
     */
    boolean peutAllerEn(Coords newCoords, Plateau pl);

    /**
     * Vérifie si les coordonnées du coup sont différentes des coordonnées actuelles et si les coordonnées sont dans le plateau
     * @param newCoords Les coordoonnées à vérifier
     * @return true si les coordonnées sont déterminées "légales", false dans le cas contraire
     */
    boolean coupLegal(Coords newCoords);

    /**
     * Détermine si une pièce doit craindre l'échec (permet de reconnaitre un roi dans un jeu d'échec normal)
     * @return true si la pièce craint l'échec (roi dans un jeu d'échec normal), false dans le cas contraire
     */
    boolean craintEchec();

    /**
     * Setter permettant de changer la coordonnées d'une pièce
     * @param coords les nouvelles coordonnées de la pièce
     */
    void setPos(Coords coords);

    /**
     * Getter permettant de récupérer les coordonnées d'une pièce
     * @return les coordonnées de la pièce
     */
    Coords getCoords();

    /**
     * Getter permettant de récupérer la couleur d'une pièce
     * @return la couleur de la pièce
     */
    Couleur getCouleur();

    /**
     * Permet de récupérer la chaîne de charactères d'une pièce
     * @return la chaîne de charactères d'une pièce
     */
    String toString();
}
