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
        return false;
    }

    @Override
    public boolean craintEchec() {
        return true;
    }

    @Override
    public String toString() {
        return "R";
    }


}
