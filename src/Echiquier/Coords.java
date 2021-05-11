package Echiquier;

/**
 * @author LE GAL Florian
 * @date 10/05/2021
 */
public class Coords {
    private int ligne, colonne;
    public Coords(int ligne, int colonne){
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public boolean isNotLegal(){
        return colonne > 8 || colonne < 1 || ligne > 8 || ligne < 1;
    }

    public boolean equals(Coords coords) {
        if (coords == null)
            return false;
        if (this == coords)
            return true;
        return this.ligne == coords.getLigne() && this.colonne == coords.getColonne();
    }


}
