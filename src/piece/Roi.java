package piece;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class Roi extends Piece{

    public Roi(int colonne, int ligne) {
        super(colonne, ligne);
    }

    @Override
    public boolean peutAllerEn(int colonne, int ligne) {
        //Vérif coup dans plateau
        if(colonne > 8 || colonne < 1 || ligne > 8|| ligne < 1 ) // IMPORTER CONSTANTES ?????????????????
            return false;
        //Vérif coup légal
        if(!this.coupLegal(colonne, ligne))
            return false;
        //Vérif coup dans range
        return Math.abs(colonne - this.getColonne()) <= 1 && Math.abs(ligne - this.getLigne()) <= 1;
    }

    @Override
    public boolean craintEchec() {
        return true;
    }

    @Override
    public boolean coupLegal(int colonne, int ligne){
        return true;
    }

    @Override
    public void move(int colonne, int ligne) {
        setPos(colonne, ligne);
    }

    @Override
    public String toString() {
        return "R";
    }


}
