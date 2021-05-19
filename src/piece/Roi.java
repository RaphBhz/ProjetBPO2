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
        //Vérif coup dans plateau
        if(!coords.isOnBoard()) { // IMPORTER CONSTANTES ?????????????????
            System.out.println("peutAllerEn : ERR1: LE COUP N'EST PAS DANS LES COORDS DU PLATEAU");
            return false;
        }
        //Vérif coup légal
        if(!this.coupLegal(coords)){
            System.out.println("peutAllerEn : ERR2: LE COUP N'EST PAS LEGAL");
            return false;

        }

        if (!pl.isCaseSafe(coords, this.getCouleur())) {
            System.out.println("peutAllerEn : ERR3: LA CASE VISEE N'EST PAS SAFE");
            return false;
        }

        //Vérif coup dans range et pas immobile
        return Math.abs(coords.getColonne() - this.getCoords().getColonne()) <= 1 && Math.abs(coords.getLigne() - this.getCoords().getLigne()) <= 1
                && !(this.getCoords().equals(coords));
    }

    @Override
    public boolean craintEchec() {
        return true;
    }


    @Override
    public boolean menace(Coords coords){
        return Math.abs(this.getCoords().getLigne() - coords.getLigne()) <=1 && Math.abs(this.getCoords().getColonne() - coords.getColonne()) <= 1
                && !(this.getCoords().equals(coords));
    }

    @Override
    public String toString() {
        return isBlack() ? "r" : "R";
    }

    //Update à faire : faire en sorte que i et j ne correspondent qu'aux cases autour du roi
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
