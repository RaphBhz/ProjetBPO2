package piece;

import Echiquier.Coords;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class Roi extends Piece{

    public Roi(Coords coords) {
        super(coords);
    }

    @Override
    public boolean peutAllerEn(Coords coords) {
        //Vérif coup dans plateau
        if(coords.isNotLegal()) { // IMPORTER CONSTANTES ?????????????????
            System.out.println("ERR1: LE COUP N'EST PAS DANS LES COORDS DU PLATEAU");
            return false;
        }
        //Vérif coup légal
        if(!this.coupLegal(coords)){
            System.out.println("ERR2: LE COUP N'EST PAS LEGAL");
            return false;

        }
        //Vérif coup dans range
        return Math.abs(coords.getColonne() - this.getCoords().getColonne()) <= 1 && Math.abs(coords.getLigne() - this.getCoords().getLigne()) <= 1;
    }

    @Override
    public boolean craintEchec() {
        return true;
    }

    @Override
    public boolean coupLegal(Coords coords){
        return true;
    }


    @Override
    public String toString() {
        return "R";
    }


}
