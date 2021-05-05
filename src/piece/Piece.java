package piece;

import Echec.IPiece;

public abstract class Piece implements IPiece {
    private int colonne, ligne;

    public Piece(int colonne, int ligne) {
        this.colonne = colonne;
        this.ligne = ligne;
    }

    @Override
    public boolean isPieceInCoords(int colonne, int ligne) {
        return this.colonne == colonne && this.ligne == ligne;
    }

    @Override
    public int getLigne() {
        return ligne;
    }

    @Override
    public int getColonne() {
        return colonne;
    }

    @Override
    public abstract boolean coupLegal(int colonne, int ligne);

    @Override
    public abstract boolean peutAllerEn(int colonne, int ligne);

    @Override
    public boolean craintEchec() {
        return false;
    }

    @Override
    public void setColonne(int i){
        this.colonne = i;
    }

    @Override
    public void setLigne(int i){
        this.ligne = i;
    }

    @Override
    public void setPos(int i, int j){
        setColonne(i);
        setLigne(j);
    }
    
    @Override
    public abstract String toString();
}
