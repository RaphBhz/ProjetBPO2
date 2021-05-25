package piece;

import echec.IPiece;
import utilitaire.Coords;

/**
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 13/05/2021
 */
public class FabriquePiece {
    /**
     * Fabrique une pièce avec ses coordonnées et sa couleur
     * @param type ROI = créer un roi | TOUR = créer une tour
     * @return La pièce créée avec ses coordonnées et sa couleur
     */
    public static IPiece createPiece(Couleur couleur, TypesPieces type, Coords coords){
        switch (type){
            case ROI:
                return new Roi(coords, couleur);
            case TOUR:
                return new Tour(coords, couleur);
        }
        return null;
    }

}
