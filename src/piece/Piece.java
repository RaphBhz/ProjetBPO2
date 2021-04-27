package piece;

public abstract class Piece {
    private int colonne, ligne;

    public Piece(int colonne, int ligne) {
        this.colonne = colonne;
        this.ligne = ligne;
    }

    public boolean isPieceInCoords(int colonne, int ligne) {
        return this.colonne == colonne && this.ligne == ligne;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public abstract boolean peutAllerEn(int colonne, int ligne);

    public boolean craintEchec() {
        return false;
    }

    public abstract String toString();
}
