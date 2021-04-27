package Echec;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public interface IPiece {

    boolean isPieceInCoords(int colonne, int ligne);

    boolean peutAllerEn(int colonne, int ligne);

    boolean craintEchec();

    String toString();
}
