package piece;

import echiquier.Couleur;
import utilitaire.Coords;
import echiquier.Plateau;

/**
 * Classe représentant la tour dans un jeu d'échecs
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 17/05/2021
 */

public class Tour extends Piece{

    /**
     * Constructeur de la tour
     * @param coords coordonnées de la tour
     * @param couleur couleur de la tour
     */
    public Tour(Coords coords, Couleur couleur){
        super(coords, couleur);
    }

    /**
     * Détermine si une pièce peut aller en des coordonnées données pour un plateau donnée
     * @param newCoords Les nouvelles coordonnées de la tour
     * @param pl Le plateau sur lequel la pièce se situe
     * @return
     */
    @Override
    public boolean peutAllerEn(Coords newCoords, Plateau pl) {

        Coords currentCoords = this.getCoords();
        if (!coupLegal(newCoords))
            return false;

        if (newCoords.getColonne() != currentCoords.getColonne() && newCoords.getLigne() != currentCoords.getLigne())
            return false;

        if (newCoords.getColonne() != currentCoords.getColonne())
            return checkCol(newCoords, pl, currentCoords);

        if (newCoords.getLigne() != currentCoords.getLigne())
            return checkLigne(newCoords, pl, currentCoords);

        return true;
    }

    /**
     * Détermine si une tour peut effectuer un déplacement horizontal ou non
     * @param newCoords Les nouvelles coordonnées de la tour
     * @param pl Le plateau sur lequel la tour se situe
     * @param currentCoords Les actuelles coordonnées de la tour
     * @return true si la tour peut se déplacer jusqu'à la nouvelle colonne ou false dans le cas contraire
     */
    private boolean checkCol(Coords newCoords, Plateau pl, Coords currentCoords){
        int deplacement = 1;

        if(newCoords.getColonne() < currentCoords.getColonne())
            deplacement = -1;

        for (int i = currentCoords.getColonne() + deplacement; i!=newCoords.getColonne(); i+= deplacement) {
            if (pl.isCaseOccupee(new Coords(currentCoords.getLigne(), i)))
                return false;
        }
        return true;

    }

    /**
     * Détermine si une tour peut effectuer un déplacement vertical ou non
     * @param newCoords Les nouvelles coordonnées de la tour
     * @param pl Le plateau sur lequel la tour se situe
     * @param currentCoords Les actuelles coordonnées de la tour
     * @return true si la tour peut se déplacer jusqu'à la nouvelle ligne ou false dans le cas contraire
     */
    private boolean checkLigne(Coords newCoords, Plateau pl, Coords currentCoords){
        int deplacement = 1;

        if(newCoords.getLigne() < currentCoords.getLigne())
            deplacement = -1;
        for (int i = currentCoords.getLigne() + deplacement; i!=newCoords.getLigne(); i+= deplacement) {
            if (pl.isCaseOccupee(new Coords(i, currentCoords.getColonne())))
                return false;
        }
        return true;
    }


    /**
     * Méthode donnant la lettre de la pièce selon le sujet
     * @return t si la pièce est noire ou T si elle est noire
     */
    @Override
    public String toString() {
        return isBlack() ? "t" : "T";
    }
}
