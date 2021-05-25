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

    /**
     * Défini le nombre de pièces sur l'échiquier
     * @param nbPiece le nombre pièces sur l'échiquier
     */
    private TypesPieces(int nbPiece){
        this.nbPiece = nbPiece;
    }

    /**
     * Récupère le nombre de pièces sur l'échiquier
     * @return le nombre de pièces sur l'échiquier
     */
    public int getNbPiece(){
        return this.nbPiece;
    }
}
