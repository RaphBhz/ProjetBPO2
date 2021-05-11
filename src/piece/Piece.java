package piece;

import Echec.IPiece;
import Echiquier.Coords;
import Echiquier.Plateau;

public abstract class Piece implements IPiece {
    private Coords coords;

    public Piece(Coords coords) {
        this.coords = coords;
    }

    @Override
    public boolean isPieceInCoords(Coords coords) {
        return this.coords.equals(coords);
    }

    public Coords getCoords(){return this.coords;}

    @Override
    public abstract boolean coupLegal(Coords coords, Plateau pl);

    @Override
    public abstract boolean peutAllerEn(Coords coords, Plateau pl);

    @Override
    public boolean craintEchec() {
        return false;
    }

    @Override
    public abstract boolean menace(Coords coords);

    @Override
    public void setPos(Coords coords){
        this.coords = coords;
    }
    
    @Override
    public abstract String toString();
}
