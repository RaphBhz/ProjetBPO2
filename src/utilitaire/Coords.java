package utilitaire;

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

    public boolean isOnBoard(){
        return colonne > 0 && colonne < 9 && ligne < 9 && ligne > 0;
    }

    public boolean equals(Coords coords) {
        if (coords == null)
            return false;
        if (this == coords)
            return true;
        return this.ligne == coords.getLigne() && this.colonne == coords.getColonne();
    }

    @Override
    public String toString() {
        return "Coords{" +
                "ligne=" + ligne +
                ", colonne=" + colonne +
                '}';
    }

    public void setCoords(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }
}
