package Echec;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public interface IPiece {

    boolean isPieceInCoords(int colonne, int ligne);

    boolean peutAllerEn(int colonne, int ligne);

    boolean craintEchec();

    boolean coupLegal(int colonne, int ligne);

    int getColonne();
    int getLigne();
    void setColonne(int i);
    void setLigne(int i);
    void setPos(int i, int j);

    void move(int colonne, int ligne);

    String toString();
}
