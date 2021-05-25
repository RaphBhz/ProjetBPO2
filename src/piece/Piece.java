package piece;

import echec.IPiece;
import utilitaire.Coords;

public abstract class Piece implements IPiece {
    private Coords coords;
    private final Couleur couleur;

    /**
     * Constructeur de la pièce
     * @param coords coordonnées de la pièce
     * @param couleur couleur de la pièce
     */
    public Piece(Coords coords, Couleur couleur) {
        this.coords = coords;
        this.couleur = couleur;
    }

    @Override
    public boolean isPieceInCoords(Coords coords) {
        return this.coords.equals(coords);
    }

    @Override
    public Coords getCoords(){return this.coords;}

    @Override
    public boolean coupLegal(Coords newCoords){
        if (this.coords.equals(newCoords))
            return false;

        return newCoords.isOnBoard();

    }

    @Override
    public boolean craintEchec() {
        return false;
    }

    @Override
    public Couleur getCouleur(){ return this.couleur; }

    @Override
    public boolean isBlack(){return this.couleur == Couleur.NOIR;}

    @Override
    public void setPos(Coords coords){
        this.coords = coords;
    }

}
