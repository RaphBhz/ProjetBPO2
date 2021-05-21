package piece;

import utilitaire.Coords;
import Echiquier.Plateau;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class Roi extends Piece{

    public Roi(Coords coords, Couleur couleur) {
        super(coords, couleur);
    }

    @Override
    public boolean peutAllerEn(Coords coords, Plateau pl) {

        //Vérif coup dans range
        return super.peutAllerEn(coords, pl) && Math.abs(coords.getColonne() - this.getCoords().getColonne()) <= 1
                && Math.abs(coords.getLigne() - this.getCoords().getLigne()) <= 1;
    }

    @Override
    public boolean craintEchec() {
        return true;
    }


    @Override
    public String toString() {
        return isBlack() ? "r" : "R";
    }

    //Update à faire : faire en sorte que i et j ne correspondent qu'aux cases autour du roi
    //le roi peut ne pas pouvoir bouger s'il est entouré par ses pièces et pourtant ce n'est pas un échec...
    public boolean canMove(Plateau pl) {
        Coords coordCheck = new Coords(0, 0);
        for(int i = 1; i < 9; i++){
            for(int j = 1; i < 9; j++){
                coordCheck.setCoords(i, j);
                if(peutAllerEn(coordCheck, pl));
                    return true;
            }
        }
        return false;
    }
}
