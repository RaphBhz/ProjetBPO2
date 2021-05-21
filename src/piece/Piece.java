package piece;

import Echec.IPiece;
import utilitaire.Coords;
import Echiquier.Plateau;

public abstract class Piece implements IPiece {
    private Coords coords;
    private final Couleur couleur;

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

    public boolean coupLegal(Coords newCoords){
        if (this.coords.equals(newCoords))
            return false;

        return newCoords.isOnBoard();

    }
    @Override
    public boolean peutAllerEn(Coords coords, Plateau pl){
        //Vérif coup pas immobile + Vérif coup dans plateau
        if(!this.coupLegal(coords)){
            System.out.println("peutAllerEn : ERR2: LE COUP N'EST PAS LEGAL");
            return false;

        }
        return true;
    }

    @Override
    public boolean craintEchec() {
        return false;
    }

    @Override
    public Couleur getCouleur(){ return this.couleur; }

    public boolean isBlack(){return this.couleur == Couleur.NOIR;}

    public boolean isSameColor(Piece p){
        return this.couleur == p.couleur;
    }

    @Override
    public void setPos(Coords coords){
        this.coords = coords;
    }
    
    @Override
    public abstract String toString();
}
