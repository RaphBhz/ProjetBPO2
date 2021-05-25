package piece;

/**
 * Enumération représentant les pièces utilisées dans un échiquier
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 13/05/2021
 */
public enum TypesPieces {
    ROI(1),
    TOUR(2);

    private final int nbPiece;

    private TypesPieces(int nbPiece){
        this.nbPiece = nbPiece;
    }

    public int getNbPiece(){
        return this.nbPiece;
    }
}
