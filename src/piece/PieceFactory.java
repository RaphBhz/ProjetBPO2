package piece;

import Echec.IPiece;
import utilitaire.Coords;

/**
 * @author LE GAL Florian
 * @date 13/05/2021
 */
public class PieceFactory {
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
