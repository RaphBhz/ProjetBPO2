package piece;

import utilitaire.Coords;
import Echiquier.Plateau;

/**
 * Classe représentant le roi dans un jeu d'échecs
 * @author LE GAL Florian
 * @date 27/04/2021
 */

public class Roi extends Piece{

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
