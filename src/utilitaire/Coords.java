package utilitaire;

import Echiquier.Plateau;

/**
 * Classe utilitaire permettant de représenter des coordonnées plus facilement. Un objet de cette classe est imuable
 * @author LE GAL Florian
 * @date 10/05/2021
 */
public class Coords {
    /**
     * Le x et y des coordonnées
     */
    private int ligne, colonne;

    /**
     * Le constructeur principal d'une coordonnée
     * @param ligne Le x de la coordonnée
     * @param colonne Le y de la coordonnée
     */
    public Coords(int ligne, int colonne){
        this.ligne = ligne;
        this.colonne = colonne;
    }

    /**
     * Le second constructeur d'une coordonnée
     * @param coords Permet de créer une coordonnée à partie d'une autre coordonnée
     */
    public Coords(Coords coords){
        this(coords.ligne, coords.colonne);
    }

    /**
     * Donne le x d'une coordonnée
     * @return La colonne de la coordonnée
     */
    public int getColonne() {
        return colonne;
    }

    /**
     * Donne le y d'une coordonnée
     * @return La ligne de la coordonnée
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Permet de déterminer si la coordonnée respecte les limites d'un échiquier
     * @return
     */
    public boolean isOnBoard(){
        return colonne >= Plateau.MIN && colonne <= Plateau.MAX && ligne <= Plateau.MAX && ligne >= Plateau.MIN;
    }

    /**
     * Permet de déterminer si 2 coordonnées sont égales
     * @param coords La coordonnées que l'on souhaite comparer
     * @return true si les coordonnées sont égales, false dans le cas contraire
     */
    public boolean equals(Coords coords) {
        if (coords == null)
            return false;
        if (this == coords)
            return true;
        return this.ligne == coords.getLigne() && this.colonne == coords.getColonne();
    }

    /**
     * Permet de donner une string des coordonnées.
     * @return Les coordonnées en forme de string
     */
    @Override
    public String toString() {
        return "Coords{" +
                "ligne=" + ligne +
                ", colonne=" + colonne +
                '}';
    }

}
