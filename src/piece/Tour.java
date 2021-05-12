package piece;

import Echiquier.Coords;
import Echiquier.Plateau;

public class Tour extends Piece{

    public Tour(Coords coords){
        super(coords);
    }

    @Override
    public boolean coupLegal(Coords coords, Plateau pl) {
        return false;
    }

    @Override
    public boolean peutAllerEn(Coords coords, Plateau pl) {
        return false;
    }

    @Override
    public boolean menace(Coords coords) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }
}
