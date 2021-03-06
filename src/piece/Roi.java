package piece;

import echiquier.Couleur;
import utilitaire.Coords;
import echiquier.Plateau;

/**
 * Classe représentant le roi dans un jeu d'échecs
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 27/04/2021
 */

public class Roi extends Piece{

    /**
     * Constructeur du roi
     * @param coords coordonnées du roi
     * @param couleur couleur du roi
     */
    public Roi(Coords coords, Couleur couleur) {
        super(coords, couleur);
    }

    @Override
    public boolean peutAllerEn(Coords newCoords, Plateau pl) {

        //Vérif coup dans range
        return coupLegal(newCoords) && Math.abs(newCoords.getColonne() - this.getCoords().getColonne()) <= 1
                && Math.abs(newCoords.getLigne() - this.getCoords().getLigne()) <= 1;
    }

    @Override
    public boolean craintEchec() {
        return true;
    }


    @Override
    public String toString() {
        return isBlack() ? "r" : "R";
    }

}
