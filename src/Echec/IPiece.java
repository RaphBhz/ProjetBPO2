package Echec;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public interface IPiece {

    boolean isPieceInCoords(int colonne, int ligne);

    boolean peutAllerEn(int colonne, int ligne);

    boolean craintEchec();

    int getColonne();
    int getLigne();
    public void setColonne(int i);
    public void setLigne(int i);
    public void setPos(int i, int j);

    void move(int colonne, int ligne);

    String toString();
}
