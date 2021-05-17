package piece;

import Echec.IPiece;
import Echiquier.Coords;
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

    public Coords getCoords(){return this.coords;}

    public boolean coupLegal(Coords newCoords){
        if (this.coords.equals(newCoords))
            return false;

        return !newCoords.isNotOnBoard();

    }
    @Override
    public abstract boolean peutAllerEn(Coords coords, Plateau pl);

    @Override
    public boolean craintEchec() {
        return false;
    }

    @Override
    public abstract boolean menace(Coords coords);

    @Override
    public Couleur getCouleur(){ return this.couleur; }

    public boolean isBlack(){return this.couleur == Couleur.NOIR;}

    @Override
    public void setPos(Coords coords){
        this.coords = coords;
    }
    
    @Override
    public abstract String toString();

    @Override
    public void die(Plateau p, Piece dyingPiece, Coords dyingPieceCoords){///////////////////////

    }

    @Override
    public void attack(Piece attacker, Piece attacked){
        if(attacker.coords == attacked.coords);///////////////////
    }
}
